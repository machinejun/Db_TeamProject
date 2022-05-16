package teamProject.client.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import lombok.Getter;
import lombok.Setter;
import teamProject.client.MovieDto;
import teamProject.client.RoleDto;

@Getter
@Setter
public class MoviePanel extends JPanel {

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
	private JButton selectActorBtn;
	private JButton backBtn;
	private Font font = new Font("맑은 고딕", Font.BOLD, 15);
	private Font listfont = new Font("굴림체", Font.BOLD, 15);
	private Vector<String> roles;
	
	// 패널 데이터
	private MovieDto movie;
	
	public MoviePanel() {
		initData();
		setVisible(true);
	}
	
	public void insertImage(String url) {
		System.out.println(url);
		try {
			//URL url = new URL(movie.getImageFileName());
			URL imgRrl = new URL(url);
			BufferedImage img = ImageIO.read(imgRrl);
			ImageIcon imgIcon = new ImageIcon();
			imgIcon.setImage(img);
			imageLabel.setIcon(imgIcon);
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void loadMovieinfo(MovieDto movie) {
		
		
		titleLabel.setText("영화 제목 : " + movie.getTitle());
		genreLabel.setText("장    르 : " + movie.getGenre());
		yearLabel.setText( "개봉 일자 : " + movie.getReleaseDate());
		starLabel.setText( "별    점 : " + movie.getStarScore());
		audienceLabel.setText("관객   수 : " + movie.getScoreDto().getAudience());
		salesLabel.setText("매 출 액 : " + movie.getScoreDto().getSales());
		
		roles = new Vector<String>();
		for (RoleDto role : movie.getRoleList()) {
			roles.add(role.getRoleName() + " / " + role.getActorName());
		}
		roleList.setListData(roles);
		
		
	}

	private void initData() {

		setBorder(new LineBorder(Color.white));
		setBounds(20, 70, 730, 670);
		setLayout(null);

		imageLabel = new JLabel(new ImageIcon("images/poster.jpg"));
		imageLabel.setBounds(100, 50, 200, 286);
		add(imageLabel);

		titleLabel = new JLabel();
		titleLabel.setFont(font);
		titleLabel.setBounds(350, 50, 250, 30);
		add(titleLabel);

		genreLabel = new JLabel();
		genreLabel.setFont(font);
		genreLabel.setBounds(350, 100, 250, 30);
		add(genreLabel);

		yearLabel = new JLabel();
		yearLabel.setFont(font);
		yearLabel.setBounds(350, 150, 250, 30);
		add(yearLabel);

		starLabel = new JLabel();
		starLabel.setFont(font);
		starLabel.setBounds(350, 200, 250, 30);
		add(starLabel);

		audienceLabel = new JLabel();
		audienceLabel.setFont(font);
		audienceLabel.setBounds(350, 250, 250, 30);
		add(audienceLabel);

		salesLabel = new JLabel();
		salesLabel.setFont(font);
		salesLabel.setBounds(350, 300, 250, 30);
		add(salesLabel);

		roleLabel = new JLabel("등장인물");
		roleLabel.setBounds(100, 350, 80, 30);
		roleLabel.setFont(font);
		add(roleLabel);

		roleList = new JList();
		roleList.setFont(listfont);
		roleList.setBounds(100, 380, 550, 200);
		add(roleList);


		selectActorBtn = new JButton("검색");
		selectActorBtn.setFont(font);
		selectActorBtn.setBounds(570, 600, 80, 20);
		add(selectActorBtn);
		
		backBtn = new JButton("뒤로가기");
		backBtn.setFont(font);
		backBtn.setBounds(460, 600, 100, 20);
		add(backBtn);

	}

}
