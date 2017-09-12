package com.liberarysystem.panel;

import java.awt.Color;

import javax.swing.JPanel;

import com.liberarysystem.util.ContentPanelTemplet;
import com.liberarysystem.util.MyRequest;

public class SearchBorrowInfoPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel mainPanel;
	public SearchBorrowInfoPanel(MyRequest request){
		mainPanel = new ContentPanelTemplet().init(this, "≤È—ØΩË‘ƒ",request);
		mainPanel.setLayout(null);
		mainPanel.setBackground(Color.white);
		init();
		this.add(mainPanel);
		this.setVisible(true);
	}
	public void init(){
		
	}
}