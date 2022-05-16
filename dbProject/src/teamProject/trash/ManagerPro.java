package teamProject.trash;

import java.math.BigDecimal;

import com.google.gson.Gson;

import teamProject.manager.ManagerDao;
import teamProject.manager.ManagerFrame;

public class ManagerPro implements CallbackManagerService {

	private ManagerFrame managerFrame;

	private ManagerDao dao;
	private Gson gson;
	
	//ManagerDto dto;

	public ManagerPro() {
		dao = new ManagerDao();
		gson = new Gson();
	}
	
	
	//
	@Override
	public void clickCreateBtn(String title, String date, Double starScore, String genre, String imageFileName, int audience, BigDecimal sales ) {
		dao.insertMovieInfo(title, date, starScore, genre, imageFileName);
		dao.insertScoreInfo(title, audience, sales);
	}

	@Override
	public void clickDeleteBtn(String title) {
		dao.deleteMovieInfo(title);
	}

	@Override
	public void clickUpdateStarBtn(Double starScore, String title) {
		dao.updateStarScore(starScore, title);
	}

	@Override
	public void clickUpdateSalesBtn(int audience, BigDecimal sales, String title) {
		dao.updateScore(audience, sales, title);
	}

	public static void main(String[] args) {
		ManagerPro managePro = new ManagerPro();
		String a = "스파이더맨 : 노웨이 홈";
		String b = "2021-12-15";
		Double c = 4.9;
		String d = "액션";
		String e = "images/스파이더맨.jpg";
		int f = 18;
		BigDecimal g = new BigDecimal("180000000");
		System.out.println("저장 완료");
//		managePro.clickCreateBtn(a, b, c, d, e, f, g);
//		managePro.clickDeleteBtn(a);
//		managePro.clickUpdateStarBtn(c, a);
//		managePro.clickUpdateSalesBtn(f, g, a);
		
		
	}

}
