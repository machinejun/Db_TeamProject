package teamProject.trash;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;


public class ClientTest {
	public static void main(String[] args) {
		try {
			URL url = new URL("http://localhost:8000");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.connect();
			int stausCod = connection.getResponseCode();
			System.out.println("stausCode:" + stausCod);
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuffer sb = new StringBuffer();
			String line = null;
			
			if(stausCod == 200) {
				while((line = reader.readLine()) != null ){
					sb.append(line + "\n" );
				}
			}
			String str = sb.toString();
			System.out.println(str);
			
			Gson gson = new Gson();
			Person person = gson.fromJson(str, Person.class); //Reflection 기법
			System.out.println(person.name);
			System.out.println(person.age);
			System.out.println(person.address);
			
			
			//connection.setRequestMethod("POST");
			BufferedWriter w = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));
			w.write("hello~~\r\n");
			w.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
