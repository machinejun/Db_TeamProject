package teamProject.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import lombok.Setter;

@Setter
public class User extends Thread {
	private ServerPro server;

	private int id = 0;
	private Socket userSocket;

	private DataInputStream dataInputStream;
	private DataOutputStream dataOutputStream;


	public User(Socket userSocket, ServerPro server) {
		this.userSocket = userSocket;
		this.server = server;
		server.getUsers().add(this);

	}

	public int getUserid() {
		return id;
	}

	@Override
	public void run() {
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.err.println(id + " User 가 동작");
				while (true) {
					try {
						dataInputStream = new DataInputStream(userSocket.getInputStream());
						dataOutputStream = new DataOutputStream(userSocket.getOutputStream());

						String msg = dataInputStream.readUTF();
						System.out.println(msg);
						server.actionProtocol(msg);
					} catch (IOException e) {
						try {

							dataInputStream.close();
							dataOutputStream.close();
							break;
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}

				}
			}
		}).start();

	}

	public void sentMsg(String msg) {
		try {
			dataOutputStream.writeUTF(msg + "\n");
			dataOutputStream.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
