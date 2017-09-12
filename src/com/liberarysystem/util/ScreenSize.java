package com.liberarysystem.util;
/**
 * 获得设备的屏幕尺寸
 */
import java.awt.Dimension;
import java.awt.Toolkit;

public class ScreenSize {
private static int width;
private static int height;
//静态加载所需的屏幕大小数据
static{
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension screensize = tk.getScreenSize();
	width = (int) screensize.getWidth();
	height = (int) screensize.getHeight();
}
//供外部类获得屏幕宽度的函数接口
public static int getWidth(){
	return width;
}
//供外部类获得屏幕高度的函数接口
public static int getHeight(){
	return height;
}
}
