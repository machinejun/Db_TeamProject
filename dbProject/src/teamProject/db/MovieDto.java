package ch02;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieDto extends Dto {

	private String releaseDate;
	private String genre;	
	private float starScore;	
	private String imageFileName;
	
	ArrayList<String> actorList = new ArrayList<String>();
	
	class MovieActorList {
		String acotorName;
		String category;
		String roleName;
	}

}
