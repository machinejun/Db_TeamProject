package teamProject.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

import teamProject.view.ClientFrame;

public class ClientPro  implements ClientInterface{
	private Socket socket;
	private ClientFrame view;
	private InputStream inputStream;
	private OutputStream outputStream;
	private DataInputStream dataInputStream;
	private DataOutputStream dataOutputStream;
	private static String IP = "localhost";
	private static int PORT_NUM = 4000;
	private int id;
	

	public ClientPro(ClientFrame clientView) {
		this.view = clientView;

	}


	public boolean login() {
		try {
			socket = new Socket(IP, PORT_NUM );
			
			inputStream = socket.getInputStream();
			dataInputStream = new DataInputStream(inputStream);

			outputStream = socket.getOutputStream();
			dataOutputStream = new DataOutputStream(outputStream);
			
			runClient();
			return true;
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "연결실패!", "알림", JOptionPane.ERROR_MESSAGE);
			return false;
		}

	}

	public void runClient() {

		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						String msg = dataInputStream.readUTF();
						String[] protocol = getMessage(msg);

						switch (protocol[0]) {
						case "connect":
							id = Integer.parseInt(protocol[1]);
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
	
	private void sentMsg(String msg) {
		try {
			dataOutputStream.writeUTF(msg);
			dataOutputStream.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	private String[] getMessage(String msg) {
		StringTokenizer dividing = new StringTokenizer(msg, "/");
		String MsgHead = dividing.nextToken();
		String MsgBody = dividing.nextToken();

		String[] protocol = new String[2];

		protocol[0] = MsgHead;
		protocol[1] = MsgBody;

		return protocol;
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
