package com.liberarysystem.frame;
/**
 * 系统主界面
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
	/* 图书馆管理子页面 */
	public Color headBarColor = new Color(204, 204, 204);
	public SearchBookPanel searchBookPanel;// 查询图书面板
	public AddBookPanel addBookPanel;// 添加图书面板
	public RemoveBookPanel removeBookPanel;// 删除图书面板
	/* 读者管理子页面 */
	public SearchReaderPanel searchReaderPanel;// 读者查询面板
	public AddReaderPanel addReaderPanel;// 添加图书面板
	public RemoveReaderPanel removeReaderPanel;// 图书出库面板
	public EditorReaderPanel editorReaderPanel;// 修改图书信息面板
	/* 借阅管理子页面 */
	public SearchBorrowInfoPanel searchBorrowInfoPanel; // 查询借阅信息面板
	public BorrowBookPanel borrowBookPanel;// 办理借书面板
	public ReturnBookPanel returnBookPanel;// 办理还书面板
	public RenewBookPanel renewBookPanel;// 办理续借面板
	/* 帮助子页面 */
	public SystemIntroductionPanel systemIntroductionPanel;// 系统简介面板
	public AboutPanel aboutPanel;// 关于我们面板
	public SuggestionPanel suggestionPanel;// 意见反馈面板

	public Map<String, JPanel> panelMap = new HashMap<String, JPanel>();// 存放已经打开的ContentPanel的键值对
	public Map<String, String> panelText;// 存放ContentPanel类别与Text的键值对
	public Point contentPoint;
	public Map<String, ImageIcon> iconMap;
    public int headerBarSize;
    public String username;
	/**
	 * 初始化成员变量、窗体和装载request，
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
 * 初始化所需数据
 */
	public void initDate() {
		headerBarSize=30;//顶部菜单栏高度
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
	 * 初始化窗体中控件属性
	 */
	public void contentsInit() {
		headerPanel();// 初始化顶部菜单栏
		contentPanelInit();// 初始化中间内容面板
	}

	/** 
	 * 初始化顶部菜单栏---------------------------------------------------------初始化顶部菜单栏
	 */
	public void headerPanel() {
		JMenuBar headBar = new JMenuBar();
		headBar.setBackground(headBarColor);
		headBar.setBounds(0, 0, ScreenSize.getWidth(), headerBarSize);
		headBar.setVisible(true);
		this.add(headBar);
		//个人系统菜单项
		JMenu systemMenu = new JMenu();
		systemMenu.setIcon(iconMap.get("personalIcon"));
		systemMenu.setVisible(true);
		headBar.add(systemMenu);
		//退出系统
		JMenuItem exitItem = new JMenuItem("退出系统");
		exitItem.setIcon(iconMap.get("exitIcon"));
		exitItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int i=JOptionPane.showConfirmDialog(local,"确认退出系统单击确认，否则单击取消！"," ",JOptionPane.OK_CANCEL_OPTION);
				if(i==0){
				local.dispose();
				}
			}
		});
		systemMenu.add(exitItem);
		// 图书管理菜单————————————————————————图书管理菜单
		JMenu bookMenu = new JMenu("图书管理  (B)");
		bookMenu.setMnemonic('B');
		bookMenu.setVisible(true);
		headBar.add(bookMenu);
		// 添加图书
		JMenuItem addBookItem = new JMenuItem("添加图书");
		addBookItem.setIcon(iconMap.get("addIcon"));
		addBookItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				local.viewChange("添加图书");
			}
		});
		bookMenu.add(addBookItem);
		// 删除图书
		JMenuItem removeBookItem = new JMenuItem("删除图书");
		removeBookItem.setIcon(iconMap.get("removeIcon"));
		removeBookItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				local.viewChange("删除图书");
			}
		});
		bookMenu.add(removeBookItem);
		// 查询图书
		JMenuItem searchBookItem = new JMenuItem("查询图书");
		searchBookItem.setIcon(iconMap.get("searchIcon"));
		searchBookItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				local.viewChange("查询图书");
			}
		});
		bookMenu.add(searchBookItem);
		// 读者管理菜单————————————————————————读者管理菜单
		JMenu readerMenu = new JMenu("读者管理  (R)");
		readerMenu.setMnemonic('R');
		readerMenu.setVisible(true);
		headBar.add(readerMenu);
		// 添加读者
		JMenuItem addReaderItem = new JMenuItem("添加读者");
		addReaderItem.setIcon(iconMap.get("addIcon"));
		addReaderItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				local.viewChange("添加读者");
			}
		});
		readerMenu.add(addReaderItem);
		// 删除读者
		JMenuItem removeReaderItem = new JMenuItem("删除读者");
		removeReaderItem.setIcon(iconMap.get("removeIcon"));
		removeReaderItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				local.viewChange("删除读者");
			}
		});
		readerMenu.add(removeReaderItem);
		// 查询读者
		JMenuItem searchReaderItem = new JMenuItem("查询读者");
		searchReaderItem.setIcon(iconMap.get("searchIcon"));
		searchReaderItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				local.viewChange("查询读者");
			}
		});
		readerMenu.add(searchReaderItem);
		// 编辑读者
		JMenuItem editorReaderItem = new JMenuItem("编辑读者");
		editorReaderItem.setIcon(iconMap.get("editorIcon"));
		editorReaderItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				local.viewChange("编辑读者");
			}
		});
		readerMenu.add(editorReaderItem);
		// 借阅管理菜单————————————————————————借阅读者管理菜单
		JMenu borrowMenu = new JMenu("借阅管理  (A)");
		borrowMenu.setMnemonic('A');
		borrowMenu.setVisible(true);
		headBar.add(borrowMenu);
		// 查询借阅
		JMenuItem searchBorrowInfoItem = new JMenuItem("查询借阅");
		searchBorrowInfoItem.setIcon(iconMap.get("searchIcon"));
		searchBorrowInfoItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				local.viewChange("查询借阅");
			}
		});
		borrowMenu.add(searchBorrowInfoItem);
		// 办理借书
		JMenuItem borrowBookItem = new JMenuItem("办理借书");
		borrowBookItem.setIcon(iconMap.get("borrowIcon"));
		borrowBookItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				local.viewChange("办理借书");
			}
		});
		borrowMenu.add(borrowBookItem);
		// 办理还书
		JMenuItem returnBookItem = new JMenuItem("办理还书");
		returnBookItem.setIcon(iconMap.get("returnIcon"));
		returnBookItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				local.viewChange("办理还书");
			}
		});
		borrowMenu.add(returnBookItem);
		// 办理续借
		JMenuItem renewBookItem = new JMenuItem("办理续借");
		renewBookItem.setIcon(iconMap.get("renewIcon"));
		renewBookItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				local.viewChange("办理续借");
			}
		});
		borrowMenu.add(renewBookItem);
		// 帮助菜单———————————————————————————帮助菜单
		JMenu helpMenu = new JMenu("帮助  (H)");
		borrowMenu.setMnemonic('H');
		borrowMenu.setVisible(true);
		headBar.add(helpMenu);
		// public SystemIntroductionPanel systemIntroductionPanel;//系统简介面板
		// public AboutPanel aboutPanel;//关于我们面板
		// 系统简介
		JMenuItem systemIntroductionPanelItem = new JMenuItem("系统简介");
		systemIntroductionPanelItem.setIcon(iconMap.get("logoIcon"));
		systemIntroductionPanelItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				local.viewChange("系统简介");
			}
		});
		helpMenu.add(systemIntroductionPanelItem);
		// 关于我们
		JMenuItem aboutlItem = new JMenuItem("关于我们");
		aboutlItem.setIcon(iconMap.get("aboutIcon"));
		aboutlItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				local.viewChange("关于我们");
			}
		});
		helpMenu.add(aboutlItem);

		//意见反馈
		JMenuItem suggestionItem = new JMenuItem("意见反馈");
		suggestionItem.setIcon(iconMap.get("suggestionIcon"));
		suggestionItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				local.viewChange("意见反馈");
			}
		});
		helpMenu.add(suggestionItem);
	}
	/**
	 * 
	 * 
	 * 
	 * 初始化所有面板---------------------------------------------------------初始化所有面板
	 */
	public void contentPanelInit() {
		// 图书管理面板————————————————————————图书管理面板
		/* 查询图书面板 */
		searchBookPanel = new SearchBookPanel(request);
		searchBookPanel.setLocation(contentPoint);
		searchBookPanel.setVisible(false);
		this.add(searchBookPanel);
		panelMap.put("查询图书", searchBookPanel);
		/* 添加图书 面板 */
		addBookPanel = new AddBookPanel(request);
		addBookPanel.setLocation(contentPoint);
		addBookPanel.setVisible(false);
		this.add(addBookPanel);
		panelMap.put("添加图书", addBookPanel);
		/* 删除图书面板 */
		removeBookPanel = new RemoveBookPanel(request);
		removeBookPanel.setLocation(contentPoint);
		removeBookPanel.setVisible(false);
		this.add(removeBookPanel);
		panelMap.put("删除图书", removeBookPanel);
		// 读者管理面板—————————————————————————读者管理面板
		/* 添加读者面板 */
		addReaderPanel = new AddReaderPanel(request);// 添加图书面板
		addReaderPanel.setLocation(contentPoint);
		addReaderPanel.setVisible(false);
		this.add(addReaderPanel);
		panelMap.put("添加读者", addReaderPanel);
		/* 删除读者面板 */
		removeReaderPanel = new RemoveReaderPanel(request);
		removeReaderPanel.setLocation(contentPoint);
		removeReaderPanel.setVisible(false);
		this.add(removeReaderPanel);
		panelMap.put("删除读者", removeReaderPanel);
		/* 查询读者面板 */
		searchReaderPanel = new SearchReaderPanel(request);
		searchReaderPanel.setLocation(contentPoint);
		searchReaderPanel.setVisible(false);
		this.add(searchReaderPanel);
		panelMap.put("查询读者", searchReaderPanel);
		/* 编辑读者面板 */
		editorReaderPanel = new EditorReaderPanel(request);
		editorReaderPanel.setLocation(contentPoint);
		editorReaderPanel.setVisible(false);
		this.add(editorReaderPanel);
		panelMap.put("编辑读者", editorReaderPanel);
		// 借阅管理面板—————————————————————————借阅管理面板
		// 查询借阅
		searchBorrowInfoPanel = new SearchBorrowInfoPanel(request);
		searchBorrowInfoPanel.setLocation(contentPoint);
		searchBorrowInfoPanel.setVisible(false);
		this.add(searchBorrowInfoPanel);
		panelMap.put("查询借阅", searchBorrowInfoPanel);
		// 办理借书
		borrowBookPanel = new BorrowBookPanel(request);
		borrowBookPanel.setLocation(contentPoint);
		borrowBookPanel.setVisible(false);
		this.add(borrowBookPanel);
		panelMap.put("办理借书", borrowBookPanel);
		// 办理还书
		returnBookPanel = new ReturnBookPanel(request);
		returnBookPanel.setLocation(contentPoint);
		returnBookPanel.setVisible(false);
		this.add(returnBookPanel);
		panelMap.put("办理还书", returnBookPanel);
		// 办理续借
		renewBookPanel = new RenewBookPanel(request);
		renewBookPanel.setLocation(contentPoint);
		renewBookPanel.setVisible(false);
		this.add(renewBookPanel);
		panelMap.put("办理续借", renewBookPanel);
		// 帮助面板—————————————————————————帮助面板
		// 系统简介
		systemIntroductionPanel = new SystemIntroductionPanel(request);
		systemIntroductionPanel.setLocation(contentPoint);
		systemIntroductionPanel.setVisible(false);
		this.add(systemIntroductionPanel);
		panelMap.put("系统简介", systemIntroductionPanel);
		// 关于我们
		aboutPanel = new AboutPanel(request);
		aboutPanel.setLocation(contentPoint);
		aboutPanel.setVisible(false);
		this.add(aboutPanel);
		panelMap.put("关于我们", aboutPanel);
		// 意见反馈面板
		suggestionPanel = new SuggestionPanel(request);
		suggestionPanel.setLocation(contentPoint);
		suggestionPanel.setVisible(false);
		this.add(suggestionPanel);
		panelMap.put("意见反馈", suggestionPanel);
	}

	/**
	 * panelMap中Panel的显示与隐藏的设置
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
//关闭窗体
	public void  closePanel(String panelName){
	      panelMap.get(panelName).setVisible(false);
//	      panelMap.get("背景").setVisible(true);
	}
	// panelMap中是否存在类名为panelName的面板
	public boolean isExistPanel(String panelName) {
		for (Object o : panelMap.keySet()) {
			if (o.equals("panelName")) {
				return true;
			}
		}
		return false;
	}
}
