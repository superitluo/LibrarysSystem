package com.liberarysystem.panel;

import java.awt.Color;

import javax.swing.JPanel;

import com.liberarysystem.util.ContentPanelTemplet;
import com.liberarysystem.util.MyRequest;

public class SearchReaderPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel mainPanel;
	private JPanel topPanel;
	public SearchReaderPanel(MyRequest request){
		mainPanel = new ContentPanelTemplet().init(this, "≤È—Ø∂¡’ﬂ",request);
		mainPanel.setLayout(null);
		mainPanel.setBackground(Color.white);
		init();
		this.add(mainPanel);
		this.setVisible(true);
	}
    public void init(){
    	topPanel = new JPanel();
		topPanel.setLayout(null);
		topPanel.setBounds(0, 90, 947, 50);
	 	topPanel.setBackground(Color.white);
		topPanel.setVisible(true);
		mainPanel.add(topPanel);
		this.add(mainPanel);
    }
}
