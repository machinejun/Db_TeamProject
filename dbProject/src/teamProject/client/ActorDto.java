package teamProject.client;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
	
	ArrayList<RoleDto> roleList = new ArrayList<RoleDto>();
	
	/*
	RoleList roleList = new RoleList();

	@Data
	class RoleList {
		String roleName;
		String category;
	}
	*/
	
}