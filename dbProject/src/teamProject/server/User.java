package teamProject.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.print.attribute.standard.Severity;

import lombok.Setter;

@Setter
public class User extends Thread{

	private int id;
	private Socket userSocket;
	private ServerPro server;
	
	private DataInputStream dataInputStream;
	private DataOutputStream dataOutputStream;
	
	public User(Socket userSocket, ServerPro server, int id) {
		this.userSocket = userSocket;
		this.server = server;
		this.id = id;
	}
	
	public int getUserid() {
		return id;
	}
	
	
	@Override
	public void run() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						dataInputStream = new DataInputStream(userSocket.getInputStream());
						dataOutputStream = new DataOutputStream(userSocket.getOutputStream());

						String msg = dataInputStream.readUTF();
						server.actionProtocol(msg);
					} catch (IOException e) {
						try {
							dataInputStream.close();
							dataOutputStream.close();
							break;
						} catch (IOException e1) {
							try {
								dataInputStream.close();
								dataOutputStream.close();
							} catch (IOException e2) {
								e2.printStackTrace();
							}
							e1.printStackTrace();
						}
						
					}

				}
			}
		}).start();
	}
	
	public void sentJson(String msg) {
		try {
			dataOutputStream.writeUTF(msg);
			dataOutputStream.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
