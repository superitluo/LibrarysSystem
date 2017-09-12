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
	private int frameWidth = 500; // 窗口的宽度
	private int frameHeight = 300;// 窗口的高度
	private Container container;// 存放窗口主面板的容器
	private JLabel titleLabel;// 标题标签
	private JLabel usernameLabel;// 账户标签
	private JLabel passwordLabel;// 密码标签
	private JTextField usernameJT;// 账户输入框；
	private JPasswordField passwordJT;// 密码输入框
	private JButton loginButton;// 登录按钮
	private JPanel warnPanel;// 消息提示面板
	private JLabel warnLabel;// 提示标签
	private JFrame jframe = this;
	public Connection connection;// 数据库连接对象
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

	// 初始化界面所需要的控件
	public void init() {
		// 标题标签配置参数
		titleLabel = new JLabel("Liberary  System");
		titleLabel.setFont(new Font("微软雅黑", Font.BOLD, 30));
		titleLabel.setBounds(130, 25, 250, 50);
		titleLabel.setVisible(true);
		// 账户标签配置参数
		usernameLabel = new JLabel();
		usernameLabel.setBounds(125, 110, 30, 30);
		usernameLabel.setIcon(ImageAutosize.ImageAutosize("./resource/image/usernameicon.png", usernameLabel));
		usernameLabel.setVisible(true);
		// 账户输入框配置参数
		usernameJT = new JTextField();
		usernameJT.setBounds(185, 110, 200, 30);
		usernameJT.setVisible(true);
		// 添加焦点监听器
		usernameJT.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
			}

			@Override
			public void focusGained(FocusEvent e) {
				reWarnPanel();// 失去焦点就将消息提示面板还原最初的风格
			}
		});
		// 密码标签配置参数
		passwordLabel = new JLabel();
		passwordLabel.setBounds(125, 150, 30, 30);
		passwordLabel.setIcon(ImageAutosize.ImageAutosize("./resource/image/passwordicon.png", passwordLabel));
		passwordLabel.setVisible(true);
		// 密码输入框配置参数
		passwordJT = new JPasswordField();
		passwordJT.setBounds(185, 150, 200, 30);
		passwordJT.setEchoChar('●');
		passwordJT.setVisible(true);
		// 添加焦点监听器
		passwordJT.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
			}

			@Override
			public void focusGained(FocusEvent e) {
				reWarnPanel(); // 失去焦点就将消息提示面板还原最初的风格
			}
		});
		// 登录按钮配置参数
		loginButton = new JButton("登       录");
		loginButton.setBounds(115, 190, 270, 50);
		loginButton.setFont(new Font("微软雅黑", Font.BOLD, 20));
		loginButton.setBackground(Color.black);
		loginButton.setForeground(Color.WHITE);
		loginButton.setBorder(null);
		// 添加事件监听器
		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String username = usernameJT.getText();// 获得账户输入框的值赋值给username
				String password = passwordJT.getText();// 获得密码输入框的值赋值给password
				if (username.equals(null) || password.equals(null) || username.equals("") || password.equals("")) {
					changeWarnPanel("密码和账号不能为空！");
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
						changeWarnPanel("连接失败！检查网络！");
					} else {
							if (MessagerService.isExistUser(username, password)) {
								request.setAttribute("loginFrame", this);
								request.setAttribute("username", username);
								new MainFrame(request);
								jframe.setVisible(false);
								LogEntity log = new LogEntity("登录操作" ,new Date(new java.util.Date().getTime()),MessagerService.getMessagerId(username));
								LogService.addLog(log);
							} else {
								changeWarnPanel("密码和账号不匹配重新输入！");
							}
						}
					}
				}
		});
		loginButton.setVisible(true);
		// 消息提示面板參數的配置
		warnPanel = new JPanel();
		warnPanel.setLayout(null);
		warnPanel.setBounds(125, 72, 260, 30);
		warnPanel.setBackground(Color.white);
		warnPanel.setVisible(true);
		// 消息提示标签参数的配置
		warnLabel = new JLabel();
		warnLabel.setBounds(20, 5, 500, 20);
		warnLabel.setVisible(true);
		warnPanel.add(warnLabel);
		// 将控件添加到容器中
		container.add(titleLabel);
		container.add(usernameLabel);
		container.add(usernameJT);
		container.add(passwordLabel);
		container.add(passwordJT);
		container.add(loginButton);
		container.add(warnPanel);
	}

	// 根据字符串参数的值改变消息提示面板的风格
	public void changeWarnPanel(String warn) {
		warnPanel.setBackground(Color.red);
		warnLabel.setForeground(Color.white);
		warnLabel.setText(warn);
	}

	// 将消息提示面板还原最初的风格
	public void reWarnPanel() {
		warnPanel.setBackground(Color.white);
		warnLabel.setText("");
	}
}
