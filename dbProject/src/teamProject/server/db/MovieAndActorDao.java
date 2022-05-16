package teamProject.server.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovieAndActorDao implements DaoInterface<Dto> {

	private DBClient dbClient;
	private Connection connection;

	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	private List<Dto> resultList = null;

	public MovieAndActorDao() {
		dbClient = DBClient.getInstance();
		connection = dbClient.getConnection();
	}

	// 접속시 영화 목록 출력
	@Override
	public List<Dto> loadListMoive() {
		resultList = new ArrayList<Dto>();
		String selectQuery = "SELECT * FROM movie ";

		try {
			preparedStatement = connection.prepareStatement(selectQuery);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Dto dto = new Dto();
				dto.setTitle(resultSet.getString("title"));
				resultList.add(dto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resultList;
	}

	// 접속시 배우 목록 출력
	@Override
	public List<Dto> loadListActor() {
		resultList = new ArrayList<Dto>();
		String selectQuery = "SELECT * FROM actor ";

		try {
			preparedStatement = connection.prepareStatement(selectQuery);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Dto dto = new Dto();
				dto.setActorName(resultSet.getString("actorName"));

				resultList.add(dto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resultList;
	}

	// 영화 목록 최신순 정렬
	@Override
	public List<Dto> loadRecentMovie() {
		resultList = new ArrayList<Dto>();
		String selectQuery = "SELECT *\r\n"
					+ "FROM movie\r\n"
					+ "ORDER BY releaseDate DESC ";

		try {
			preparedStatement = connection.prepareStatement(selectQuery);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Dto dto = new Dto();
				dto.setTitle(resultSet.getString("title"));

				resultList.add(dto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resultList;
	}

	// 영화 제목 검색 -> 영화 정보(영화 성적 포함) / 배우 이름 + 배역 이름
	@Override
	public MovieDto searchMovieInfo(String movieName) {

		MovieDto movieDto = new MovieDto();
		ScoreDto scoreDto = new ScoreDto();
		RoleDto roleDto = null;

		String selectQuery = "SELECT *, r.roleName\r\n"
				+ "FROM movie m\r\n"
				+ "LEFT OUTER JOIN role r\r\n"
				+ "ON m.title = r.title\r\n"
				+ "INNER JOIN score s\r\n"
				+ "ON m.title = s.title\r\n"
				+ "WHERE m.title = ? ";

		try {
			preparedStatement = connection.prepareStatement(selectQuery);
			preparedStatement.setString(1, movieName);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				roleDto = new RoleDto();

				movieDto.setTitle(resultSet.getString("title"));
				movieDto.setGenre(resultSet.getString("genre"));
				movieDto.setStarScore(resultSet.getFloat("starScore"));
				movieDto.setReleaseDate(resultSet.getString("releaseDate"));
				movieDto.setImageFileName(resultSet.getString("image"));

				roleDto.setActorName(resultSet.getString("actorName"));
				roleDto.setRoleName(resultSet.getString("roleName"));
				roleDto.setCategory(resultSet.getString("category"));
				movieDto.roleList.add(roleDto);

				scoreDto.setAudience(resultSet.getInt("audience"));
				scoreDto.setSales(resultSet.getInt("sales"));
			}

			movieDto.setScoreDto(scoreDto);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return movieDto;
	}

	// 배우이름 검색 -> 배우 정보 / 출연 영화 제목 + 배역 정보
	@Override
	public ActorDto searchActorInfo(String actorName) {

		ActorDto actorDto = new ActorDto();
		RoleDto roleDto = null;
		MovieDto movieDto = null;

		String selectQuery = "SELECT *\r\n"
				+ "FROM actor a\r\n"
				+ "INNER JOIN role r\r\n"
				+ "ON a.actorName = r.actorName\r\n"
				+ "WHERE a.actorName = ? ";

		try {
			preparedStatement = connection.prepareStatement(selectQuery);
			preparedStatement.setString(1, actorName);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				roleDto = new RoleDto();
				movieDto = new MovieDto();

				actorDto.setId(resultSet.getInt("id"));
				actorDto.setActorName(resultSet.getString("actorName"));
				actorDto.setBirthYear(resultSet.getInt("birthYear"));
				actorDto.setHeight(resultSet.getInt("height"));
				actorDto.setWeight(resultSet.getInt("weight"));
				actorDto.setPartner(resultSet.getString("partner"));
				actorDto.setImageFileName(resultSet.getString("image"));;
				
				roleDto.setTitle(resultSet.getString("title"));
				roleDto.setRoleName(resultSet.getString("roleName"));
				roleDto.setCategory(resultSet.getString("category"));
				actorDto.roleList.add(roleDto);

			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return actorDto;
	}

}
