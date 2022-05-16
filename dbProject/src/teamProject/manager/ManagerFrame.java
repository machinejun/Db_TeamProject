package teamProject.manager;

import java.awt.Color;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import lombok.Getter;
import lombok.Setter;

public class ManagerFrame extends JFrame implements ActionListener {

	private JButton insertBtn;
	private JButton updateStarBtn;
	private JButton updateScoreBtn;
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
	private JTextField txtStarScore;
	private JTextField txtGenre;
	private JTextField txtSales;
	private JTextField txtInsertAudience;
	private JTextField txtInsertSales;
	private JTextField txtImageUrl;

	private JLabel titleLabel;
	private JLabel releaseDateLabel;
	private JLabel starScoreLabel;
	private JLabel genreLabel;
	private JLabel audienceLabel;
	private JLabel salesLabel;
	private JLabel imageLabel;

	private ScrollPane scrollPane;

	private JList<String> movieList;

	private UpdateStarScorePanel updateStarScorePanel;
	private UpdateScorePanel updateScorePanel;

	private ManagerDao managerDao;

	private Vector<String> titleList = new Vector<String>();

	private Font font = new Font("맑은 고딕", Font.BOLD, 14);

	public ManagerFrame() {

		managerDao = new ManagerDao();

		initData();
		setInitLayout();
		addListener();

	}

	private void initData() {
		setTitle("영화 정보 관리 프로그램");
		setSize(500, 700);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		movieList = new JList<String>();

		movieList.setFont(new Font("맑은 고딕", Font.BOLD, 14));

		titleList = managerDao.loadListMoive();

		movieList.setListData(titleList);

		updateStarScorePanel = new UpdateStarScorePanel();
		updateScorePanel = new UpdateScorePanel();

		insertBtn = new JButton("등록");
		updateStarBtn = new JButton("수정");
		updateScoreBtn = new JButton("수정");
		deleteBtn = new JButton("삭제");

		insertBtn.setFont(font);
		updateStarBtn.setFont(font);
		updateScoreBtn.setFont(font);
		deleteBtn.setFont(font);

		backgroundPanel = new JPanel();
		updateTab = new JPanel();
		insertTab = new JPanel();
		listTab = new JPanel();

		updatePanel = new JPanel();
		deletePanel = new JPanel();

		titleLabel = new JLabel("영화 제목 : ");
		releaseDateLabel = new JLabel("개봉 일자 : ");
		genreLabel = new JLabel("장르 : ");
		starScoreLabel = new JLabel("평점 : ");
		audienceLabel = new JLabel("관객 수 : ");
		salesLabel = new JLabel("매출 : ");
		imageLabel = new JLabel("이미지 URL : ");

		txtTitle = new JTextField();
		txtReleaseDate = new JTextField();
		txtStarScore = new JTextField();
		txtGenre = new JTextField();
		txtInsertAudience = new JTextField();
		txtInsertSales = new JTextField();
		txtImageUrl = new JTextField();

		titleLabel.setFont(font);
		releaseDateLabel.setFont(font);
		starScoreLabel.setFont(font);
		genreLabel.setFont(font);
		audienceLabel.setFont(font);
		salesLabel.setFont(font);
		imageLabel.setFont(font);

		scrollPane = new ScrollPane();

		menuTab = new JTabbedPane(JTabbedPane.TOP);
		menuTab.addTab("목록", null, listTab, null);
		menuTab.addTab("등록", null, insertTab, null);
		menuTab.addTab("수정", null, updateTab, null);

		setVisible(true);
	}

