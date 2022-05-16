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
import teamProject.client.ActorDto;
import teamProject.client.RoleDto;

@Getter
@Setter
public class ActorPanel extends JPanel {

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
	private Font font = new Font("맑은 고딕", Font.BOLD, 15);
	private Font listfont = new Font("굴림체", Font.BOLD, 15);

	private Vector<String> movies;

	private ActorDto actor;

	public ActorPanel() {
		initData();
		setVisible(true);
	}
	
	public void insertImage(String url) {
		System.out.println("배우패널에 url input check: "  +  url);
		try {
			URL imgRrl = new URL(url);
			BufferedImage img = ImageIO.read(imgRrl);
			ImageIcon imgIcon = new ImageIcon();
			imgIcon.setImage(img);
			imageLabel.setIcon(imgIcon);
			
		} catch (MalformedURLException e) {
			System.err.println("URL 연결 안됨");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("이미지 read 안됨");
			e.printStackTrace();
		}
	}

	public void loadActorinfo(ActorDto actor) {

		nameLabel.setText("배우 이름 : " + actor.getActorName());
		ageLabel.setText("출생 년도 : " + actor.getBirthYear());
		heightLabel.setText("신    장 : " + actor.getHeight());
		weightLabel.setText("몸 무 게 : " + actor.getWeight());
		partnerLabel.setText("배 우 자 : " + actor.getPartner());
		
		movies = new Vector<String>();
		for (RoleDto role : actor.getRoleList()) {
			movies.add(role.getTitle() + "/" +"(" + role.getCategory()+")" +role.getRoleName());
		}
		movieList.setListData(movies);

	}

	private void initData() {

		setBorder(new LineBorder(Color.black));
		setBounds(20, 70, 730, 670);
		setLayout(null);

		imageLabel = new JLabel(new ImageIcon("images/actor.jpg"));
		imageLabel.setBounds(100, 50, 200, 286);
		add(imageLabel);

		nameLabel = new JLabel();
		nameLabel.setFont(font);
		nameLabel.setBounds(400, 50, 250, 30);
		add(nameLabel);

		ageLabel = new JLabel();
		ageLabel.setFont(font);
		ageLabel.setBounds(400, 100, 250, 30);
		add(ageLabel);

		weightLabel = new JLabel();
		weightLabel.setFont(font);
		weightLabel.setBounds(400, 200, 250, 30);
		add(weightLabel);

		heightLabel = new JLabel();
		heightLabel.setFont(font);
		heightLabel.setBounds(400, 150, 250, 30);
		add(heightLabel);

		partnerLabel = new JLabel();
		partnerLabel.setFont(font);
		partnerLabel.setBounds(400, 250, 250, 30);
		add(partnerLabel);

		movieLabel = new JLabel("출연작");
		movieLabel.setFont(font);
		movieLabel.setBounds(100, 350, 80, 30);
		add(movieLabel);

		movieList = new JList();
		movieList.setBounds(100, 380, 550, 200);
		movieList.setFont(listfont);
		add(movieList);

		selectMoiveBtn = new JButton("검색");
		selectMoiveBtn.setFont(font);
		selectMoiveBtn.setBounds(570, 600, 80, 20);
		add(selectMoiveBtn);

		backBtn = new JButton("뒤로가기");
		backBtn.setFont(font);
		backBtn.setBounds(460, 600, 100, 20);
		add(backBtn);

	}

}
