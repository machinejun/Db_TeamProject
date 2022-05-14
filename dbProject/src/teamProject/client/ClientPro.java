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

import lombok.Getter;
import teamProject.client.view.ClientFrame;


@Getter
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
						String[] protocol = getMsg(log);
						System.out.println("@ 앞부분: " + protocol[0]);
						System.out.println("@ 뒷부분: " + protocol[1]);
						
						switch (protocol[0]) {
						case "connect":
							id = protocol[1];
							break;
						case "loadM":
							loadListMoive(protocol[1]);
							break;
						case "loadA":
							loadListActor(protocol[1]);
							break;
						case "loadR":
							loadRecentMovie(protocol[1]);
							break;
						case "selectM":
							searchMovieInfo(protocol[1]);
							break;
						case "selectA":
							searchActorInfo(protocol[1]);
							break;
						case "imageM":
							System.out.println(protocol[1]);
							view.getMoviePanel().insertImage(protocol[1]);
							break;
						case "imageA":
							System.out.println("배우 이미지 넣기 프로토콜 확인: " + protocol[1]);
							view.getActorPanel().insertImage(protocol[1]);
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
		StringTokenizer dividing = new StringTokenizer(msg, "@");
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
	public void loadListMoive(String josn) {
		Type postType = new TypeToken<ArrayList<Dto>>() {}.getType();
		movieList = gson.fromJson(josn, postType);
		Vector<String> movieName = new Vector<String>();
		for (Dto dto : movieList) {
			movieName.add(dto.getTitle());
		}
		view.movieListUpdate(movieName);
	}

	@Override
	public void loadListActor(String json) {
		Type postType = new TypeToken<ArrayList<Dto>>() {}.getType();
		ActorList = gson.fromJson(json, postType);
		Vector<String> actorName = new Vector<String>();
		for (Dto dto : ActorList) {
			actorName.add(dto.getActorName());
		}
		view.actorListUpdate(actorName);
	}
		
	

	@Override
	public void loadRecentMovie(String json) {
		Type postType = new TypeToken<ArrayList<Dto>>() {}.getType();
		recentList = gson.fromJson(json, postType);
		Vector<String> RmovieName = new Vector<String>();
		for (Dto dto : recentList) {
			RmovieName.add(dto.getTitle());
		}
		view.rMovieListUpdate(RmovieName);
		
	}

	@Override
	public void searchMovieInfo(String json) {
		MovieDto movie = gson.fromJson(json, MovieDto.class);
		System.out.println(movie);
		view.selctMovieUpdate(movie);
		
	}

	@Override
	public void searchActorInfo(String json) {
		ActorDto actor = gson.fromJson(json, ActorDto.class);
		System.out.println(actor);
		view.selctAcotrUpdate(actor);
		
	}


}
