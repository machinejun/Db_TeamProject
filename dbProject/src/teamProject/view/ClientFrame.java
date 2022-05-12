package teamProject.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class ClientFrame extends JFrame {

	private Listener listener;

	private JPanel panel;
	private JPanel moviePanel;
	private JPanel actorPanel;
	private JPanel recentMoviePanel;
	private JTabbedPane tap;
	private JList movieList;
	private JList actorList;
	private JList recentMovieList;
	private JButton searchBtn;
	private JComboBox combo;
	private JTextField textField;
	private JLabel title;
	private Font font = new Font("맑은 고딕", Font.BOLD, 13);
	//
	String[] choice = { "제목", "배우" };


	public ClientFrame() {
		SetMainPanel();
		initData();
		listener = new Listener();
		setVisible(true);
	}

	private void SetMainPanel() {
		setTitle("Search Movie");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 800);
		setLayout(null);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.black);

		title = new JLabel("MOVIEWIKI");
		title.setBounds(20, 10, 400, 50);
		title.setFont(new Font("맑은 고딕", Font.BOLD, 40));
		title.setOpaque(true);
		title.setForeground(Color.pink);
		title.setBackground(Color.black);
		add(title);
	}

	private void initData() {

		panel = new JPanel();
		panel.setBorder(new LineBorder(Color.white));
		panel.setBounds(20, 70, 730, 670);
		panel.setLayout(null);
		panel.setBackground(Color.black);
		add(panel);

		// 영화 리스트를 가진 탭
		tap = new JTabbedPane(JTabbedPane.TOP);
		tap.setBounds(15, 20, 700, 590);
		panel.add(tap);
		tap.addTab("영화 리스트", null, moviePanel, null);
		tap.setFont(font);
		moviePanel = new JPanel();
		moviePanel.setLayout(null);

		movieList = new JList();
		movieList.setFont(font);
		movieList.setBounds(10, 10, 680, 540);
		moviePanel.add(movieList);

		// 배우 리스트를 가진 탭
		actorPanel = new JPanel();
		tap.addTab("배우 리스트", null, actorPanel, null);
		actorPanel.setLayout(null);

		actorList = new JList();
		actorList.setFont(font);
		actorList.setBounds(10, 10, 680, 540);
		actorPanel.add(actorList);

		// 최신 영화 리스트를 가진 탭
		recentMoviePanel = new JPanel();
		tap.addTab("최신 영화 리스트", null, recentMoviePanel, null);
		recentMoviePanel.setLayout(null);

		recentMovieList = new JList();
		recentMovieList.setFont(font);
		recentMovieList.setBounds(10, 10, 680, 540);
		recentMoviePanel.add(recentMovieList);

		searchBtn = new JButton("검색");
		searchBtn.setFont(font);
		searchBtn.setBounds(610, 630, 100, 25);
		panel.add(searchBtn);

		// 콤보 박스
		combo = new JComboBox(choice);
		combo.setFont(font);
		combo.setBounds(15, 630, 100, 25);
		panel.add(combo);

		textField = new JTextField();
		textField.setBounds(120, 630, 480, 25);
		panel.add(textField);

	}



	public class Listener implements ActionListener {
		
		
		MoviePanel moviePanel = new MoviePanel();
		ActorPanel actorPanel = new ActorPanel();

		public Listener() {
			addListener();
			

		}

		private void addListener() {
			searchBtn.addActionListener(this);
			moviePanel.getMovieBtn().addActionListener(this);
			actorPanel.getActorBtn().addActionListener(this);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == searchBtn) {
				panel.setVisible(false);
				//movieFrame();
				add(moviePanel);
			} else if(e.getSource() == moviePanel.getMovieBtn()){
				System.out.println("=");
				moviePanel.setVisible(false);
				actorPanel.setVisible(true);
				add(actorPanel);
				
			} else if(e.getSource() == actorPanel.getActorBtn()) {
				actorPanel.setVisible(false);
				moviePanel.setVisible(true);
				add(moviePanel);
			}
			
		}

	}

	public static void main(String[] args) {
		new ClientFrame();
	}

}
