package teamProject.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.SocketException;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

import teamProject.view.ClientFrame;

public class ClientPro  implements ClientInterface{
	private Socket socket;
	private ClientFrame view;
	private static String IP = "localhost";
	private static int PORT_NUM = 4000;
	private String id;
	private InputStream inputStream;
	private OutputStream outputStream;
	private DataInputStream dataInputStream;
	private DataOutputStream dataOutputStream;
	

	public ClientPro(ClientFrame clientView) {
		this.view = clientView;
		login(IP, PORT_NUM);

	}
	
	public void login(String ip, int portNumber) {
		try {
			socket = new Socket(ip, portNumber);
			
			
			inputStream = socket.getInputStream();
			dataInputStream = new DataInputStream(inputStream);

			outputStream = socket.getOutputStream();
			dataOutputStream = new DataOutputStream(outputStream);
			
			sentMsg("connect/nt/0");
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

						switch (protocol[0]) {
						case "connect":
							id = protocol[1];
							break;
						case "connectM":

							break;
						case "connectA":
							
							break;
						case "recent":

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
	

	
	private void sentMsg(String msg) {
		try {
			
			dataOutputStream.writeUTF(msg);
			dataOutputStream.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	

	@Override
	public void loadListMoive() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void loadListActor() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void loadRecentMovie() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void SearchMovieInfo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void SearchActorInfo() {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		new ClientPro(new ClientFrame());
	}
}
