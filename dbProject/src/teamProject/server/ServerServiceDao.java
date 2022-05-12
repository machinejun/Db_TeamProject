package teamProject.server;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServerServiceDao implements DaoInterface<Dto> {
	
	private DBClient dbClient;
	private Connection connection;
	
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	private List<Dto> resultList = null;
	
	public ServerServiceDao() {
		dbClient = DBClient.getInstance();
		connection = dbClient.getConnection();
	}

	@Override
	public List<Dto> loadListMoive() {
		resultList = new ArrayList<Dto>();
		String selectQuery = "SELECT * FROM movie ";

		try {
			preparedStatement = connection.prepareStatement(selectQuery);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				MovieDto movieDto = new MovieDto();
				movieDto.setTitle(resultSet.getString("title"));
				movieDto.setReleaseDate(resultSet.getString("releaseDate"));
				movieDto.setGenre(resultSet.getString("genre"));
				movieDto.setStarScore(resultSet.getFloat("starScore"));
				movieDto.setImageFileName(resultSet.getString("image"));
				resultList.add(movieDto);
			}
			

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resultList;
	}

	@Override
	public List<Dto> loadListActor() {
		resultList = new ArrayList<Dto>();
		String selectQuery = "SELECT * FROM actor ";
		
		try {
			preparedStatement = connection.prepareStatement(selectQuery);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				ActorDto actorDto = new ActorDto();
				actorDto.setActorName(resultSet.getString("actorName"));
				
				resultList.add(actorDto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return resultList;
	}

	@Override
	public List<Dto> loadRecentMovie() {
		resultList = new ArrayList<Dto>();
		String selectQuery = "SELECT *\r\n"
							+ "FROM movie\r\n"
							+ "ORDER BY releaseDate DESC ";
		
		try {
			preparedStatement = connection.prepareStatement(selectQuery);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				MovieDto dto = new MovieDto();
				dto.setTitle(resultSet.getString("title"));
				dto.setGenre(resultSet.getString("genre"));
				dto.setStarScore(resultSet.getFloat("starScore"));
				dto.setReleaseDate(resultSet.getString("releaseDate"));
				dto.setImageFileName(resultSet.getString("image"));
				
				resultList.add(dto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return resultList;
	}

	// 해당영화에 해당하는 배우 + 배역 출력
	@Override
	public Dto SearchMovieInfo(String movieName) {
		ArrayList<String> actorList = new ArrayList<String>();
		
		resultList = new ArrayList<Dto>();
		MovieDto movieDto = new MovieDto();
		ActorDto actorDto = new ActorDto();
		
		String selectQuery = "SELECT *\r\n"
						+ "FROM movie m\r\n"
						+ "INNER JOIN role r\r\n"
						+ "ON m.title = r.title\r\n"
						+ "WHERE m.title = ? ";
		
		try {
			preparedStatement = connection.prepareStatement(selectQuery);
			preparedStatement.setString(1, movieName);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				movieDto.setTitle(resultSet.getString("title"));
				movieDto.setGenre(resultSet.getString("genre"));
				movieDto.setStarScore(resultSet.getFloat("starScore"));
				movieDto.setReleaseDate(resultSet.getString("releaseDate"));
				movieDto.setImageFileName(resultSet.getString("image"));
				resultList.add(movieDto);
			}
			
			while (resultSet.next()) {
				actorList.add(resultSet.getString("actorName"));
				actorList.add(resultSet.getString("roleName"));
				movieDto.setActorList(actorList);
			}
						
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return movieDto;
	}

	// 해당 배우가 출연한 영화 이름
	@Override
	public Dto SearchActorInfo(String actorName) {

		ActorDto actorDto = new ActorDto();
		
		String selectQuery = "SELECT *\r\n"
				+ "FROM actor\r\n"
				+ "WHERE actorName = ? ";
		
		try {
			preparedStatement = connection.prepareStatement(selectQuery);
			preparedStatement.setString(1, actorName);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				actorDto.setActorName(resultSet.getString("actorName"));
				actorDto.setBirthYear(resultSet.getInt("birthYear"));
				actorDto.setPartner(resultSet.getString("partner"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return actorDto;
	}

}