	private void setInitLayout() {
		backgroundPanel.setLayout(null);
		updateTab.setLayout(null);
		insertTab.setLayout(null);
		listTab.setLayout(null);

		menuTab.setBounds(0, 10, getWidth(), getHeight());

		backgroundPanel.setBackground(Color.darkGray);
		backgroundPanel.add(menuTab);

		txtTitle.setBounds(180, 100, 150, 25);
		txtReleaseDate.setBounds(180, 140, 150, 25);
		txtStarScore.setBounds(180, 180, 150, 25);
		txtGenre.setBounds(180, 220, 150, 25);
		txtInsertAudience.setBounds(180, 260, 150, 25);
		txtInsertSales.setBounds(180, 300, 150, 25);
		txtImageUrl.setBounds(180, 340, 150, 25);

		insertBtn.setBounds(190, 400, 85, 30);
		updateStarBtn.setBounds(200, 200, 85, 30);
		deleteBtn.setBounds(200, 550, 85, 30);

		scrollPane.setBounds(60, 75, 370, 440);

		updateStarScorePanel.setBounds(30, 30, 420, 270);
		updateStarScorePanel.setBorder(new LineBorder(Color.lightGray));

		updateScorePanel.setBounds(30, 330, 420, 270);
		updateScorePanel.setBorder(new LineBorder(Color.lightGray));

		titleLabel.setBounds(100, 100, 100, 25);
		releaseDateLabel.setBounds(100, 140, 100, 25);
		starScoreLabel.setBounds(130, 180, 100, 25);
		genreLabel.setBounds(130, 220, 100, 25);
		audienceLabel.setBounds(110, 260, 100, 25);
		salesLabel.setBounds(130, 300, 100, 25);
		imageLabel.setBounds(80, 340, 150, 25);

		movieList.setBounds(65, 70, 350, 450);
		scrollPane.add(movieList);

		listTab.add(scrollPane);
		listTab.add(deleteBtn);

		updateTab.add(updateStarScorePanel);
		updateTab.add(updateScorePanel);

		insertTab.add(txtTitle);
		insertTab.add(txtReleaseDate);
		insertTab.add(txtStarScore);
		insertTab.add(txtGenre);
		insertTab.add(insertBtn);
		insertTab.add(titleLabel);
		insertTab.add(releaseDateLabel);
		insertTab.add(genreLabel);
		insertTab.add(starScoreLabel);
		insertTab.add(audienceLabel);
		insertTab.add(salesLabel);
		insertTab.add(txtInsertAudience);
		insertTab.add(txtInsertSales);
		insertTab.add(imageLabel);
		insertTab.add(txtImageUrl);

		setContentPane(backgroundPanel);
	}

	private void addListener() {
		insertBtn.addActionListener(this);
		deleteBtn.addActionListener(this);
		updateScorePanel.getButton().addActionListener(this);
		updateStarScorePanel.getButton().addActionListener(this);

	}

	@Getter
	@Setter
	class UpdateStarScorePanel extends JPanel {

		private JLabel titleLabel;
		private JLabel scoreLabel;
		private JTextField updateTF;
		private JTextField updateStarTF;
		private JButton button;

		private JLabel label;

		public UpdateStarScorePanel() {
			setLayout(null);
			setSize(420, 270);
			setVisible(true);

			label = new JLabel("평점 수정");
			label.setBounds(10, 5, 80, 30);
			label.setFont(font);
			add(label);

			titleLabel = new JLabel("영화 제목 : ");
			titleLabel.setBounds(65, 50, 150, 30);
			titleLabel.setFont(font);
			add(titleLabel);

			updateTF = new JTextField();
			updateTF.setBounds(150, 57, 200, 20);
			add(updateTF);

			scoreLabel = new JLabel("평점 : ");
			scoreLabel.setBounds(95, 100, 50, 30);
			scoreLabel.setFont(font);
			add(scoreLabel);

			updateStarTF = new JTextField();
			updateStarTF.setBounds(150, 107, 200, 20);
			add(updateStarTF);

			button = new JButton("수정");
			button.setFont(font);
			button.setBounds(282, 157, 70, 25);
			add(button);

		}

	}

	@Getter
	@Setter
	class UpdateScorePanel extends JPanel {

		private JLabel scoreUpdate;

		private JLabel updateScoreLabel;
		private JLabel updateAudience;
		private JLabel updateSales;
		private JTextField updateScoreTF;
		private JTextField updateAudienceTF;
		private JTextField updateSalesTF;

		private JButton button;

