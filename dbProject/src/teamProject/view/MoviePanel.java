package teamProject.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import lombok.Getter;

@Getter
public class MoviePanel extends JPanel{
	
	private JLabel imageLabel;
	private JLabel titleLabel;
	private JLabel genreLabel;
	private JLabel yearLabel;
	private JLabel starLabel;
	private JLabel audienceLabel;
	private JLabel salesLabel;
	private JLabel roleLabel;
	private JList roleList;
	private JScrollPane scrollPane;
	private JButton movieBtn;
	private Font font = new Font("맑은 고딕", Font.BOLD, 13);
	
	
	public MoviePanel() {
		initData();
		setVisible(true);
	}

	private void initData() {
		
		
		setBorder(new LineBorder(Color.white));
		setBounds(20, 70, 730, 670);
		setLayout(null);
		
		imageLabel = new JLabel(new ImageIcon("images/poster.jpg"));
		imageLabel.setBounds(100, 50, 200, 286);
		add(imageLabel);
		
		String title = "영화 제목";
		titleLabel = new JLabel("제목 : " + title);
		titleLabel.setFont(font);
		titleLabel.setBounds(350, 50, 250, 30);
		add(titleLabel);
		
		String genre = "영화 장르";
		genreLabel = new JLabel("장르 : " + genre);
		genreLabel.setFont(font);
		genreLabel.setBounds(350, 100, 250, 30);
		add(genreLabel);
		
		String year = "개봉연도";
		yearLabel = new JLabel("개봉연도 : " + year);
		yearLabel.setFont(font);
		yearLabel.setBounds(350, 150, 250, 30);
		add(yearLabel);
		
		String star = "평점";
		starLabel = new JLabel("평점 : " + star);
		starLabel.setFont(font);
		starLabel.setBounds(350, 200, 250, 30);
		add(starLabel);
		
		String audience = "관객 수";
		audienceLabel = new JLabel("관객 수 : " + audience);
		audienceLabel.setFont(font);
		audienceLabel.setBounds(350, 250, 250, 30);
		add(audienceLabel);
		
		String sales = "매출액";
		salesLabel = new JLabel("매출액 : " + sales);
		salesLabel.setFont(font);
		salesLabel.setBounds(350, 300, 250, 30);
		add(salesLabel);
		
		roleLabel = new JLabel("등장인물");
		roleLabel.setBounds(100, 350, 80, 30);
		roleLabel.setFont(font);
		add(roleLabel);
		
		roleList = new JList();
		roleList.setFont(font);
		roleList.setBounds(100, 380, 550, 200);
		add(roleList);
		
		// 스크롤
		scrollPane = new JScrollPane();
		roleList.add(scrollPane);
		
		movieBtn = new JButton("검색");
		movieBtn.setFont(font);
		movieBtn.setBounds(570, 600, 80, 20);
		add(movieBtn);
		
		
	}
	
}
