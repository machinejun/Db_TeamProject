package teamProject.client.view;

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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import teamProject.client.ActorDto;
import teamProject.client.ClientPro;
import teamProject.client.MovieDto;


public class ClientFrame extends JFrame {

	private Listener listener;
	private JPanel panel;
	private JPanel movieListPanel;
	private JPanel actorListPanel;
	private JPanel rMovieListPanel;
	private JTabbedPane tap;
	private JList movieList;
	private JList actorList;
	private JList recentMovieList;
	private JButton searchBtn;
	private JComboBox combo;
	private JTextField textField;
	private JLabel title;
	private Font font = new Font("맑은 고딕", Font.BOLD, 13);
	private Font listfont = new Font("굴림체", Font.BOLD, 23);
	
	private Vector<String> moviename = new Vector<String>();
	private Vector<String> actorname = new Vector<String>();
	private Vector<String> recentMoviename = new Vector<String>();

	private static String[] choice = { "제목", "배우" };

	private ClientPro clientpro;
	private MoviePanel moviePanel= new MoviePanel();
	private ActorPanel actorPanel = new ActorPanel();

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
	
	
	public MoviePanel getMoviePanel() {
		return moviePanel;
	}

	public ActorPanel getActorPanel() {
		return actorPanel;
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

		movieListPanel = new JPanel();
		movieListPanel.setLayout(null);

		movieList.setFont(listfont);
		ScrollPane pm = new ScrollPane();
		pm.setBounds(10, 10, 680, 540);
		pm.add(movieList);
		movieListPanel.add(pm);
		tap.addTab("영화 리스트", movieListPanel);

		// 배우 리스트를 가진 탭
		actorListPanel = new JPanel();
		actorListPanel.setLayout(null);
		actorList.setFont(listfont);
		ScrollPane pa = new ScrollPane();
		pa.setBounds(10, 10, 680, 540);
		pa.add(actorList);
		actorListPanel.add(pa);
		tap.addTab("배우 리스트", actorListPanel);

		// 최신 영화 리스트를 가진 탭
		rMovieListPanel = new JPanel();

		rMovieListPanel.setLayout(null);
		recentMovieList.setFont(listfont);
		ScrollPane pr = new ScrollPane(); 
		pr.setBounds(10, 10, 680, 540);
		pr.add(recentMovieList);
		rMovieListPanel.add(pr);
		tap.addTab("최신 영화 리스트", rMovieListPanel);
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

	public void movieListUpdate(Vector<String> list) {
		System.out.println("movie update");
		moviename = list;
		movieList.setListData(moviename);
	}

	public void actorListUpdate(Vector<String> list) {
		System.out.println("acor update");
		actorname = list;
		actorList.setListData(actorname);
	}

	public void rMovieListUpdate(Vector<String> list) {
		System.out.println("mo update");
		recentMoviename = list;
		recentMovieList.setListData(recentMoviename);
	}
	
	public void selctMovieUpdate(MovieDto movieDto) {
		System.out.println("frmae + " + movieDto);
		moviePanel.loadMovieinfo(movieDto);
	}
	
	public void selctAcotrUpdate(ActorDto acotrDto) {
		System.out.println("frmae + " + acotrDto);
		actorPanel.loadActorinfo(acotrDto);
	}

	public class Listener implements ActionListener, ListSelectionListener {
		

		public Listener() {
			addListener();

		}

		private void addListener() {
			searchBtn.addActionListener(this);
			moviePanel.getBackBtn().addActionListener(this);
			actorPanel.getBackBtn().addActionListener(this);
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
				if (combo.getSelectedItem().equals("제목")) {	
					String smovie = textField.getText();
					if(moviename.contains(smovie)) {
						panel.setVisible(false);
						actorPanel.setVisible(false);
						moviePanel.setVisible(true);
						clientpro.sentMsg("selectM/" + smovie + "/" + clientpro.getId());
						add(moviePanel);
					}else {
						JOptionPane.showMessageDialog(null, "선택 조건을 다시 확인해 주세요\n 현재 영화목록에 검색하신 영화는 존재하지 않습니다.");
					}
				} else {	
					String sAcotr = textField.getText();
					if(actorname.contains(sAcotr)) {
						panel.setVisible(false);
						moviePanel.setVisible(false);
						actorPanel.setVisible(true);
						clientpro.sentMsg("selectA/" + sAcotr + "/" + clientpro.getId());
						add(actorPanel);
					}else {
						JOptionPane.showMessageDialog(null, "선택 조건을 다시 확인해 주세요\n 현재 배우목록에 검색하신 배우는 존재하지 않습니다.");
					}
				}
			} else if (e.getSource() == moviePanel.getSelectActorBtn()) {
				panel.setVisible(false);
				moviePanel.setVisible(false);
				actorPanel.setVisible(true);
				String str = moviePanel.getRoles().get(moviePanel.getRoleList().getSelectedIndex());
				clientpro.sentMsg("selectA/" + str.split("/")[1].trim()+ "/" + clientpro.getId());
				add(actorPanel);
			} else if (e.getSource() == moviePanel.getBackBtn()) {
				actorPanel.setVisible(false);
				moviePanel.setVisible(false);
				panel.setVisible(true);
				add(panel);
			} else if (e.getSource() == actorPanel.getSelectMoiveBtn()) {
				panel.setVisible(false);
				actorPanel.setVisible(false);
				moviePanel.setVisible(true);
				String str = actorPanel.getMovies().get(actorPanel.getMovieList().getSelectedIndex());
				System.out.println(str);
				clientpro.sentMsg("selectM/" + str.split("/")[0].trim()+ "/" + clientpro.getId());
				add(moviePanel);
			} else if (e.getSource() == actorPanel.getBackBtn()) {
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
			} else if (e.getSource().equals(actorList)) {
				System.out.println("actor");
				int i = actorList.getSelectedIndex();
				textField.setText(actorname.get(i));
			} else if (e.getSource().equals(recentMovieList)) {
				System.out.println("recentMovieList");
				int i = recentMovieList.getSelectedIndex();
				textField.setText(recentMoviename.get(i));
			}
		}

	}

	public static void main(String[] args) {

		new ClientFrame();
	}
}
