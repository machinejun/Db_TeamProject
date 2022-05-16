package teamProject.manager;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import teamProject.server.db.DBClient;

public class ManagerDao implements IManager {

	private DBClient dbClient;
	private Connection connection;

	private PreparedStatement preparedStatement;
	int result;

	private ResultSet rs;

	public ManagerDao() {
		dbClient = DBClient.getInstance();
		connection = dbClient.getConnection();
	}

	// 영화 정보 등록시 영화정보 삽입메서드와 스코어 정보 삽입 메서드 같이 실행
	// 새로운 영화정보 삽입
	@Override
	public void insertMovieInfo(String title, String date, Double starScore, String genre, String imageFileName) {

		try {
			String insertQuery = "INSERT INTO movie VALUES (?, ?, ?, ?, ?)";
			preparedStatement = connection.prepareStatement(insertQuery);

			preparedStatement.setString(1, title);
			preparedStatement.setString(2, date);
			preparedStatement.setDouble(3, starScore);
			preparedStatement.setString(4, genre);
			preparedStatement.setString(5, imageFileName);

			result = preparedStatement.executeUpdate();
			if (result > 0) {
				System.out.println("insert 완료");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// 스코어 정보 삽입
	@Override
	public void insertScoreInfo(String title, int audience, BigDecimal sales) {

		String insertQuery = "INSERT INTO score VALUES (?, ?, ?)";

		try {
			preparedStatement = connection.prepareStatement(insertQuery);

			preparedStatement.setString(1, title);
			preparedStatement.setInt(2, audience);
			preparedStatement.setBigDecimal(3, sales);

			result = preparedStatement.executeUpdate();
			if (result > 0) {
				System.out.println("insert 완료");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// 영화 제목 받아서 삭제
	@Override
	public void deleteMovieInfo(String title) {
		String deleteQuery = "DELETE FROM movie WHERE title = ? ";

		try {
			preparedStatement = connection.prepareStatement(deleteQuery);
			preparedStatement.setString(1, title);

			result = preparedStatement.executeUpdate();

			if (result > 0) {
				System.out.println("delete 완료");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// 수정할 평점과 제목 받아서 평점 수정
	@Override
	public void updateStarScore(Double starScore, String title) {

		String updateQuery = "UPDATE movie SET starScore = ? WHERE title = ? ";

		try {
			preparedStatement = connection.prepareStatement(updateQuery);
			preparedStatement.setDouble(1, starScore);
			preparedStatement.setString(2, title);

			result = preparedStatement.executeUpdate();

			if (result > 0) {
				System.out.println("starScore update 완료");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// 수정할 매출액과 제목 받아서 매출액 수정
	@Override
	public void updateScore(int audience, BigDecimal sales, String title) {
		String updateQuery = "UPDATE score SET audience = ? , sales = ? WHERE title = ? ";

		try {
			preparedStatement = connection.prepareStatement(updateQuery);
			preparedStatement.setInt(1, audience);
			preparedStatement.setBigDecimal(2, sales);
			preparedStatement.setString(3, title);

			result = preparedStatement.executeUpdate();

			if (result > 0) {
				System.out.println("sales update 완료");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Vector<String> loadListMoive() {
		Vector<String> resultList = new Vector<String>();
		String selectQuery = "SELECT * FROM movie ";

		try {
			preparedStatement = connection.prepareStatement(selectQuery);
			rs = preparedStatement.executeQuery();

			while (rs.next()) {
				resultList.add(rs.getString("title"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resultList;
	}

}
