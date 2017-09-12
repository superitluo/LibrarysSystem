package Test;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import java.util.function.Consumer;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;

import com.liberarysystem.util.ScreenSize;

public class SwingStudent extends JFrame{
	private Container c;
	private int size=ScreenSize.getWidth()/20;
	public SwingStudent(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100,200,520,200);
        c = this.getContentPane();
        c.setLayout(null);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		init();
		this.setVisible(true);
	}
public void init(){
	JPanel jp1= new JPanel();
	jp1.setBounds(0, 0, size*5,548);
	jp1.setBackground(Color.white);
	jp1.setLayout(null);
	jp1.setBorder(BorderFactory.createBevelBorder(1,Color.blue,Color.white));
	jp1.setVisible(true);
	
	JPanel jp2= new JPanel();
	jp2.setBounds(0, 0, size*5,40);
	jp2.setBackground(Color.blue);
	jp2.setLayout(null);
	jp2.setVisible(true);
	
	JPanel jp3= new JPanel();
	jp3.setBounds(size*6, 125,size*13,548);
	jp3.setBackground(Color.white);
	jp3.setLayout(null);
	jp3.setVisible(true);
	jp1.add(jp2);
	c.add(jp3);
	c.add(jp1);
}
public static void main(String[] args) {
	new SwingStudent();
}
}
