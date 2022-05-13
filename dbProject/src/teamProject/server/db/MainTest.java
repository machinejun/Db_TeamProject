package teamProject.server.db;

import java.util.ArrayList;
import java.util.List;

public class MainTest {

	public static void main(String[] args) {
		List<Dto> data = new ArrayList<Dto>();
		MovieAndActorDao dao= new MovieAndActorDao();
		
		Dto dto = new Dto();
		
		dto = (MovieDto) dao.SearchMovieInfo("어벤져스");
		//data = dao.loadListActor();
		
		
		for (int i = 0; i < data.size(); i++) {
			System.out.println(data.get(i));
//			System.out.println(data.get(i).getTitle());
//			System.out.println(data.get(i).getActorName());
		}
		
		
		/*
		for (int i = 0; i < dto.roleList.size(); i++) {
			System.out.println(dto.roleList.get(i).getActorName());
		}
		*/
		
		System.out.println(dto);
	}

}
