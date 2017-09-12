package com.liberarysystem.frame;
/**
 * ϵͳ������
 */
import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.liberarysystem.panel.AboutPanel;
import com.liberarysystem.panel.AddBookPanel;
import com.liberarysystem.panel.AddReaderPanel;
import com.liberarysystem.panel.BorrowBookPanel;
import com.liberarysystem.panel.EditorReaderPanel;
import com.liberarysystem.panel.RemoveBookPanel;
import com.liberarysystem.panel.RemoveReaderPanel;
import com.liberarysystem.panel.RenewBookPanel;
import com.liberarysystem.panel.ReturnBookPanel;
import com.liberarysystem.panel.SearchBookPanel;
import com.liberarysystem.panel.SearchBorrowInfoPanel;
import com.liberarysystem.panel.SearchReaderPanel;
import com.liberarysystem.panel.SuggestionPanel;
import com.liberarysystem.panel.SystemIntroductionPanel;
import com.liberarysystem.util.MyRequest;
import com.liberarysystem.util.ScreenSize;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	public MyRequest request;
	public MainFrame local = this;
	/* ͼ��ݹ�����ҳ�� */
	public Color headBarColor = new Color(204, 204, 204);
	public SearchBookPanel searchBookPanel;// ��ѯͼ�����
	public AddBookPanel addBookPanel;// ���ͼ�����
	public RemoveBookPanel removeBookPanel;// ɾ��ͼ�����
	/* ���߹�����ҳ�� */
	public SearchReaderPanel searchReaderPanel;// ���߲�ѯ���
	public AddReaderPanel addReaderPanel;// ���ͼ�����
	public RemoveReaderPanel removeReaderPanel;// ͼ��������
	public EditorReaderPanel editorReaderPanel;// �޸�ͼ����Ϣ���
	/* ���Ĺ�����ҳ�� */
	public SearchBorrowInfoPanel searchBorrowInfoPanel; // ��ѯ������Ϣ���
	public BorrowBookPanel borrowBookPanel;// ����������
	public ReturnBookPanel returnBookPanel;// ���������
	public RenewBookPanel renewBookPanel;// �����������
	/* ������ҳ�� */
	public SystemIntroductionPanel systemIntroductionPanel;// ϵͳ������
	public AboutPanel aboutPanel;// �����������
	public SuggestionPanel suggestionPanel;// ����������

	public Map<String, JPanel> panelMap = new HashMap<String, JPanel>();// ����Ѿ��򿪵�ContentPanel�ļ�ֵ��
	public Map<String, String> panelText;// ���ContentPanel�����Text�ļ�ֵ��
	public Point contentPoint;
	public Map<String, ImageIcon> iconMap;
    public int headerBarSize;
    public String username;
	/**
	 * ��ʼ����Ա�����������װ��request��
	 */
	public MainFrame(MyRequest request) {
		this.request = request;
		username=(String) request.getAttribute("username");
		initDate();
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setBounds(0, 0, ScreenSize.getWidth() / 2, ScreenSize.getHeight() / 2);
		ImageIcon icon = new ImageIcon("./resource/image/picture.png");
		this.setTitle("liberarysystem.1.0");
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setIconImage(icon.getImage());
		this.setLayout(null);
		contentsInit();
		this.setVisible(true);
	}
