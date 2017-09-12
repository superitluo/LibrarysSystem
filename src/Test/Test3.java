package Test;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import com.liberarysystem.util.MyRequest;
import com.liberarysystem.util.ScreenSize;

public class Test3 extends JFrame {
	public Test3	(){

	this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	this.setBounds(0, 0, ScreenSize.getWidth()/2, ScreenSize.getHeight()/2);
	ImageIcon icon = new ImageIcon("./resource/image/picture.png");
	this.setTitle("liberarysystem.1.0");
	Color color = new Color(255, 255, 255);
	this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	this.setIconImage(icon.getImage());
	this.setLayout(null);
	init();
	this.setVisible(true);
	}
	public void init(){
		MyRequest request = new MyRequest();
		request.setAttribute("TestFrame", this);
		MyJPanel panel = new MyJPanel(request);
		panel.setVisible(true);
		panel.setLocation(0,0);
		this.add(panel);
	}
	public static void main(String[] args) {
		Test3 test3= new Test3();
	}
}
