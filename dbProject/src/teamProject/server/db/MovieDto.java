package teamProject.server.db;

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
	private ScoreDto scoreDto;

	ArrayList<RoleDto> roleList = new ArrayList<RoleDto>();

}