/**
 * ��ʼ����������
 */
	public void initDate() {
		headerBarSize=30;//�����˵����߶�
		contentPoint = new Point((ScreenSize.getWidth()-957)/2, 	(ScreenSize.getHeight()-headerBarSize-620)/2);
		this.request.setAttribute("MainFrame", this);
		iconMap = new HashMap<String, ImageIcon>();
		ImageIcon addIcon = new ImageIcon("./resource/image/add20.png");
		ImageIcon removeIcon = new ImageIcon("./resource/image/remove20.png");
		ImageIcon editorIcon = new ImageIcon("./resource/image/editor.png");
		ImageIcon searchIcon = new ImageIcon("./resource/image/search.png");
		ImageIcon borrowIcon = new ImageIcon("./resource/image/borrow.png");
		ImageIcon returnIcon = new ImageIcon("./resource/image/return.png");
		ImageIcon renewIcon = new ImageIcon("./resource/image/renew.png");
		ImageIcon logoIcon = new ImageIcon("./resource/image/logo.png");
		ImageIcon aboutIcon = new ImageIcon("./resource/image/about.png");
		ImageIcon suggestionIcon = new ImageIcon("./resource/image/suggestion.png");
		ImageIcon personalIcon = new ImageIcon("./resource/image/personal.png");
		ImageIcon exitIcon = new ImageIcon("./resource/image/exit.png");
		iconMap.put("addIcon", addIcon);
		iconMap.put("removeIcon", removeIcon);
		iconMap.put("editorIcon", editorIcon);
		iconMap.put("searchIcon", searchIcon);
		iconMap.put("borrowIcon", borrowIcon);
		iconMap.put("returnIcon", returnIcon);
		iconMap.put("renewIcon", renewIcon);
		iconMap.put("logoIcon", logoIcon);
		iconMap.put("aboutIcon", aboutIcon);
		iconMap.put("suggestionIcon", suggestionIcon);
		iconMap.put("personalIcon",personalIcon );
		iconMap.put("exitIcon",exitIcon );
	}

	/**
	 * ��ʼ�������пؼ�����
	 */
	public void contentsInit() {
		headerPanel();// ��ʼ�������˵���
		contentPanelInit();// ��ʼ���м��������
	}

	/** 
	 * ��ʼ�������˵���---------------------------------------------------------��ʼ�������˵���
	 */
	public void headerPanel() {
		JMenuBar headBar = new JMenuBar();
		headBar.setBackground(headBarColor);
		headBar.setBounds(0, 0, ScreenSize.getWidth(), headerBarSize);
		headBar.setVisible(true);
		this.add(headBar);
		//����ϵͳ�˵���
		JMenu systemMenu = new JMenu();
		systemMenu.setIcon(iconMap.get("personalIcon"));
		systemMenu.setVisible(true);
		headBar.add(systemMenu);
		//�˳�ϵͳ
		JMenuItem exitItem = new JMenuItem("�˳�ϵͳ");
		exitItem.setIcon(iconMap.get("exitIcon"));
		exitItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int i=JOptionPane.showConfirmDialog(local,"ȷ���˳�ϵͳ����ȷ�ϣ����򵥻�ȡ����"," ",JOptionPane.OK_CANCEL_OPTION);
				if(i==0){
				local.dispose();
				}
			}
		});
		systemMenu.add(exitItem);
		// ͼ�����˵�������������������������������������������������ͼ�����˵�
		JMenu bookMenu = new JMenu("ͼ�����  (B)");
		bookMenu.setMnemonic('B');
		bookMenu.setVisible(true);
		headBar.add(bookMenu);
		// ���ͼ��
		JMenuItem addBookItem = new JMenuItem("���ͼ��");
		addBookItem.setIcon(iconMap.get("addIcon"));
		addBookItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				local.viewChange("���ͼ��");
			}
		});
		bookMenu.add(addBookItem);
		// ɾ��ͼ��
		JMenuItem removeBookItem = new JMenuItem("ɾ��ͼ��");
		removeBookItem.setIcon(iconMap.get("removeIcon"));
		removeBookItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				local.viewChange("ɾ��ͼ��");
			}
		});
		bookMenu.add(removeBookItem);
		// ��ѯͼ��
		JMenuItem searchBookItem = new JMenuItem("��ѯͼ��");
		searchBookItem.setIcon(iconMap.get("searchIcon"));
		searchBookItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				local.viewChange("��ѯͼ��");
			}
		});
		bookMenu.add(searchBookItem);
		// ���߹���˵����������������������������������������������������߹���˵�
		JMenu readerMenu = new JMenu("���߹���  (R)");
		readerMenu.setMnemonic('R');
		readerMenu.setVisible(true);
		headBar.add(readerMenu);
		// ��Ӷ���
		JMenuItem addReaderItem = new JMenuItem("��Ӷ���");
		addReaderItem.setIcon(iconMap.get("addIcon"));
		addReaderItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				local.viewChange("��Ӷ���");
			}
		});
		readerMenu.add(addReaderItem);
		// ɾ������
		JMenuItem removeReaderItem = new JMenuItem("ɾ������");
		removeReaderItem.setIcon(iconMap.get("removeIcon"));
		removeReaderItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				local.viewChange("ɾ������");
			}
		});
		readerMenu.add(removeReaderItem);
		// ��ѯ����
		JMenuItem searchReaderItem = new JMenuItem("��ѯ����");
		searchReaderItem.setIcon(iconMap.get("searchIcon"));
		searchReaderItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				local.viewChange("��ѯ����");
			}
		});
		readerMenu.add(searchReaderItem);
		// �༭����
		JMenuItem editorReaderItem = new JMenuItem("�༭����");
		editorReaderItem.setIcon(iconMap.get("editorIcon"));
		editorReaderItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				local.viewChange("�༭����");
			}
		});
		readerMenu.add(editorReaderItem);
		// ���Ĺ���˵����������������������������������������������������Ķ��߹���˵�
		JMenu borrowMenu = new JMenu("���Ĺ���  (A)");
		borrowMenu.setMnemonic('A');
		borrowMenu.setVisible(true);
		headBar.add(borrowMenu);
		// ��ѯ����
		JMenuItem searchBorrowInfoItem = new JMenuItem("��ѯ����");
		searchBorrowInfoItem.setIcon(iconMap.get("searchIcon"));
		searchBorrowInfoItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				local.viewChange("��ѯ����");
			}
		});
		borrowMenu.add(searchBorrowInfoItem);
		// �������
		JMenuItem borrowBookItem = new JMenuItem("�������");
		borrowBookItem.setIcon(iconMap.get("borrowIcon"));
		borrowBookItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				local.viewChange("�������");
			}
		});
		borrowMenu.add(borrowBookItem);
		// ������
		JMenuItem returnBookItem = new JMenuItem("������");
		returnBookItem.setIcon(iconMap.get("returnIcon"));
		returnBookItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				local.viewChange("������");
			}
		});
		borrowMenu.add(returnBookItem);
		// ��������
		JMenuItem renewBookItem = new JMenuItem("��������");
		renewBookItem.setIcon(iconMap.get("renewIcon"));
		renewBookItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				local.viewChange("��������");
			}
		});
		borrowMenu.add(renewBookItem);
		// �����˵������������������������������������������������������������˵�
		JMenu helpMenu = new JMenu("����  (H)");
		borrowMenu.setMnemonic('H');
		borrowMenu.setVisible(true);
		headBar.add(helpMenu);
		// public SystemIntroductionPanel systemIntroductionPanel;//ϵͳ������
		// public AboutPanel aboutPanel;//�����������
		// ϵͳ���
		JMenuItem systemIntroductionPanelItem = new JMenuItem("ϵͳ���");
		systemIntroductionPanelItem.setIcon(iconMap.get("logoIcon"));
		systemIntroductionPanelItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				local.viewChange("ϵͳ���");
			}
		});
		helpMenu.add(systemIntroductionPanelItem);
		// ��������
		JMenuItem aboutlItem = new JMenuItem("��������");
		aboutlItem.setIcon(iconMap.get("aboutIcon"));
		aboutlItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				local.viewChange("��������");
			}
		});
		helpMenu.add(aboutlItem);

		//�������
		JMenuItem suggestionItem = new JMenuItem("�������");
		suggestionItem.setIcon(iconMap.get("suggestionIcon"));
		suggestionItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				local.viewChange("�������");
			}
		});
		helpMenu.add(suggestionItem);
	}
	/**
	 * 
	 * 
	 * 
	 * ��ʼ���������---------------------------------------------------------��ʼ���������
	 */
	public void contentPanelInit() {
		// ͼ�������塪����������������������������������������������ͼ��������
		/* ��ѯͼ����� */
		searchBookPanel = new SearchBookPanel(request);
		searchBookPanel.setLocation(contentPoint);
		searchBookPanel.setVisible(false);
		this.add(searchBookPanel);
		panelMap.put("��ѯͼ��", searchBookPanel);
		/* ���ͼ�� ��� */
		addBookPanel = new AddBookPanel(request);
		addBookPanel.setLocation(contentPoint);
		addBookPanel.setVisible(false);
		this.add(addBookPanel);
		panelMap.put("���ͼ��", addBookPanel);
		/* ɾ��ͼ����� */
		removeBookPanel = new RemoveBookPanel(request);
		removeBookPanel.setLocation(contentPoint);
		removeBookPanel.setVisible(false);
		this.add(removeBookPanel);
		panelMap.put("ɾ��ͼ��", removeBookPanel);
		// ���߹�����塪���������������������������������������������������߹������
		/* ��Ӷ������ */
		addReaderPanel = new AddReaderPanel(request);// ���ͼ�����
		addReaderPanel.setLocation(contentPoint);
		addReaderPanel.setVisible(false);
		this.add(addReaderPanel);
		panelMap.put("��Ӷ���", addReaderPanel);
		/* ɾ��������� */
		removeReaderPanel = new RemoveReaderPanel(request);
		removeReaderPanel.setLocation(contentPoint);
		removeReaderPanel.setVisible(false);
		this.add(removeReaderPanel);
		panelMap.put("ɾ������", removeReaderPanel);
		/* ��ѯ������� */
		searchReaderPanel = new SearchReaderPanel(request);
		searchReaderPanel.setLocation(contentPoint);
		searchReaderPanel.setVisible(false);
		this.add(searchReaderPanel);
		panelMap.put("��ѯ����", searchReaderPanel);
		/* �༭������� */
		editorReaderPanel = new EditorReaderPanel(request);
		editorReaderPanel.setLocation(contentPoint);
		editorReaderPanel.setVisible(false);
		this.add(editorReaderPanel);
		panelMap.put("�༭����", editorReaderPanel);
		// ���Ĺ�����塪���������������������������������������������������Ĺ������
		// ��ѯ����
		searchBorrowInfoPanel = new SearchBorrowInfoPanel(request);
		searchBorrowInfoPanel.setLocation(contentPoint);
		searchBorrowInfoPanel.setVisible(false);
		this.add(searchBorrowInfoPanel);
		panelMap.put("��ѯ����", searchBorrowInfoPanel);
		// �������
		borrowBookPanel = new BorrowBookPanel(request);
		borrowBookPanel.setLocation(contentPoint);
		borrowBookPanel.setVisible(false);
		this.add(borrowBookPanel);
		panelMap.put("�������", borrowBookPanel);
		// ������
		returnBookPanel = new ReturnBookPanel(request);
		returnBookPanel.setLocation(contentPoint);
		returnBookPanel.setVisible(false);
		this.add(returnBookPanel);
		panelMap.put("������", returnBookPanel);
		// ��������
		renewBookPanel = new RenewBookPanel(request);
		renewBookPanel.setLocation(contentPoint);
		renewBookPanel.setVisible(false);
		this.add(renewBookPanel);
		panelMap.put("��������", renewBookPanel);
		// ������塪�������������������������������������������������������
		// ϵͳ���
		systemIntroductionPanel = new SystemIntroductionPanel(request);
		systemIntroductionPanel.setLocation(contentPoint);
		systemIntroductionPanel.setVisible(false);
		this.add(systemIntroductionPanel);
		panelMap.put("ϵͳ���", systemIntroductionPanel);
		// ��������
		aboutPanel = new AboutPanel(request);
		aboutPanel.setLocation(contentPoint);
		aboutPanel.setVisible(false);
		this.add(aboutPanel);
		panelMap.put("��������", aboutPanel);
		// ����������
		suggestionPanel = new SuggestionPanel(request);
		suggestionPanel.setLocation(contentPoint);
		suggestionPanel.setVisible(false);
		this.add(suggestionPanel);
		panelMap.put("�������", suggestionPanel);
	}

	/**
	 * panelMap��Panel����ʾ�����ص�����
	 * @param panelName
	 */
	public void viewChange(String panelName) {
		for (String o : panelMap.keySet()) {
			if (o.equals(panelName)) {
				panelMap.get(o).setVisible(true);
			} else {
				panelMap.get(o).setVisible(false);
			}
		}
	}
//�رմ���
	public void  closePanel(String panelName){
	      panelMap.get(panelName).setVisible(false);
//	      panelMap.get("����").setVisible(true);
	}
	// panelMap���Ƿ��������ΪpanelName�����
	public boolean isExistPanel(String panelName) {
		for (Object o : panelMap.keySet()) {
			if (o.equals("panelName")) {
				return true;
			}
		}
		return false;
	}
}
