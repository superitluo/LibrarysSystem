package com.liberarysystem.util;
/**
 * 对指定控件进行Icon大小自适应
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
	private static  Image temp;//临时的图片
	//共外界调用的图片自适应接口返回自适应的图片IIcon
public static ImageIcon ImageAutosize(String url ,Object obj){
	 ImageIcon ico = new ImageIcon(url); 
	 //对javax.swing.JButton对象的处理过程
	 if(obj.getClass().getTypeName().equals("javax.swing.JButton")){
		     jb =(JButton) obj;
            temp=ico.getImage().getScaledInstance(jb.getWidth(),jb.getHeight(),ico.getImage().SCALE_DEFAULT);
	 }
	 //对javax.swing.JFrame对象的处理
	 if(obj.getClass().getTypeName().equals("javax.swing.JFrame")){
	     jf=(JFrame) obj;
        temp=ico.getImage().getScaledInstance(jf.getWidth(),jf.getHeight(),ico.getImage().SCALE_DEFAULT);
     }
	 //对javax.swing.JLabel对象的处理
	 if(obj.getClass().getTypeName().equals("javax.swing.JLabel")){
	     jl=(JLabel) obj;
        temp=ico.getImage().getScaledInstance(jl.getWidth(),jl.getHeight(),ico.getImage().SCALE_DEFAULT);
     }
	 ico=new ImageIcon(temp);
	return ico;
}
}
