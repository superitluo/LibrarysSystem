package com.liberarysystem.util;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ClosePanelRun implements Runnable {
public JPanel dialogPanel;
public JButton submit;
public  ClosePanelRun(JPanel dialogPanel ,JButton submit){
	this.dialogPanel=dialogPanel;
	this.submit=submit;
}
	@Override
	public void run() {
		int width =dialogPanel.getWidth();
		int height = dialogPanel.getHeight();
		
          try {
			for(int i=width;i>=0;i-=3){
				Thread.sleep(1);
				dialogPanel.setSize(i,height);
				System.out.println("ClosePanelRun"+i);
			}
			dialogPanel.setVisible(false);
			dialogPanel.setSize(width, height);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
          submit.setEnabled(true);
	}

}
