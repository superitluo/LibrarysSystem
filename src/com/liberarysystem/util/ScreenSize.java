package com.liberarysystem.util;
/**
 * ����豸����Ļ�ߴ�
 */
import java.awt.Dimension;
import java.awt.Toolkit;

public class ScreenSize {
private static int width;
private static int height;
//��̬�����������Ļ��С����
static{
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension screensize = tk.getScreenSize();
	width = (int) screensize.getWidth();
	height = (int) screensize.getHeight();
}
//���ⲿ������Ļ��ȵĺ����ӿ�
public static int getWidth(){
	return width;
}
//���ⲿ������Ļ�߶ȵĺ����ӿ�
public static int getHeight(){
	return height;
}
}
