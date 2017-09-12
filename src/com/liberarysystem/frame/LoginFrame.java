package com.liberarysystem.frame;

import java.awt.Color;

import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.image.ImageObserver;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.liberarysystem.entity.LogEntity;
import com.liberarysystem.service.LogService;
import com.liberarysystem.service.MessagerService;
import com.liberarysystem.util.ConnectionFactory;
import com.liberarysystem.util.ImageAutosize;
import com.liberarysystem.util.MyRequest;
import com.liberarysystem.util.ScreenSize;

public class LoginFrame extends JFrame {
	private int frameWidth = 500; // ���ڵĿ��
	private int frameHeight = 300;// ���ڵĸ߶�
	private Container container;// ��Ŵ�������������
	private JLabel titleLabel;// �����ǩ
	private JLabel usernameLabel;// �˻���ǩ
	private JLabel passwordLabel;// �����ǩ
	private JTextField usernameJT;// �˻������
	private JPasswordField passwordJT;// ���������
	private JButton loginButton;// ��¼��ť
	private JPanel warnPanel;// ��Ϣ��ʾ���
	private JLabel warnLabel;// ��ʾ��ǩ
	private JFrame jframe = this;
	public Connection connection;// ���ݿ����Ӷ���
    public MyRequest request;
	public LoginFrame() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds((ScreenSize.getWidth() - frameWidth) / 2, (ScreenSize.getHeight() - frameHeight) / 2, frameWidth,
				frameHeight);
		this.setResizable(false);
		ImageIcon icon = new ImageIcon("./resource/image/picture.png");
		this.setIconImage(icon.getImage());
		container = this.getContentPane();
		container.setBackground(Color.WHITE);
		container.setLayout(null);
		container.setVisible(true);
		init();
		this.setVisible(true);
	}

	// ��ʼ����������Ҫ�Ŀؼ�
	public void init() {
		// �����ǩ���ò���
		titleLabel = new JLabel("Liberary  System");
		titleLabel.setFont(new Font("΢���ź�", Font.BOLD, 30));
		titleLabel.setBounds(130, 25, 250, 50);
		titleLabel.setVisible(true);
		// �˻���ǩ���ò���
		usernameLabel = new JLabel();
		usernameLabel.setBounds(125, 110, 30, 30);
		usernameLabel.setIcon(ImageAutosize.ImageAutosize("./resource/image/usernameicon.png", usernameLabel));
		usernameLabel.setVisible(true);
		// �˻���������ò���
		usernameJT = new JTextField();
		usernameJT.setBounds(185, 110, 200, 30);
		usernameJT.setVisible(true);
		// ��ӽ��������
		usernameJT.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
			}

			@Override
			public void focusGained(FocusEvent e) {
				reWarnPanel();// ʧȥ����ͽ���Ϣ��ʾ��廹ԭ����ķ��
			}
		});
		// �����ǩ���ò���
		passwordLabel = new JLabel();
		passwordLabel.setBounds(125, 150, 30, 30);
		passwordLabel.setIcon(ImageAutosize.ImageAutosize("./resource/image/passwordicon.png", passwordLabel));
		passwordLabel.setVisible(true);
		// ������������ò���
		passwordJT = new JPasswordField();
		passwordJT.setBounds(185, 150, 200, 30);
		passwordJT.setEchoChar('��');
		passwordJT.setVisible(true);
		// ��ӽ��������
		passwordJT.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
			}

			@Override
			public void focusGained(FocusEvent e) {
				reWarnPanel(); // ʧȥ����ͽ���Ϣ��ʾ��廹ԭ����ķ��
			}
		});
		// ��¼��ť���ò���
		loginButton = new JButton("��       ¼");
		loginButton.setBounds(115, 190, 270, 50);
		loginButton.setFont(new Font("΢���ź�", Font.BOLD, 20));
		loginButton.setBackground(Color.black);
		loginButton.setForeground(Color.WHITE);
		loginButton.setBorder(null);
		// ����¼�������
		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String username = usernameJT.getText();// ����˻�������ֵ��ֵ��username
				String password = passwordJT.getText();// �������������ֵ��ֵ��password
				if (username.equals(null) || password.equals(null) || username.equals("") || password.equals("")) {
					changeWarnPanel("������˺Ų���Ϊ�գ�");
				}else{
					try {
						if (connection==null) {
							connection = new ConnectionFactory().getConnection();
							request = new MyRequest();
							request.setAttribute("connection", connection);
						}
					} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e2) {
						e2.printStackTrace();
					}
					if (connection==null) {
						changeWarnPanel("����ʧ�ܣ�������磡");
					} else {
							if (MessagerService.isExistUser(username, password)) {
								request.setAttribute("loginFrame", this);
								request.setAttribute("username", username);
								new MainFrame(request);
								jframe.setVisible(false);
								LogEntity log = new LogEntity("��¼����" ,new Date(new java.util.Date().getTime()),MessagerService.getMessagerId(username));
								LogService.addLog(log);
							} else {
								changeWarnPanel("������˺Ų�ƥ���������룡");
							}
						}
					}
				}
		});
		loginButton.setVisible(true);
		// ��Ϣ��ʾ��兢��������
		warnPanel = new JPanel();
		warnPanel.setLayout(null);
		warnPanel.setBounds(125, 72, 260, 30);
		warnPanel.setBackground(Color.white);
		warnPanel.setVisible(true);
		// ��Ϣ��ʾ��ǩ����������
		warnLabel = new JLabel();
		warnLabel.setBounds(20, 5, 500, 20);
		warnLabel.setVisible(true);
		warnPanel.add(warnLabel);
		// ���ؼ���ӵ�������
		container.add(titleLabel);
		container.add(usernameLabel);
		container.add(usernameJT);
		container.add(passwordLabel);
		container.add(passwordJT);
		container.add(loginButton);
		container.add(warnPanel);
	}

	// �����ַ���������ֵ�ı���Ϣ��ʾ���ķ��
	public void changeWarnPanel(String warn) {
		warnPanel.setBackground(Color.red);
		warnLabel.setForeground(Color.white);
		warnLabel.setText(warn);
	}

	// ����Ϣ��ʾ��廹ԭ����ķ��
	public void reWarnPanel() {
		warnPanel.setBackground(Color.white);
		warnLabel.setText("");
	}
}
