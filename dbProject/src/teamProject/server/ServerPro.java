package teamProject.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;
import java.util.Vector;

import com.google.gson.Gson;

import teamProject.db.MovieAndActorDao;


public class ServerPro{
	static int USER_ID = 0;
	private ServerPro mcontext;
	private MovieAndActorDao dao;
	private ServerSocket serverSocket;
	private Socket socket;
	private static int PORT_NUMBER = 4000;
	private Vector<User> users;
	private Gson gson;

	public ServerPro() {
		dao = new MovieAndActorDao();
		mcontext = this;
		users = new Vector<User>();
		gson = new Gson();
		connect();
	}

	private void connect() {
		try {
			serverSocket = new ServerSocket(PORT_NUMBER);
			System.err.println("서버를 시작합니다.");

			new Thread(new Runnable() {

				@Override
				public void run() {
					while (true) {
						try {
							socket = serverSocket.accept();
							User user = new User(socket, mcontext, USER_ID);
							users.add(user);
							user.start();
							StringBuffer jsonString = new StringBuffer();
							jsonString.append("connect/" + (USER_ID++));
							user.sentJson(jsonString.toString());
							loadListMoive();
							loadListActor();
							loadRecentMovie();
						} catch (IOException e) {
							System.err.println("연결 실패");
							e.printStackTrace();
						}
					}

				}
			}).start();
		} catch (IOException e) {
			System.err.println("사용중인 포트입니다.");
			e.printStackTrace();
		}

	}

	/*
	 * protocol
	 * 
	 * server <<< client 메세지 recent/ selectM/moviename/id selectA/actorname/id
	 * 
	 * server >>> client 메세지
	 * 
	 * connectM/{무비이름리스트} connectA/{배우이름리스트} recent/json{무비이름리스트} selectM/json[무비정보]
	 * selectA/json[배우정보] updateM/json{무비 이름 리스트} updateA/json{배우 이름 리스트}
	 * 
	 */

	public void actionProtocol(String message) {
		StringTokenizer tokenizer = new StringTokenizer(message, "/");
		String[] protocol = new String[3];
		protocol[0] = tokenizer.nextToken();
		protocol[1] = tokenizer.nextToken();
		protocol[2] = tokenizer.nextToken();
		int id = Integer.parseInt(protocol[2]);
		try {
			switch (protocol[0]) {
				case "selectM":
					findUser(id).sentJson(searchMovieInfo(protocol[1]));
					break;
				case "selectA":
					findUser(id).sentJson(searchActorInfo(protocol[1]));
					break;
				default:
					break;
			}
		} catch (NullPointerException e) {
			System.err.println("매칭되는 User ID가 없음");
		}
	}

	public String loadListMoive() {
		StringBuffer jsonString = new StringBuffer();
		jsonString.append("connectM/");
		jsonString.append(gson.toJson(dao.loadListMoive()));
		return jsonString.toString();
	}


	public String loadListActor() {
		StringBuffer jsonString = new StringBuffer();
		jsonString.append("connectA/");
		jsonString.append(gson.toJson(dao.loadListActor()));
		return jsonString.toString();
	}


	public String loadRecentMovie() {
		StringBuffer jsonString = new StringBuffer();
		jsonString.append("recent/");
		jsonString.append(gson.toJson(dao.loadRecentMovie()));
		return jsonString.toString();

	}

	public String searchMovieInfo(String movieName) {
		StringBuffer jsonString = new StringBuffer();
		jsonString.append("selectM/");
		jsonString.append(gson.toJson(dao.SearchMovieInfo(movieName)));
		return jsonString.toString();
	}


	public String searchActorInfo(String actorName) {
		StringBuffer jsonString = new StringBuffer();
		jsonString.append("selectA/");
		jsonString.append(gson.toJson(dao.SearchMovieInfo(actorName)));
		return jsonString.toString();
	}

	public void updateMovie() {
		for (User user : users) {
			user.sentJson("connectM/" + loadListMoive());
			user.sentJson("connectA/" + loadListMoive());
			user.sentJson("recent/" + loadRecentMovie());
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
	
	public static void main(String[] args) {
		new ServerPro();
	}
}
