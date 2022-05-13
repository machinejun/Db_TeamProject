package teamProject.client;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MovieDto extends Dto {

	private String releaseDate;
	private String genre;	
	private float starScore;	
	private String imageFileName;
	
	private ScoreDto scoreDto;
	
	ArrayList<RoleDto> roleList = new ArrayList<RoleDto>();
	
	/*
	MovieActorList movieActorList = new MovieActorList();
	MovieScoreList movieScoreList = new MovieScoreList();

	@Data
	class MovieActorList {
		String actorName;
		String category;
		String roleName;
	}

	@Data
	class MovieScoreList {
		int audience;
		int sales;
	}
	*/
	

}