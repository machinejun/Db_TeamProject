package teamProject.server.db;

import java.util.ArrayList;
import java.util.List;

public class MainTest {

	public static void main(String[] args) {
		List<Dto> data = new ArrayList<Dto>();
		MovieAndActorDao dao= new MovieAndActorDao();
		
		MovieDto dto = new MovieDto();
		
		//dto = (MovieDto) dao.SearchMovieInfo("어벤져스");
		data = dao.SearchActorInfo("마동석");
		
		
		for (int i = 0; i < data.size(); i++) {
			System.out.println(data.get(i));
			System.out.println(data.get(i).getTitle());
			System.out.println(data.get(i).getActorName());
		}
		
		
		/*
		for (int i = 0; i < dto.roleList.size(); i++) {
			System.out.println(dto.roleList.get(i).getActorName());
		}
		*/
		
		//System.out.println(dto.getRoleList().get(2).getActorName());
	}

}
