package teamProject.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import teamProject.client.ClientPro;


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
	private Font listfont = new Font("맑은 고딕", Font.BOLD, 25);
	//
	private Vector<String> moviename = new Vector<String>();
	private Vector<String> actorname = new Vector<String>();
	private Vector<String> recentMoviename = new Vector<String>();

	String[] choice = { "제목", "배우" };
	
	private ClientPro clientpro;

	public ClientFrame() {
		SetMainPanel();
		initData();
		this.clientpro = new ClientPro(this);
		listener = new Listener();
		setVisible(true);
	}

	private void SetMainPanel() {
		setTitle("Search Movie");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 800);
		setLayout(null);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.darkGray);

		title = new JLabel("MOVIEWIKI");
		title.setBounds(20, 10, 400, 50);
		title.setFont(new Font("맑은 고딕", Font.BOLD, 40));
		title.setOpaque(true);
		title.setForeground(Color.pink);
		title.setBackground(Color.darkGray);
		add(title);
	}

	private void initData() {
		movieList = new JList<String>();
		actorList = new JList<String>();
		recentMovieList = new JList<String>();

		panel = new JPanel();
		panel.setBorder(new LineBorder(Color.white));
		panel.setBounds(20, 70, 730, 670);
		panel.setLayout(null);
		panel.setBackground(Color.darkGray);
		add(panel);

		// 영화 리스트를 가진 탭
		tap = new JTabbedPane(JTabbedPane.TOP);
		tap.setBounds(15, 20, 700, 590);
		panel.add(tap);

		tap.setFont(font);

		moviePanel = new JPanel();
		moviePanel.setLayout(null);

		movieList.setFont(listfont);
		ScrollPane pm = new ScrollPane();
		pm.setBounds(10, 10, 680, 540);
		pm.add(movieList);
		moviePanel.add(pm);
		tap.addTab("영화 리스트", moviePanel);

		// 배우 리스트를 가진 탭
		actorPanel = new JPanel();
		actorPanel.setLayout(null);
		actorList.setFont(listfont);
		ScrollPane pa = new ScrollPane();
		pa.setBounds(10, 10, 680, 540);
		pa.add(actorList);
		actorPanel.add(pa);
		tap.addTab("배우 리스트", actorPanel);

		// 최신 영화 리스트를 가진 탭
		recentMoviePanel = new JPanel();

		recentMoviePanel.setLayout(null);
		recentMovieList.setFont(listfont);
		recentMovieList.setBounds(10, 10, 680, 540);
		recentMoviePanel.add(recentMovieList);
		tap.addTab("최신 영화 리스트", recentMoviePanel);
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

	public void movielistupdate(Vector<String> list) {
		System.out.println("movie update");
		moviename = list;
		movieList.setListData(moviename);
	}

	public void actorlistupdate(Vector<String> list) {
		System.out.println("acor update");
		actorname = list;
		actorList.setListData(actorname);
	}

	public void rMovielistupdate(Vector<String> list) {
		System.out.println("mo update");
		recentMoviename = list;
		recentMovieList.setListData(recentMoviename);
	}
	

	public class Listener implements ActionListener, ListSelectionListener {
		MoviePanel moviePanel = new MoviePanel();
		ActorPanel actorPanel = new ActorPanel();

		public Listener() {
			addListener();

		}
	

		private void addListener() {
			searchBtn.addActionListener(this);
			moviePanel.getSelectActorBtn().addActionListener(this);
			actorPanel.getSelectMoiveBtn().addActionListener(this);
			movieList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			movieList.addListSelectionListener(this);
			actorList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			actorList.addListSelectionListener(this);
			recentMovieList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			recentMovieList.addListSelectionListener(this);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == searchBtn) {
				panel.setVisible(false);
				if(combo.getSelectedItem().equals("제목")) {
					add(moviePanel);
				}else {
					add(actorPanel);
				}
			} else if (e.getSource() == moviePanel.getSelectActorBtn()) {
				moviePanel.setVisible(false);
				actorPanel.setVisible(true);
				add(actorPanel);
			} else if (e.getSource() == moviePanel.getBackBtn()) {
				actorPanel.setVisible(false);
				moviePanel.setVisible(false);
				panel.setVisible(true);
				add(panel);
			}else if (e.getSource() == actorPanel.getSelectMoiveBtn()) {
				actorPanel.setVisible(false);
				moviePanel.setVisible(true);
				add(moviePanel);
			}else if (e.getSource() == actorPanel.getBackBtn()) {
				actorPanel.setVisible(false);
				moviePanel.setVisible(false);
				panel.setVisible(true);
				add(panel);
			}

		}

		@Override
		public void valueChanged(ListSelectionEvent e) {
			if (e.getSource().equals(movieList)) {
				System.out.println("movie");
				int i = movieList.getSelectedIndex();
				textField.setText(moviename.get(i));
			}else if(e.getSource().equals(actorList)){
				System.out.println("actor");
				int i = actorList.getSelectedIndex();
				textField.setText(actorname.get(i));
			}else if(e.getSource().equals(recentMovieList)) {
				System.out.println("recentMovieList");
				int i = actorList.getSelectedIndex();
				textField.setText(recentMoviename.get(i));
			}
		}

	}
	
	public static void main(String[] args) {

		new ClientFrame();
	}
}
