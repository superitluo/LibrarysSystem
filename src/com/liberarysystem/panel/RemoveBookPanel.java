package com.liberarysystem.panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import com.liberarysystem.entity.BookEntity;
import com.liberarysystem.entity.LogEntity;
import com.liberarysystem.frame.MainFrame;
import com.liberarysystem.service.BookService;
import com.liberarysystem.service.LogService;
import com.liberarysystem.service.MessagerService;
import com.liberarysystem.util.ContentPanelTemplet;
import com.liberarysystem.util.ImageAutosize;
import com.liberarysystem.util.MyMoth;
import com.liberarysystem.util.MyRequest;
import com.liberarysystem.util.PanelShowOrClose;
import com.liberarysystem.util.RoundBorder;

public class RemoveBookPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private Font font = new Font("宋体", Font.PLAIN, 22);
	private Font btFont = new Font("宋体", Font.PLAIN, 10);
	private Font textFont = new Font("宋体", Font.PLAIN, 16);
	public Font infoLabelFont = new Font("宋体", Font.PLAIN, 16);
	public Color dialogForeColor = new Color(255, 255, 255);
	public Color dialogBackColor = new Color(102, 102, 102);
	private Color textJLColor = Color.black;
	private Color btColor = new Color(102, 102, 102);
	private BookService bs = new BookService();
	private JPanel mainPanel;
	private JTextField queryTextJF;// 查询内容输入框
	private JComboBox queryWayCB;// 查询方式下拉多选框
	private JButton queryBt;// 查询按钮
	private JLabel bookIdJL;
	private JLabel bookIdTextJL;
	private JLabel bookNameJL;
	private JLabel bookNameTextJL;
	private JLabel authorJL;
	private JLabel authorTextJL;
	private JButton submitBt;
	private JButton resetBt;
	private MyRequest request;
	/**
	 * 底部弹出式对话框块
	 */
	public JPanel dialogPanel;
	public JLabel infoLabel;

	public RemoveBookPanel(MyRequest request) {
		this.request = request;
		mainPanel = new ContentPanelTemplet().init(this, "删除图书", request);
		mainPanel.setLayout(null);
		mainPanel.setBackground(Color.white);
		init();
		this.add(mainPanel);
		this.setVisible(true);
	}

	public void init() {
		// 初始化查询的文本输入框
		queryTextJF = new JTextField();
		queryTextJF.setBounds(230, 180, 350, 30);
		queryTextJF.setBackground(Color.white);
		queryTextJF.setFont(font);
		queryTextJF.setVisible(true);
		// 初始化查询方式下拉列表框
		queryWayCB = new JComboBox<>();
		queryWayCB.setBounds(580, 180, 150, 30);
		queryWayCB.setBackground(Color.WHITE);
		queryWayCB.setBorder(null);
		queryWayCB.addItem("图书编号");
		queryWayCB.addItem("图书名称");
		queryWayCB.setFont(font);
		queryWayCB.setVisible(true);
		// 初始化查询按钮
		queryBt = new JButton();
		queryBt.setBounds(740, 180, 30, 30);
		queryBt.setFont(btFont);
		queryBt.setBorder(null);
		queryBt.setBackground(Color.WHITE);
		queryBt.setIcon(ImageAutosize.ImageAutosize("./resource/image/query.png", queryBt));
		queryBt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				resetText();
				String queryText = queryTextJF.getText();// 获得查询输入框的文本内容
				String queryWay = queryWayCB.getSelectedItem().toString();// 获得查询方式的文本名称
				ArrayList bookList = null;
				if (queryText == "" || queryText.equals("")) {
					PanelShowOrClose.showPanel(dialogPanel, queryBt, infoLabel, "错误信息：你输入的搜索信息不能为空！");
				} else {
					// 如果根据书籍编号
					if (queryWay == "图书编号") {
						if (MyMoth.isNumeric(queryText)) {
							bookList = bs.getBooksById(queryText);
							setBookInfoText(bookList);
						} else {
							PanelShowOrClose.showPanel(dialogPanel, queryBt, infoLabel, "错误信息：请输入全数字的编号");
						}
					}
					// 如果根据书籍名称
					if (queryWay == "图书名称") {
						bookList = bs.getBooksByName(queryText);
						setBookInfoText(bookList);
					}

				}
			}
		});
		queryBt.setVisible(true);
		// 初始化图书编号标签头
		bookIdJL = new JLabel("图书编号:");
		ImageIcon bookIdJLIcon = new ImageIcon("./resource/image/bookIdJL.png");
		bookIdJL.setBounds(310, 240, bookIdJLIcon.getIconWidth(), bookIdJLIcon.getIconHeight());
		bookIdJL.setIcon(bookIdJLIcon);
		bookIdJL.setVisible(true);
		// 初始化图书编号的值显示标签
		bookIdTextJL = new JLabel();
		bookIdTextJL.setBounds(430, 255, 200, 30);
		bookIdTextJL.setFont(textFont);
		bookIdTextJL.setVisible(true);
		// 初始化图书名称标签头
		bookNameJL = new JLabel("图书名称:");
		ImageIcon bookNameJLIcon = new ImageIcon("./resource/image/bookNameJL.png");
		bookNameJL.setBounds(310, 280, bookNameJLIcon.getIconWidth(), bookNameJLIcon.getIconHeight());
		bookNameJL.setIcon(bookNameJLIcon);
		bookNameJL.setVisible(true);
		// 初始化图书名称的值显示标签
		bookNameTextJL = new JLabel();
		bookNameTextJL.setBounds(430, 295, 200, 30);
		bookNameTextJL.setFont(textFont);
		bookNameTextJL.setVisible(true);
		// 初始化作者名字标签头
		authorJL = new JLabel();
		ImageIcon authorJLIcon = new ImageIcon("./resource/image/authorJL.png");
		authorJL.setBounds(310, 320, authorJLIcon.getIconWidth(), authorJLIcon.getIconHeight());
		authorJL.setIcon(authorJLIcon);
		authorJL.setVisible(true);
		// 初始化作者的值显示标签
		authorTextJL = new JLabel();
		authorTextJL.setBounds(430, 335, 200, 20);
		authorTextJL.setFont(textFont);
		authorTextJL.setVisible(true);
		// 初始化提交按钮并配置响应事件
		submitBt = new JButton("删除图书");
		submitBt.setBounds(320, 380, 100, 30);
		submitBt.setBackground(btColor);
		submitBt.setForeground(Color.WHITE);
		submitBt.setBorder(null);
		submitBt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String bookName = bookNameTextJL.getText();
				String bookId = bookIdTextJL.getText();
			    if(bookId.equals("")||bookId==""){
			    	PanelShowOrClose.showPanel(dialogPanel, submitBt, infoLabel, "待删除书籍编号有误！");
			    }else{
				int isDelete = JOptionPane.showConfirmDialog(null, "是否删除" + "《 " + bookName + "》！", "确认删除",
						JOptionPane.YES_NO_OPTION);
				if (isDelete == 0 && bs.deleteBook(bookId)) {
					PanelShowOrClose.showPanel(dialogPanel, submitBt, infoLabel, "删除《 " + bookName + "》！成功！");
					// 创建日志对象并将对象记录在日志表中
					LogEntity log = new LogEntity("删除图书：《 " + bookName + "》", new Date(new java.util.Date().getTime()),
							MessagerService.getMessagerId((String) request.getAttribute("username")));
					LogService.addLog(log);
				} else {
					PanelShowOrClose.showPanel(dialogPanel, submitBt, infoLabel, "删除《 " + bookName + "》！失败！");
				}
			 }
			}
		});
		submitBt.setVisible(true);
		// 初始化重置按钮，并且配置响应事件
		resetBt = new JButton("重置");
		resetBt.setBounds(520, 380, 100, 30);
		resetBt.setBackground(btColor);
		resetBt.setForeground(Color.WHITE);
		resetBt.setBorder(null);
		resetBt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				resetText();
				queryTextJF.setText("");
				queryWayCB.setSelectedIndex(0);
			}
		});
		resetBt.setVisible(true);
		// 初始化底部弹出式窗口;
		dialogPanel = new JPanel();
		dialogPanel.setLayout(null);
		dialogPanel.setBounds(0, 420, 947, 88);
		dialogPanel.setBackground(dialogBackColor);
		dialogPanel.setVisible(false);
		infoLabel = new JLabel();
		infoLabel.setBounds(158, 26, 630, 36);
		infoLabel.setFont(infoLabelFont);
		infoLabel.setForeground(dialogForeColor);
		infoLabel.setVisible(true);
		dialogPanel.add(infoLabel);
		/**
		 * 初始化提交按钮并配置响应事件
		 */
		mainPanel.add(queryTextJF);
		mainPanel.add(queryWayCB);
		mainPanel.add(queryBt);
		mainPanel.add(bookIdJL);
		mainPanel.add(bookIdTextJL);
		mainPanel.add(bookNameJL);
		mainPanel.add(bookNameTextJL);
		mainPanel.add(authorJL);
		mainPanel.add(authorTextJL);
		mainPanel.add(submitBt);
		mainPanel.add(resetBt);
		mainPanel.add(dialogPanel);
	}
	/**
	 * 重置表单的值为空
	 */
	public void resetText() {
		bookNameTextJL.setText("");
		bookIdTextJL.setText("");
		authorTextJL.setText("");
	}
	/*
	 * 根据数据库获得数据设置书籍信息表单的显示
	 */
	public void setBookInfoText(ArrayList bookList) {
		if (bookList.size() == 0) {
			PanelShowOrClose.showPanel(dialogPanel, queryBt, infoLabel, "错误信息：没有找到你要查询的书籍！");
			
		} else if (bookList.size() > 0) {
			Iterator it = bookList.iterator();
			while (it.hasNext()) {
				BookEntity book = (BookEntity) it.next();
				bookNameTextJL.setText(book.getName());
				bookIdTextJL.setText(((Integer) book.getId()).toString());
				authorTextJL.setText(book.getAuthor());
			}
			submitBt.setEnabled(true);
		} else {
			PanelShowOrClose.showPanel(dialogPanel, queryBt, infoLabel, "错误信息：查询失败！");
			submitBt.setEnabled(false);
		}
	}
}
