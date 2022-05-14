package teamProject.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.google.gson.Gson;

import lombok.Getter;
import lombok.Setter;
import teamProject.server.db.ActorDto;
import teamProject.server.db.MovieAndActorDao;
import teamProject.server.db.MovieDto;

@Getter
@Setter
public class ServerPro implements ServerInterface {
	private ServerPro mContext;
	private MovieAndActorDao dao;
	private ServerSocket serverSocket;
	private Socket socket;
	private static int PORT_NUMBER = 4000;
	private Vector<User> users;
	private Gson gson;
	static int COUNT_ID = 1;

	public ServerPro() {
		mContext = this;
		users = new Vector<User>();
		gson = new Gson();
		dao = new MovieAndActorDao();
		startNetwork(PORT_NUMBER);
	}

	public void startNetwork(int portNumber) {
		try {
			System.err.println("서버를 시작합니다.");
			serverSocket = new ServerSocket(portNumber);
			linkSomeone();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "이미 사용중인 포트입니다.", "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "잘못 입력하셨습니다.", "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

	}

	public void linkSomeone() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					try {
						socket = serverSocket.accept();
						User user = new User(socket, mContext);
						System.err.println("someone connect");
						user.start();

					} catch (IOException e) {
						JOptionPane.showMessageDialog(null, "유저 접속 오류", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}

			}
		}).start();

	}

	/*
	 * protocol
	 * 
	 * server <<< client 메세지 
	 * recent/ 
	 * selectM/moviename/id 
	 * selectA/actorname/id
	 * 
	 * server >>> client 메세지
	 * 
	 * connectM/{무비이름리스트} 
	 * connectA/{배우이름리스트} 
	 * recent/json{무비이름리스트} 
	 * selectM/json[무비정보]
	 * selectA/json[배우정보] 
	 * updateM/json{무비 이름 리스트} 
	 * updateA/json{배우 이름 리스트}
	 * 
	 */

	public void actionProtocol(String message) {
		StringTokenizer tokenizer = new StringTokenizer(message, "/");
		String[] protocol = new String[3];
		protocol[0] = tokenizer.nextToken();
		protocol[1] = tokenizer.nextToken();
		protocol[2] = tokenizer.nextToken();
		System.out.println(protocol[2]);
		int id = Integer.parseInt(protocol[2].replace("\n", ""));
	
		try {
			switch (protocol[0]) {
			case "connect":
				for (User user : users) {
					if (user.getUserid() == 0) {
						user.setId(COUNT_ID++);
						user.sentMsg("connect@" + user.getUserid());
					}
				}
				broadCast();
				break;
			case "selectM":
				findUser(id).sentMsg(searchMovieInfo(protocol[1] , id));
				break;
			case "selectA":
				findUser(id).sentMsg(searchActorInfo(protocol[1], id));
				break;
			default:
				break;
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
			System.err.println("db에 데이터 없음");
		}
	}

	@Override
	public String loadListMoive() {
		StringBuffer jsonString = new StringBuffer();
		jsonString.append("loadM@" + gson.toJson(dao.loadListMoive()));
		return jsonString.toString();
	}

	@Override
	public String loadListActor() {
		StringBuffer jsonString = new StringBuffer();
		jsonString.append("loadA@" + gson.toJson(dao.loadListActor()));
		return jsonString.toString();

	}

	@Override
	public String loadRecentMovie() {
		StringBuffer jsonString = new StringBuffer();
		jsonString.append("loadR@" + gson.toJson(dao.loadRecentMovie()));
		return jsonString.toString();

	}

	@Override
	public String searchMovieInfo(String movieName, int id) {
		StringBuffer jsonString = new StringBuffer();
		MovieDto mdto = dao.searchMovieInfo(movieName);
		sentImageMUrl(mdto.getImageFileName(), id);
		mdto.setImageFileName("");
		jsonString.append("selectM@" + gson.toJson(mdto));
		
		return jsonString.toString();
	}

	@Override
	public String searchActorInfo(String actorName, int id) {
		StringBuffer jsonString = new StringBuffer();
		ActorDto adto = dao.searchActorInfo(actorName);
		sentImageAUrl(adto.getImageFileName(), id);
		adto.setImageFileName("");
		jsonString.append("selectA@" + gson.toJson(adto));
		return jsonString.toString();
	}

	public void broadCast() {
		for (User user : users) {
			user.sentMsg(loadListMoive());
			user.sentMsg(loadListActor());
			user.sentMsg(loadRecentMovie());
		}
	}

	private User findUser(int id) {
		for (User u : users) {
			if (u.getUserid() == id) {
				return u;
			}
		}
		return null;

	}
	
	private String sentImageMUrl(String url, int id) {
		findUser(id).sentMsg("imageM@" + url);
		return "";
	}
	
	private String sentImageAUrl(String url, int id) {
		findUser(id).sentMsg("imageA@" + url);
		return "";
	}

	public static void main(String[] args) {
		new ServerPro();
	}
}
