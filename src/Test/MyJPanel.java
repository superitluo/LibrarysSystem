package Test;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.liberarysystem.util.MyRequest;

public class MyJPanel extends JPanel{
	private JButton jb;
	private MyRequest request;
	public MyJPanel (MyRequest request ){
		this.request=request;
		this.setSize(600,100);
		this.setLayout(null);
		this.setBackground(Color.white);
		init();
		this.setVisible(true);
	}
public void init(){
	jb = new JButton("¸ü¸Ä±³¾°É«");
	jb.setBounds(10,5,100,30);
	jb.setBackground(Color.BLUE);
	jb.setBorder(null);
	jb.setVisible(true);
	jb.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Test3 jf =(Test3) request.getAttribute("TestFrame");
			System.out.println(jf.hashCode());
			jf.getContentPane().setBackground(Color.red);
			jf.repaint();
			jf.setVisible(true);
		}
	});
	this.add(jb);
}
}
