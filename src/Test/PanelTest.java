package Test;

import java.awt.Container;

import javax.swing.JFrame;

import com.liberarysystem.panel.RemoveBookPanel;
import com.liberarysystem.panel.SearchBookPanel;
import com.liberarysystem.util.MyRequest;

public class PanelTest extends JFrame{
public PanelTest(){
	Container c=this.getContentPane();
	this.setSize(1000,800);
	this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
	RemoveBookPanel rp= new RemoveBookPanel(new MyRequest());
	rp.setVisible(true);
	c.add(rp);
	this.setVisible(true);
}
public static void main(String[] args) {
	new PanelTest();
}
}
