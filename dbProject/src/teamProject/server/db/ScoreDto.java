package teamProject.server.db;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScoreDto extends Dto {
	
	private int audience;
	private int sales;
}
