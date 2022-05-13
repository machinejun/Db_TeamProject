package teamProject.client.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ActorPanel extends JPanel{
	
	private JLabel imageLabel;
	private JLabel nameLabel;
	private JLabel ageLabel;
	private JLabel weightLabel;
	private JLabel heightLabel;
	private JLabel partnerLabel;
	private JLabel movieLabel;
	private JList movieList;
	private JScrollPane scrollPane;
	private JButton selectMoiveBtn;
	private JButton backBtn;
	private Font font = new Font("맑은 고딕", Font.BOLD, 13);
	
	
	
	public ActorPanel() {
		initData();
		setVisible(true);
	}

	private void initData() {
		
		setBorder(new LineBorder(Color.black));
		setBounds(20, 70, 730, 670);
		setLayout(null);
		
		
		imageLabel = new JLabel(new ImageIcon("images/actor.jpg"));
		imageLabel.setBounds(100, 50, 200, 286);
		add(imageLabel);
		
		String name = "이름";
		nameLabel = new JLabel("이름 : " + name);
		nameLabel.setBounds(400, 50, 250, 30);
		add(nameLabel);
		
		String age = "나이";
		ageLabel = new JLabel("나이 : " + age);
		ageLabel.setBounds(400, 100, 250, 30);
		add(ageLabel);
		
		String year = "몸무게";
		weightLabel = new JLabel("개봉연도 : " + year);
		weightLabel.setBounds(400, 150, 250, 30);
		add(weightLabel);
		
		String height = "키";
		heightLabel = new JLabel("키 : " + height);
		heightLabel.setBounds(400, 200, 250, 30);
		add(heightLabel);
		
		String partner = "배우자";
		partnerLabel = new JLabel("배우자 : " + partner);
		partnerLabel.setBounds(400, 250, 250, 30);
		add(partnerLabel);
		
		
		movieLabel = new JLabel("출연작");
		movieLabel.setBounds(100, 350, 80, 30);
		add(movieLabel);
		
		movieList = new JList();
		movieList.setBounds(100, 380, 550, 200);
		add(movieList);
		
		
		// 스크롤
		scrollPane = new JScrollPane();
		movieList.add(scrollPane);
		
		selectMoiveBtn = new JButton("검색");
		selectMoiveBtn.setBounds(570, 600, 80, 20);
		add(selectMoiveBtn);
		
		backBtn = new JButton("뒤로가기");
		backBtn.setBounds(480,600, 80,20);
		add(backBtn);
		
		
	}
	


}
