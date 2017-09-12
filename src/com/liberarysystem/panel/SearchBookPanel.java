package com.liberarysystem.panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.liberarysystem.service.BookService;
import com.liberarysystem.util.ContentPanelTemplet;
import com.liberarysystem.util.ImageAutosize;
import com.liberarysystem.util.MyMoth;
import com.liberarysystem.util.MyRequest;
import com.liberarysystem.util.PanelShowOrClose;

public class SearchBookPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private JPanel mainPanel;
	private Font font = new Font("宋体", Font.PLAIN, 22);
	private Font btFont = new Font("宋体", Font.PLAIN, 10);
	private Font textFont = new Font("宋体", Font.PLAIN, 16);
	public Font infoLabelFont = new Font("宋体", Font.PLAIN, 16);
	public Color dialogForeColor = new Color(255, 255, 255);
	public Color dialogBackColor = new Color(102, 102, 102);
	private Color textJLColor = Color.black;
	private Color btColor = new Color(102, 102, 102);
	private BookService bs = new BookService();
	private JTextField queryTextJF;// 查询内容输入框
	private JComboBox queryWayCB;// 查询方式下拉多选框
	private JButton queryBt;// 查询按钮
	/**
	 * 底部弹出式对话框块
	 */
	public JPanel dialogPanel;
	public JLabel infoLabel;

	public SearchBookPanel(MyRequest request){
		mainPanel = new ContentPanelTemplet().init(this, "查询图书",request);
		mainPanel.setLayout(null);
		mainPanel.setBackground(Color.white);
		init();
		this.add(mainPanel);
		this.setVisible(true);
	}
    public void init(){
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
		queryWayCB.addItem("出版社");
		queryWayCB.addItem("作者");
		queryWayCB.addItem("图书类型");
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
				PanelShowOrClose.showPanel(dialogPanel, queryBt, infoLabel, "错误信息：数据库连接失败！");
			}
		});
		queryBt.setVisible(true);
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
				
				mainPanel.add(queryTextJF);
				mainPanel.add(queryWayCB);
				mainPanel.add(queryBt);
				mainPanel.add(dialogPanel);
    }
}
