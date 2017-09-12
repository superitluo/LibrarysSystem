package com.liberarysystem.panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.util.Iterator;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import com.liberarysystem.entity.BookTypeEntity;
import com.liberarysystem.entity.LogEntity;
import com.liberarysystem.entity.PublishEntity;
import com.liberarysystem.service.BookService;
import com.liberarysystem.service.LogService;
import com.liberarysystem.service.MessagerService;
import com.liberarysystem.util.ContentPanelTemplet;
import com.liberarysystem.util.MyRequest;
import com.liberarysystem.util.PanelShowOrClose;
import com.liberarysystem.util.ShowPanelRun;
import com.liberarysystem.util.ClosePanelRun;

/**
 * description:添加图书模块面板类 author:suoeritluo@163.com
 */

public class AddBookPanel extends JPanel {
	/**
	 * 成员属性的添加
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 声明所需要的样式对象
	 */
	public Color labelFontColor = new Color(102, 102, 102);
	public Color errorLabelfontColor = new Color(255, 0, 0);
	public Color dialogForeColor = new Color(255, 255, 255);
	public Color dialogBackColor = new Color(102, 102, 102);
	public Font font = new Font("微软雅黑", Font.PLAIN, 18);
	public Font infoLabelFont = new Font("宋体", Font.PLAIN, 26);
	public JPanel mainPanel;// 主要的内容面板
	public String username;// 获得的用户名
	/**
	 * 输入书名块
	 */
	public JLabel bookNameLabel;
	public JTextField bookNameTF;
	public JLabel bookNameErrorLabel;
	/**
	 * 输入作者块
	 */
	public JLabel autherLabel;
	public JTextField autherTF;
	public JLabel autherErrorLabel;
	/**
	 * 出版社选择块
	 */
	public JLabel publisherLabel;
	public JComboBox publisherCB;
	public JLabel publisherErrorLabel;
	/**
	 * 图书类型选择块
	 */
	public JLabel bookTypeLabel;
	public JComboBox bookTypeCB;
	public JLabel bookTypeErrorLabel;
	/**
	 * 入库图书总数块
	 */
	public JLabel bookSumLabel;
	public JSpinner bookSumSp;
	public JLabel bookSumErrorLabel;
	/**
	 * 提交与重置块
	 */
	public JButton submitBt;
	public JButton resetBt;
	/**
	 * 底部弹出式对话框块
	 */
	public JPanel dialogPanel;
	public JLabel infoLabel;
	/**
	 * 图书数据处理
	 */
	public BookService bs;

	/**
	 * 根据自定义的模板设置面板的基础控件，并获的子界面的主要内容面板
	 */
	public AddBookPanel(MyRequest request) {
		this.username = (String) request.getAttribute("username");
		mainPanel = new ContentPanelTemplet().init(this, "添加图书", request);
		mainPanel.setLayout(null);
		mainPanel.setBackground(Color.white);
		init();
		this.add(mainPanel);
		this.setVisible(true);
	}

