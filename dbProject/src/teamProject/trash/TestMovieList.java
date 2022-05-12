package teamProject.trash;

import java.util.ArrayList;

import lombok.Getter;

@Getter
public class TestMovieList {
	
	ArrayList<String> moviename = new ArrayList<String>();
	
	public TestMovieList() {
		moviename.add("도라에몽1");
		moviename.add("도라에몽2");
		moviename.add("도라에몽3");
		moviename.add("도라에몽4");
		moviename.add("도라에몽5");
		moviename.add("도라에몽6");
		moviename.add("도라에몽7");
	}

}
