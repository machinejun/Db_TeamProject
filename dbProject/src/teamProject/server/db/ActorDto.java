package teamProject.server.db;

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
	
<<<<<<< HEAD
	ArrayList<RoleDto> roleList = new ArrayList<RoleDto>();
	
	/*
	RoleList roleList = new RoleList();
=======
	RoleDto roleDto;
>>>>>>> feature-jh

}