package teamProject.db;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieDto extends Dto {

	private String releaseDate;
	private String genre;	
	private float starScore;	
	private String imageFileName;
	
	ArrayList<RoleDto> roleList = new ArrayList<RoleDto>();
	ArrayList<ScoreDto> scoreList = new ArrayList<ScoreDto>();
	
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
