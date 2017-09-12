package com.liberarysystem.panel;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import com.liberarysystem.util.ContentPanelTemplet;
import com.liberarysystem.util.MyRequest;
public class SystemIntroductionPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel mainPanel;
	public SystemIntroductionPanel(MyRequest request){
		mainPanel = new ContentPanelTemplet().init(this, "ÏµÍ³¼ò½é",request);
		mainPanel.setLayout(null);
		mainPanel.setBackground(Color.white);
		init();
		this.add(mainPanel);
		this.setVisible(true);
	}
    public void init(){
		JLabel jl = new JLabel();
		jl.setBounds(0, 0, 947, 508);
		jl.setIcon(new ImageIcon("./resource/image/SystemIntroduction.png"));
		jl.setBorder(null);
		jl.setVisible(true);
		mainPanel.add(jl);
		mainPanel.setVisible(true);
    }
}