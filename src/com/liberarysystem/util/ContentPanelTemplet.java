package com.liberarysystem.util;
/**
 * 内容面板模板
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.Paint;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

import com.liberarysystem.frame.MainFrame;

public class ContentPanelTemplet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Color color = new Color(102, 102, 102);
//	private static JPanel buttomPanel;
	public static MainFrame mainFrame;
	public ContentPanelTemplet() {
	}
	public JPanel init(JPanel jp, String title, MyRequest request){
		mainFrame = (MainFrame) request.getAttribute("MainFrame");
		int shadowSize = 10;// 阴影大小
		Color shadowcolor = new Color(102, 102, 102);// 阴影颜色;
		// Color bacgroundColor=new Color(102, 102, 102);
		jp.setSize(947 + 2 * shadowSize, 608 + 2 * shadowSize);
		// jp.setBorder(null);
		jp.setBackground(Color.white);
		jp.setLayout(null);
		/**
		 * 头部
		 */
		JPanel headerPanel = new JPanel();
		headerPanel.setBounds(shadowSize, shadowSize, 947, 100);
		headerPanel.setBackground(shadowcolor);
		headerPanel.setLayout(null);
		headerPanel.setVisible(true);
		JLabel headerLabel = new JLabel(title);
		headerLabel.setForeground(Color.WHITE);
		headerLabel.setFont(new Font("微软雅黑", Font.PLAIN, 48));
		headerLabel.setBounds(380, 30, 300, 50);
		headerLabel.setVisible(true);
		headerPanel.add(headerLabel);
		JLabel closeLabel = new JLabel();
		ImageIcon closeIcon = new ImageIcon("./resource/image/close.png");
		ImageIcon changecloseIcon = new ImageIcon("./resource/image/close2.png");
		closeLabel.setIcon(closeIcon);
		closeLabel.setBounds(900, 0, 47, 47);
		closeLabel.addMouseListener(new MouseListener(){
			@Override
			public void mouseReleased(MouseEvent e) {
				closeLabel.setIcon(closeIcon);
				// jp.setVisible(false);
				mainFrame.closePanel(title);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				closeLabel.setIcon(changecloseIcon);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				closeLabel.setIcon(closeIcon);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				closeLabel.setIcon(changecloseIcon);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		closeLabel.setVisible(true);
		headerPanel.add(closeLabel);
		
		/**
		 * 底部panel
		 */
		JPanel buttomPanel;buttomPanel = new JPanel();
		buttomPanel.setLayout(null);
		buttomPanel.setBounds(shadowSize, 100 + shadowSize, 947, 508);
		buttomPanel.setBackground(Color.white);
		buttomPanel.setVisible(true);
		
		jp.add(headerPanel);
		jp.add(buttomPanel);
		Border border = BorderFactory.createCompoundBorder(
				ShadowBorder.newBuilder().center().shadowSize(shadowSize).shadowColor(color).build(), null);
		jp.setOpaque(false);
		jp.setBorder(border);
		jp.setVisible(true);
		return buttomPanel;
	}
}