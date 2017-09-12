package com.liberarysystem.util;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ShowPanelRun implements Runnable {
public JPanel dialogPanel;
public JButton submit;
public JLabel infoLabel;
public String infoText;
public  ShowPanelRun (JPanel dialogPanel,JButton submit,JLabel infoLabel,String infoText){
	this.dialogPanel=dialogPanel;
	this.submit = submit;
	this.infoLabel=infoLabel;
	this.infoText= infoText;
}
	@Override
	public void run() {
		int width =dialogPanel.getWidth();
		int height = dialogPanel.getHeight();
		
		dialogPanel.setVisible(true);
          try {
			for(int i=0;i<=width;i+=3){
				Thread.sleep(1);
				dialogPanel.setSize(i,height);
			}
			for(int i=3;i>=0;i--){
				infoLabel.setText(infoText+"     Ê£ÓàÊ±¼ä:"+i);
				Thread.sleep(1000);
			}
			for(int i=width;i>=0;i-=3){
				Thread.sleep(1);
				dialogPanel.setSize(i,height);
			}
			dialogPanel.setVisible(false);
			dialogPanel.setSize(width, height);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
          submit.setEnabled(true);
	}

}