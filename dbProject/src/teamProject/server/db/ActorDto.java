package teamProject.db;

import java.util.ArrayList;

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
	
	RoleDto roleDto;
	
	/*
	RoleList roleList = new RoleList();

	@Data
	class RoleList {
		String roleName;
		String category;
	}
	*/
	
}