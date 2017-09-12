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
	private Font font = new Font("����", Font.PLAIN, 22);
	private Font btFont = new Font("����", Font.PLAIN, 10);
	private Font textFont = new Font("����", Font.PLAIN, 16);
	public Font infoLabelFont = new Font("����", Font.PLAIN, 16);
	public Color dialogForeColor = new Color(255, 255, 255);
	public Color dialogBackColor = new Color(102, 102, 102);
	private Color textJLColor = Color.black;
	private Color btColor = new Color(102, 102, 102);
	private BookService bs = new BookService();
	private JPanel mainPanel;
	private JTextField queryTextJF;// ��ѯ���������
	private JComboBox queryWayCB;// ��ѯ��ʽ������ѡ��
	private JButton queryBt;// ��ѯ��ť
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
	 * �ײ�����ʽ�Ի����
	 */
	public JPanel dialogPanel;
	public JLabel infoLabel;

	public RemoveBookPanel(MyRequest request) {
		this.request = request;
		mainPanel = new ContentPanelTemplet().init(this, "ɾ��ͼ��", request);
		mainPanel.setLayout(null);
		mainPanel.setBackground(Color.white);
		init();
		this.add(mainPanel);
		this.setVisible(true);
	}

	public void init() {
		// ��ʼ����ѯ���ı������
		queryTextJF = new JTextField();
		queryTextJF.setBounds(230, 180, 350, 30);
		queryTextJF.setBackground(Color.white);
		queryTextJF.setFont(font);
		queryTextJF.setVisible(true);
		// ��ʼ����ѯ��ʽ�����б��
		queryWayCB = new JComboBox<>();
		queryWayCB.setBounds(580, 180, 150, 30);
		queryWayCB.setBackground(Color.WHITE);
		queryWayCB.setBorder(null);
		queryWayCB.addItem("ͼ����");
		queryWayCB.addItem("ͼ������");
		queryWayCB.setFont(font);
		queryWayCB.setVisible(true);
		// ��ʼ����ѯ��ť
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
				String queryText = queryTextJF.getText();// ��ò�ѯ�������ı�����
				String queryWay = queryWayCB.getSelectedItem().toString();// ��ò�ѯ��ʽ���ı�����
				ArrayList bookList = null;
				if (queryText == "" || queryText.equals("")) {
					PanelShowOrClose.showPanel(dialogPanel, queryBt, infoLabel, "������Ϣ���������������Ϣ����Ϊ�գ�");
				} else {
					// ��������鼮���
					if (queryWay == "ͼ����") {
						if (MyMoth.isNumeric(queryText)) {
							bookList = bs.getBooksById(queryText);
							setBookInfoText(bookList);
						} else {
							PanelShowOrClose.showPanel(dialogPanel, queryBt, infoLabel, "������Ϣ��������ȫ���ֵı��");
						}
					}
					// ��������鼮����
					if (queryWay == "ͼ������") {
						bookList = bs.getBooksByName(queryText);
						setBookInfoText(bookList);
					}

				}
			}
		});
		queryBt.setVisible(true);
		// ��ʼ��ͼ���ű�ǩͷ
		bookIdJL = new JLabel("ͼ����:");
		ImageIcon bookIdJLIcon = new ImageIcon("./resource/image/bookIdJL.png");
		bookIdJL.setBounds(310, 240, bookIdJLIcon.getIconWidth(), bookIdJLIcon.getIconHeight());
		bookIdJL.setIcon(bookIdJLIcon);
		bookIdJL.setVisible(true);
		// ��ʼ��ͼ���ŵ�ֵ��ʾ��ǩ
		bookIdTextJL = new JLabel();
		bookIdTextJL.setBounds(430, 255, 200, 30);
		bookIdTextJL.setFont(textFont);
		bookIdTextJL.setVisible(true);
		// ��ʼ��ͼ�����Ʊ�ǩͷ
		bookNameJL = new JLabel("ͼ������:");
		ImageIcon bookNameJLIcon = new ImageIcon("./resource/image/bookNameJL.png");
		bookNameJL.setBounds(310, 280, bookNameJLIcon.getIconWidth(), bookNameJLIcon.getIconHeight());
		bookNameJL.setIcon(bookNameJLIcon);
		bookNameJL.setVisible(true);
		// ��ʼ��ͼ�����Ƶ�ֵ��ʾ��ǩ
		bookNameTextJL = new JLabel();
		bookNameTextJL.setBounds(430, 295, 200, 30);
		bookNameTextJL.setFont(textFont);
		bookNameTextJL.setVisible(true);
		// ��ʼ���������ֱ�ǩͷ
		authorJL = new JLabel();
		ImageIcon authorJLIcon = new ImageIcon("./resource/image/authorJL.png");
		authorJL.setBounds(310, 320, authorJLIcon.getIconWidth(), authorJLIcon.getIconHeight());
		authorJL.setIcon(authorJLIcon);
		authorJL.setVisible(true);
		// ��ʼ�����ߵ�ֵ��ʾ��ǩ
		authorTextJL = new JLabel();
		authorTextJL.setBounds(430, 335, 200, 20);
		authorTextJL.setFont(textFont);
		authorTextJL.setVisible(true);
		// ��ʼ���ύ��ť��������Ӧ�¼�
		submitBt = new JButton("ɾ��ͼ��");
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
			    	PanelShowOrClose.showPanel(dialogPanel, submitBt, infoLabel, "��ɾ���鼮�������");
			    }else{
				int isDelete = JOptionPane.showConfirmDialog(null, "�Ƿ�ɾ��" + "�� " + bookName + "����", "ȷ��ɾ��",
						JOptionPane.YES_NO_OPTION);
				if (isDelete == 0 && bs.deleteBook(bookId)) {
					PanelShowOrClose.showPanel(dialogPanel, submitBt, infoLabel, "ɾ���� " + bookName + "�����ɹ���");
					// ������־���󲢽������¼����־����
					LogEntity log = new LogEntity("ɾ��ͼ�飺�� " + bookName + "��", new Date(new java.util.Date().getTime()),
							MessagerService.getMessagerId((String) request.getAttribute("username")));
					LogService.addLog(log);
				} else {
					PanelShowOrClose.showPanel(dialogPanel, submitBt, infoLabel, "ɾ���� " + bookName + "����ʧ�ܣ�");
				}
			 }
			}
		});
		submitBt.setVisible(true);
		// ��ʼ�����ð�ť������������Ӧ�¼�
		resetBt = new JButton("����");
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
		// ��ʼ���ײ�����ʽ����;
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
		 * ��ʼ���ύ��ť��������Ӧ�¼�
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
	 * ���ñ���ֵΪ��
	 */
	public void resetText() {
		bookNameTextJL.setText("");
		bookIdTextJL.setText("");
		authorTextJL.setText("");
	}
	/*
	 * �������ݿ������������鼮��Ϣ������ʾ
	 */
	public void setBookInfoText(ArrayList bookList) {
		if (bookList.size() == 0) {
			PanelShowOrClose.showPanel(dialogPanel, queryBt, infoLabel, "������Ϣ��û���ҵ���Ҫ��ѯ���鼮��");
			
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
			PanelShowOrClose.showPanel(dialogPanel, queryBt, infoLabel, "������Ϣ����ѯʧ�ܣ�");
			submitBt.setEnabled(false);
		}
	}
}
