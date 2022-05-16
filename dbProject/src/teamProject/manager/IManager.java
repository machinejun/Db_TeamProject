package teamProject.manager;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public interface IManager {

	// 새로운 영화 정보 삽입
	void insertMovieInfo(String title, String date, Double starScore, String genre, String imageFileName);

	// 영화 정보 스코어 삽입
	void insertScoreInfo(String title, int audience, BigDecimal sales);

	// 영화 매출 수정
	void updateScore(int audience, BigDecimal sales, String title);

	// 영화 평점 수정
	void updateStarScore(Double starScore, String title);

	// 영화 삭제
	void deleteMovieInfo(String title);
	
	// 영화 목록
	Vector<String> loadListMoive();
}
