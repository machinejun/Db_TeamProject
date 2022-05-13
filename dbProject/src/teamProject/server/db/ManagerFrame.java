package teamProject.db;

import java.awt.Color;
import java.awt.Font;
import java.awt.ScrollPane;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class ManagerFrame extends JFrame {

	private JButton insertBtn;
	private JButton updateBtn;
	private JButton deleteBtn;

	private JTabbedPane menuTab;

	private JPanel backgroundPanel;
	private JPanel updateTab;
	private JPanel insertTab;
	private JPanel listTab;
	private JPanel updatePanel;
	private JPanel deletePanel;
	
	private JTextField txtTitle;
	private JTextField txtReleaseDate;
	private JTextField txTStarScore;
	private JTextField txtGenre;
	private JTextField txtImageFileName;
	private JTextField txtSales;
	
	private JLabel titleLabel;
	private JLabel releaseDateLabel;
	private JLabel genreLabel;
	private JLabel imageFileNameLabel;
	
	private ScrollPane scrollPane;
	
	private JList<String> movieList;

	public ManagerFrame() {
		initData();
		setInitLayout();
	}

	private void initData() {
		setTitle("영화 정보 관리 프로그램");
		setSize(500, 700);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		insertBtn = new JButton("등록");
		updateBtn = new JButton("수정");
		deleteBtn = new JButton("삭제");
		
		insertBtn.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		updateBtn.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		deleteBtn.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		
		txtTitle = new JTextField();
		txtReleaseDate = new JTextField();

		menuTab = new JTabbedPane(JTabbedPane.TOP);

		backgroundPanel = new JPanel();
		updateTab = new JPanel();
		insertTab = new JPanel();
		listTab = new JPanel();
		
		updatePanel = new JPanel();
		deletePanel = new JPanel();
		
		titleLabel = new JLabel("영화 제목 : ");
		releaseDateLabel = new JLabel("개봉 일자 : ");
		genreLabel = new JLabel("장르 : ");
		
		titleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		releaseDateLabel.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		genreLabel.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		imageFileNameLabel.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		
		movieList = new JList<String>();
		scrollPane = new ScrollPane();

		menuTab.addTab("목록", null, listTab, null);
		menuTab.addTab("영화 등록", null, insertTab, null);
		menuTab.addTab("정보 수정", null, updateTab, null);

		setVisible(true);
	}

	private void setInitLayout() {
		backgroundPanel.setLayout(null);
		updateTab.setLayout(null);
		insertTab.setLayout(null);
		listTab.setLayout(null);
		
		menuTab.setBounds(0, 10, getWidth(), getHeight());
		backgroundPanel.add(menuTab);
		
		txtTitle.setBounds(180, 100, 150, 25);
		txtReleaseDate.setBounds(180, 140, 150, 25);
		
		insertBtn.setBounds(190, 350, 85, 30);
		updateBtn.setBounds(200, 200, 85, 30);
		
		scrollPane.setBounds(60, 75, 370, 440);
		
		updatePanel.setBounds(30, 30, 420, 270);
		deletePanel.setBounds(30, 330, 420, 270);
		
		titleLabel.setBounds(110, 100, 100, 25);
		releaseDateLabel.setBounds(110, 140, 100, 25);
		genreLabel.setBounds(137, 180, 100, 25);
		imageFileNameLabel.setBounds(getBounds());
		
		updatePanel.setBorder(new LineBorder(Color.lightGray));
		deletePanel.setBorder(new LineBorder(Color.lightGray));
		
		movieList.setBounds(65, 70, 350, 400);
		scrollPane.add(movieList);
		
		listTab.add(scrollPane);
		
		updateTab.add(updatePanel);
		updateTab.add(deletePanel);
		
		insertTab.add(txtTitle);
		insertTab.add(txtReleaseDate);
		insertTab.add(insertBtn);
		insertTab.add(titleLabel);
		insertTab.add(releaseDateLabel);
		insertTab.add(genreLabel);
		
		setContentPane(backgroundPanel);
	}

	public static void main(String[] args) {
		new ManagerFrame();
	}

}