		public UpdateScorePanel() {
			setLayout(null);
			setSize(420, 270);
			setVisible(true);

			scoreUpdate = new JLabel("관객수 / 매출 수정");
			scoreUpdate.setBounds(10, 5, 200, 30);
			scoreUpdate.setFont(font);
			add(scoreUpdate);

			updateScoreLabel = new JLabel("영화 제목 : ");
			updateScoreLabel.setBounds(65, 50, 150, 30);
			updateScoreLabel.setFont(font);
			add(updateScoreLabel);

			updateScoreTF = new JTextField();
			updateScoreTF.setBounds(150, 57, 200, 20);
			add(updateScoreTF);

			updateAudience = new JLabel("관객 수 : ");
			updateAudience.setBounds(80, 100, 70, 30);
			updateAudience.setFont(font);
			add(updateAudience);

			updateAudienceTF = new JTextField();
			updateAudienceTF.setBounds(150, 107, 200, 20);
			add(updateAudienceTF);

			updateSales = new JLabel("매출액 : ");
			updateSales.setBounds(80, 150, 70, 30);
			updateSales.setFont(font);
			add(updateSales);

			updateSalesTF = new JTextField();
			updateSalesTF.setBounds(150, 157, 200, 20);
			add(updateSalesTF);

			button = new JButton("수정");
			button.setFont(font);
			button.setBounds(282, 207, 70, 25);
			add(button);

		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton selectedBtn = (JButton) e.getSource();

		if (selectedBtn == insertBtn) {
			if (txtTitle.getText().length() == 0 || txtReleaseDate.getText().length() == 0
					|| txtStarScore.getText().length() == 0 || txtGenre.getText().length() == 0
					|| txtInsertAudience.getText().length() == 0 || txtInsertSales.getText().length() == 0) {
				JOptionPane.showMessageDialog(null, "모든 항목을 입력하세요.", "알림", JOptionPane.ERROR_MESSAGE);

			} else {
				managerDao.insertMovieInfo(txtTitle.getText(), txtReleaseDate.getText(),
						Double.parseDouble(txtStarScore.getText()), txtGenre.getText(), txtImageUrl.getText());
				managerDao.insertScoreInfo(txtTitle.getText(), Integer.parseInt(txtInsertAudience.getText()),
						BigDecimal.valueOf(Long.parseLong(txtInsertSales.getText())));
				titleList = managerDao.loadListMoive();
				movieList.setListData(titleList);
				txtTitle.setText(null);
				txtReleaseDate.setText(null);
				txtStarScore.setText(null);
				txtGenre.setText(null);
				txtInsertAudience.setText(null);
				txtInsertSales.setText(null);
				txtImageUrl.setText(null);
				JOptionPane.showMessageDialog(null, "등록되었습니다.", "알림", JOptionPane.CLOSED_OPTION);

			}

		} else if (selectedBtn == deleteBtn) {
			if (movieList.getSelectedValue() != null) {
				managerDao.deleteMovieInfo(movieList.getSelectedValue());
				titleList = managerDao.loadListMoive();
				movieList.setListData(titleList);
				JOptionPane.showMessageDialog(null, "삭제되었습니다.", "알림", JOptionPane.CLOSED_OPTION);

			} else {
				JOptionPane.showMessageDialog(null, "영화를 선택하세요.", "알림", JOptionPane.CLOSED_OPTION);
			}

		} else if (selectedBtn == updateStarScorePanel.getButton()) {
			if (updateStarScorePanel.getUpdateStarTF().getText().length() == 0
					|| updateStarScorePanel.getUpdateTF().getText().length() == 0) {
				JOptionPane.showMessageDialog(null, "모든 항목을 입력하세요.", "알림", JOptionPane.ERROR_MESSAGE);
			} else {
				managerDao.updateStarScore(Double.parseDouble(updateStarScorePanel.getUpdateStarTF().getText()),
						updateStarScorePanel.getUpdateTF().getText());
				updateStarScorePanel.getUpdateStarTF().setText(null);
				updateStarScorePanel.getUpdateTF().setText(null);
				JOptionPane.showMessageDialog(null, "수정되었습니다.", "알림", JOptionPane.CLOSED_OPTION);

			}

		} else if (selectedBtn == updateScorePanel.getButton()) {
			if (updateScorePanel.getUpdateAudienceTF().getText().length() == 0
					|| updateScorePanel.getUpdateSalesTF().getText().length() == 0
					|| updateScorePanel.getUpdateScoreTF().getText().length() == 0) {
				JOptionPane.showMessageDialog(null, "모든 항목을 입력하세요.", "알림", JOptionPane.ERROR_MESSAGE);
			} else {
				managerDao.updateScore(Integer.parseInt(updateScorePanel.getUpdateAudienceTF().getText()),
						BigDecimal.valueOf(Long.parseLong(updateScorePanel.getUpdateSalesTF().getText())),
						updateScorePanel.getUpdateScoreTF().getText());
				updateScorePanel.getUpdateAudienceTF().setText(null);
				updateScorePanel.getUpdateSalesTF().setText(null);
				updateScorePanel.getUpdateScoreTF().setText(null);
				JOptionPane.showMessageDialog(null, "수정되었습니다.", "알림", JOptionPane.CLOSED_OPTION);

			}

		}

	}

	public static void main(String[] args) {
		new ManagerFrame();
	}

}
