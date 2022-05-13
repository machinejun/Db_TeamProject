package teamProject.trash;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.google.gson.JsonArray;

public class ServerTest {
	static int port;
	
	public static void main(String[] args) {
		port = 8000;
		try {
			ServerSocket serverSocket = new ServerSocket(port);
			System.err.println("Server is running on port :" + port );
			while(true) {
				try {
					Socket clinetSocket = serverSocket.accept();
					System.err.println("client connected");
					
					BufferedReader in = new BufferedReader(new InputStreamReader(clinetSocket.getInputStream()));
					
					String s;
					while((s = in.readLine()) != null) {
						System.out.println(s);
						if(s.isEmpty()) {
							break;
						}
					}
					
					JSONObject jobject = new JSONObject();
					jobject.put("name", "길동");
					jobject.put("age", 10);
					jobject.put("address", "부산");
					
					/*
					 * -- json 리스트 만들어서 오브젝트 넣는법
					 * JSONArray jarray = new JSONArray();
					 * jarray.add(jobject);
					 * 
					 */
					
					
					
					BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(clinetSocket.getOutputStream()));
					bufferedWriter.write("HTTP/1.1 200 OK\r\n");
					bufferedWriter.write("\r\n");
					bufferedWriter.write((jobject + "\r\n"));
					bufferedWriter.write("\r\n\r\n");
					bufferedWriter.flush();
					System.err.println("clinet connection closed");
					in.close();
					bufferedWriter.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
