package ch02;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActorDto extends Dto {
	
	private int id;
	private int weight;
	private int height;
	private int birthYear;
	private String partner;
	private String imageFileName;
	
}
