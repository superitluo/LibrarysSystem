package com.liberarysystem.util;
/**
 * ��ָ���ؼ�����Icon��С����Ӧ
 */
import java.awt.Image;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class ImageAutosize {
	private static JButton jb;
	private static JFrame jf;
	private static JLabel jl;
	private static  Image temp;//��ʱ��ͼƬ
	//�������õ�ͼƬ����Ӧ�ӿڷ�������Ӧ��ͼƬIIcon
public static ImageIcon ImageAutosize(String url ,Object obj){
	 ImageIcon ico = new ImageIcon(url); 
	 //��javax.swing.JButton����Ĵ������
	 if(obj.getClass().getTypeName().equals("javax.swing.JButton")){
		     jb =(JButton) obj;
            temp=ico.getImage().getScaledInstance(jb.getWidth(),jb.getHeight(),ico.getImage().SCALE_DEFAULT);
	 }
	 //��javax.swing.JFrame����Ĵ���
	 if(obj.getClass().getTypeName().equals("javax.swing.JFrame")){
	     jf=(JFrame) obj;
        temp=ico.getImage().getScaledInstance(jf.getWidth(),jf.getHeight(),ico.getImage().SCALE_DEFAULT);
     }
	 //��javax.swing.JLabel����Ĵ���
	 if(obj.getClass().getTypeName().equals("javax.swing.JLabel")){
	     jl=(JLabel) obj;
        temp=ico.getImage().getScaledInstance(jl.getWidth(),jl.getHeight(),ico.getImage().SCALE_DEFAULT);
     }
	 ico=new ImageIcon(temp);
	return ico;
}
}