	/**
	 * 主要内容控件的初始化
	 */
	public void init() {
		bs = new BookService();
		/**
		 * 初始化图书名称块
		 */
		bookNameLabel = new JLabel("图书名称：");
		bookNameLabel.setBounds(327, 70, 90, 30);
		bookNameLabel.setForeground(labelFontColor);
		bookNameLabel.setFont(font);
		bookNameLabel.setVisible(true);
		bookNameTF = new JTextField();
		bookNameTF.setBounds(420, 70, 200, 30);
		bookNameTF.setBackground(Color.white);
		bookNameTF.setFont(font);
		bookNameTF.setForeground(labelFontColor);
		bookNameTF.setVisible(true);
		bookNameErrorLabel = new JLabel("*");
		bookNameErrorLabel.setForeground(errorLabelfontColor);
		bookNameErrorLabel.setBounds(630, 70, 310, 30);
		bookNameErrorLabel.setFont(font);
		bookNameErrorLabel.setVisible(true);
		/**
		 * 初始化作者块
		 */
		autherLabel = new JLabel("作       者：");
		autherLabel.setBounds(327, 120, 90, 30);
		autherLabel.setForeground(labelFontColor);
		autherLabel.setFont(font);
		autherLabel.setVisible(true);
		autherTF = new JTextField();
		autherTF.setBounds(420, 120, 200, 30);
		autherTF.setBackground(Color.white);
		autherTF.setFont(font);
		autherTF.setForeground(labelFontColor);
		autherTF.setVisible(true);
		autherErrorLabel = new JLabel("*");
		autherErrorLabel.setForeground(errorLabelfontColor);
		autherErrorLabel.setBounds(630, 120, 310, 30);
		autherErrorLabel.setFont(font);
		autherErrorLabel.setVisible(true);
		/**
		 * 初始化出版社选择块
		 */
		publisherLabel = new JLabel("出 版 社 ：");
		publisherLabel.setBounds(327, 175, 90, 30);
		publisherLabel.setForeground(labelFontColor);
		publisherLabel.setFont(font);
		publisherLabel.setVisible(true);
		publisherCB = new JComboBox<>();
		publisherCB.addItem("");

		List publishList = bs.getPublishList();
		if (!publishList.isEmpty()) {
			Iterator it = publishList.iterator();
			// System.out.println("类型Id"+" "+"类型名");
			while (it.hasNext()) {
				PublishEntity publish = (PublishEntity) it.next();
				publisherCB.addItem(publish.getName());
				// System.out.println(bte.getId()+" "+bte.getName());
			}
		} else {
			System.out.println("出版社类型加载失败！");
		}
		// publisherCB.addItem("清华大学出版社");
		// publisherCB.addItem("电子工业大学出版社");
		publisherCB.setBounds(420, 175, 200, 30);
		publisherCB.setBackground(Color.white);
		publisherCB.setFont(font);
		publisherCB.setForeground(labelFontColor);
		publisherCB.setVisible(true);
		publisherErrorLabel = new JLabel("*");
		publisherErrorLabel.setForeground(errorLabelfontColor);
		publisherErrorLabel.setBounds(630, 175, 310, 30);
		publisherErrorLabel.setFont(font);
		publisherErrorLabel.setVisible(true);
		/**
		 * 初始化图书类型选择块
		 */
		bookTypeLabel = new JLabel("图书类型：");
		bookTypeLabel.setBounds(327, 233, 90, 30);
		bookTypeLabel.setForeground(labelFontColor);
		bookTypeLabel.setFont(font);
		bookTypeLabel.setVisible(true);
		bookTypeCB = new JComboBox<>();
		bookTypeCB.addItem("");
		// 测试

		List bookTypeList = bs.getBookTypeList();
		if (!bookTypeList.isEmpty()) {
			Iterator it = bookTypeList.iterator();
			// System.out.println("类型Id"+" "+"类型名");
			while (it.hasNext()) {
				BookTypeEntity bte = (BookTypeEntity) it.next();
				bookTypeCB.addItem(bte.getName());
				// System.out.println(bte.getId()+" "+bte.getName());
			}
		} else {
			System.out.println("图书类型数据为空！");
		}
		// bookTypeCB.addItem("文学");
		// bookTypeCB.addItem("理工");
		bookTypeCB.setBounds(420, 233, 200, 30);
		bookTypeCB.setBackground(Color.white);
		bookTypeCB.setFont(font);
		bookTypeCB.setForeground(labelFontColor);
		bookTypeCB.setVisible(true);
		bookTypeErrorLabel = new JLabel("*");
		bookTypeErrorLabel.setForeground(errorLabelfontColor);
		bookTypeErrorLabel.setBounds(630, 233, 310, 30);
		bookTypeErrorLabel.setFont(font);
		bookTypeErrorLabel.setVisible(true);
		/**
		 * 初始化入库图书的总数
		 */
		bookSumLabel = new JLabel("入库总数：");
		bookSumLabel.setBounds(327, 285, 90, 30);
		bookSumLabel.setForeground(labelFontColor);
		bookSumLabel.setFont(font);
		bookSumLabel.setVisible(true);
		SpinnerModel model = new SpinnerNumberModel(10, 1, 100, 1);
		bookSumSp = new JSpinner(model);
		bookSumSp.setBounds(420, 285, 70, 30);
		bookSumSp.setBackground(Color.white);
		bookSumSp.setFont(font);
		bookSumSp.setForeground(labelFontColor);
		bookSumSp.setVisible(true);
		bookSumErrorLabel = new JLabel("*");
		bookSumErrorLabel.setForeground(errorLabelfontColor);
		bookSumErrorLabel.setBounds(500, 285, 310, 30);
		bookSumErrorLabel.setFont(font);
		bookSumErrorLabel.setVisible(true);
		/**
		 * 初始化提交按钮并配置响应事件
		 */
		submitBt = new JButton("添加");
		submitBt.setBounds(319, 350, 100, 30);
		submitBt.setBackground(labelFontColor);
		submitBt.setForeground(Color.WHITE);
		submitBt.setBorder(null);
		submitBt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (checkForm()) {
					submitBt.setEnabled(false);
					String bookName = bookNameTF.getText();
					String auther = autherTF.getText();
					String publisher = publisherCB.getSelectedItem().toString();
					String bookType = bookTypeCB.getSelectedItem().toString();
					int bookSum = (Integer) bookSumSp.getValue();
					if (!bs.isExistBook(bookName, publisher, auther)) {
						if (bs.addBook(bookName, bookType, publisher, auther, bookSum)) {
							PanelShowOrClose.showPanel(dialogPanel, submitBt, infoLabel, "添加书籍成功！");
							LogEntity log = new LogEntity("添加图书操作"+"《"+bookName+"》" ,new Date(new java.util.Date().getTime()),MessagerService.getMessagerId(username));
							LogService.addLog(log);
						} else {
							PanelShowOrClose.showPanel(dialogPanel, submitBt, infoLabel, "错误信息：数据库连接失败！");
						}
						// panelShowOrClose.closePanel(dialogPanel,submitBt);
					} else {
						PanelShowOrClose.showPanel(dialogPanel, submitBt, infoLabel, "错误信息：数据库存在同样的书！");
					}
				}
			}
		});
		submitBt.setVisible(true);
		/**
		 * 初始化重置按钮，并且配置响应事件
		 */
		resetBt = new JButton("重置");
		resetBt.setBounds(520, 350, 100, 30);
		resetBt.setBackground(labelFontColor);
		resetBt.setForeground(Color.WHITE);
		resetBt.setBorder(null);
		resetBt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				bookNameTF.setText("");
				autherTF.setText("");
				publisherCB.setSelectedItem("");
				bookTypeCB.setSelectedItem("");
				bookSumSp.setValue(10);
				bookNameErrorLabel.setText("*");
				bookTypeErrorLabel.setText("*");
				publisherErrorLabel.setText("*");
				autherErrorLabel.setText("*");
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
		 * 将控件一一加入主面板
		 */
		mainPanel.add(bookNameTF);
		mainPanel.add(bookNameLabel);
		mainPanel.add(bookNameErrorLabel);
		mainPanel.add(autherTF);
		mainPanel.add(autherLabel);
		mainPanel.add(autherErrorLabel);
		mainPanel.add(publisherLabel);
		mainPanel.add(publisherCB);
		mainPanel.add(publisherErrorLabel);
		mainPanel.add(bookTypeLabel);
		mainPanel.add(bookTypeCB);
		mainPanel.add(bookTypeErrorLabel);
		mainPanel.add(bookSumLabel);
		mainPanel.add(bookSumSp);
		mainPanel.add(bookSumErrorLabel);
		mainPanel.add(submitBt);
		mainPanel.add(resetBt);
		mainPanel.add(dialogPanel);
		mainPanel.setVisible(true);
	}

	/**
	 * 验证表单数据的正确性，并返回布尔类型验证结果
	 * 
	 * @return
	 */
	public boolean checkForm() {
		Boolean result = true;
		String bookNameText = bookNameTF.getText();
		String autherText = autherTF.getText();
		String publisherText = publisherCB.getSelectedItem().toString();
		String bookTypeText = bookTypeCB.getSelectedItem().toString();
		if (bookNameText.equals("") || bookNameText == null) {
			bookNameErrorLabel.setText("* 图书名称不能为空！");
			result = false;
		} else if (bookNameText.indexOf(" ") != -1) {
			bookNameErrorLabel.setText("* 图书名称中不能含有空格！");
			result = false;
		} else {
			bookNameErrorLabel.setText("*");
		}

		if (autherText.equals("") || autherText == null) {
			autherErrorLabel.setText("* 作者名不能为空！");
			result = false;
		} else if (autherText.indexOf(" ") != -1) {
			autherErrorLabel.setText("* 作者名中不能含有空格！");
			result = false;
		} else {
			autherErrorLabel.setText("*");
		}

		if (publisherText.equals("") || publisherText == null) {
			publisherErrorLabel.setText("* 出版社不能为空！");
			result = false;
		} else if (publisherText.indexOf(" ") != -1) {
			publisherErrorLabel.setText("* 出版社中不能含有空格！");
			result = false;
		} else {
			publisherErrorLabel.setText("*");
		}

		if (bookTypeText.equals("") || bookTypeText == null) {
			bookTypeErrorLabel.setText("*图书类型不能为空！");
			result = false;
		} else if (bookTypeText.indexOf(" ") != -1) {
			bookTypeErrorLabel.setText("* 图书类型中不能含有空格！");
			result = false;
		} else {
			bookTypeErrorLabel.setText("*");
		}
		return result;
	}
}
