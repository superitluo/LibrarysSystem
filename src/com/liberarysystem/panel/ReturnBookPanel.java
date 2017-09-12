package com.liberarysystem.panel;

import java.awt.Color;

import javax.swing.JPanel;

import com.liberarysystem.util.ContentPanelTemplet;
import com.liberarysystem.util.MyRequest;
public class ReturnBookPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel mainPanel;
	public ReturnBookPanel(MyRequest request){
		mainPanel = new ContentPanelTemplet().init(this, "办理还书",request);
		mainPanel.setLayout(null);
		mainPanel.setBackground(Color.white);
		init();
		this.add(mainPanel);
		this.setVisible(true);
	}
	public void init(){
		
	}
}