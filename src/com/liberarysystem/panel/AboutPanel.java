package com.liberarysystem.panel;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.liberarysystem.util.ContentPanelTemplet;
import com.liberarysystem.util.MyRequest;
public class AboutPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel mainPanel;
	public AboutPanel(MyRequest request){
		mainPanel = new ContentPanelTemplet().init(this, "关于我们",request);
		mainPanel.setLayout(null);
		mainPanel.setBackground(Color.white);
		init();
		this.add(mainPanel);
		this.setVisible(true);
	}
    public void init(){
    	JLabel jl = new JLabel();
		jl.setBounds(0, 0, 947, 508);
		jl.setIcon(new ImageIcon("./resource/image/aboutImage.png"));
		jl.setBorder(null);
		jl.setVisible(true);
		mainPanel.add(jl);
		mainPanel.setVisible(true);
    }
}