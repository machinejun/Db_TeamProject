package teamProject.trash;

import java.math.BigDecimal;

public interface CallbackManagerService {
	
	// 생성 버튼을 누르는 경우
	void clickCreateBtn(String title, String date, Double starScore, String genre, String imageFileName, int audience, BigDecimal sales );
	
	// 삭제 버튼을 누르는 경우
	void clickDeleteBtn(String title);
	
	// 평점 수정 버튼
	void clickUpdateStarBtn(Double starScore, String title);
	
	// 매출액 수정 버튼
	void clickUpdateSalesBtn(int audience, BigDecimal sales, String title);
	
}
