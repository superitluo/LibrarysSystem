package com.liberarysystem.util;
/**
 * 自定义Connection工厂，让外界获得Connection对象
 * @author superitluo
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public Connection cn;
	public ConnectionFactory() {
	}
	/**
	 * 供外界获得 Connection对象的方法
	 * 
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Connection getConnection()
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		/* 加载Mysql ---jdbc驱动 */
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		/* 数据库的URL */
		String url = "jdbc:mysql://localhost/liberarysystem?user=root&password=sxylmj96851029.&useUnicode=true&characterEncoding=utf8";
		/* 数据库的角色名 */
		// String username ="1198138861";
		// /*数据库的角色名对应的登录密码*/
		// String password="sxylmj96851029.";
		/* 通过驱动管理类的静态方法获得连接对象 */
		cn = DriverManager.getConnection(url);
		return cn;
	}
}
