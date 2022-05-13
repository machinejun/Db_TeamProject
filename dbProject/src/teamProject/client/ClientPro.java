package teamProject.client;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import teamProject.view.ClientFrame;

public class ClientPro  implements ClientInterface{
	
	private Socket socket;
	private ClientFrame view;
	private static String IP = "localhost";
	private static int PORT_NUM = 4000;
	private String id = "";

	private DataInputStream dataInputStream;
	private DataOutputStream dataOutputStream;
	private Gson gson;
	private List<Dto> movieList = new Vector<Dto>();
	private List<Dto> ActorList = new Vector<Dto>();
	private List<Dto> recentList = new Vector<Dto>();

	public ClientPro(ClientFrame clientView) {
		gson = new Gson();
		this.view = clientView;
		login(IP, PORT_NUM);

	}
	
	public void login(String ip, int portNumber) {
		try {
			socket = new Socket(ip, portNumber);

			dataInputStream = new DataInputStream(socket.getInputStream());
			dataOutputStream = new DataOutputStream(socket.getOutputStream());
			
			sentMsg("connect/0/0");
			runPro();

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "연결실패!", "알림", JOptionPane.ERROR_MESSAGE);
		}

	}

	public void runPro() {

		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						String log = dataInputStream.readUTF();
						System.out.println(log);
						String[] protocol = getMsg(log);
						Type postType = new TypeToken<ArrayList<Dto>>() {}.getType();
						
						switch (protocol[0]) {
						case "connect":
							id = protocol[1];
							break;
						case "loadM":
							movieList = gson.fromJson(protocol[1], postType);
							System.out.println("loadM/" + movieList);
							loadListMoive(movieList);
							break;
						case "loadA":
							ActorList = gson.fromJson(protocol[1], postType);
							System.out.println("loadA/" + ActorList);
							loadListActor(ActorList);
							break;
						case "loadR":
							recentList = gson.fromJson(protocol[1], postType);
							System.out.println("loadR/" + recentList);
							loadRecentMovie(recentList);
							break;
						case "selectM":
							
							break;
						case "selectA":
							
							break;
						}
						
					} catch(SocketException e){
						JOptionPane.showMessageDialog(null, "서바가 다운되었습니다.");
						System.exit(0);
					}catch (IOException e) {
						e.printStackTrace();
					}
				}

			}
		}).start();
	}
	
	public String[] getMsg(String msg) {
		StringTokenizer dividing = new StringTokenizer(msg, "/");
		String msgHead = dividing.nextToken();
		String msgBody = dividing.nextToken();

		String[] protocol = new String[2];

		protocol[0] = msgHead;
		protocol[1] = msgBody;

		return protocol;
	}
	

	@Override
	public void sentMsg(String msg) {
		try {
			
			dataOutputStream.writeUTF(msg);
			dataOutputStream.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	@Override
	public void loadListMoive(List<Dto> movielist) {
		Vector<String> movieName = new Vector<String>();
		for (Dto dto : movielist) {
			movieName.add(dto.getTitle());
		}
		view.movielistupdate(movieName);
	}

	@Override
	public void loadListActor(List<Dto> actorlist) {
		Vector<String> actorName = new Vector<String>();
		for (Dto dto : actorlist) {
			actorName.add(dto.getActorName());
		}
		view.actorlistupdate(actorName);
	}
		
	

	@Override
	public void loadRecentMovie(List<Dto> movielist) {
		Vector<String> RmovieName = new Vector<String>();
		for (Dto dto : movielist) {
			RmovieName.add(dto.getTitle());
		}
		view.rMovielistupdate(RmovieName);
		
	}

	@Override
	public void SearchMovieInfo(String movieName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void SearchActorInfo(String string) {
		
		
	}


}
