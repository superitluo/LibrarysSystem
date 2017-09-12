package com.liberarysystem.util;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelShowOrClose {
	public static  void showPanel(JPanel panel,JButton submit,JLabel infoLabel,String infoText){
		ShowPanelRun show= new ShowPanelRun(panel,submit,infoLabel,infoText);
		Thread showPanelThread = new Thread(show);
		showPanelThread.start();
	}
}
