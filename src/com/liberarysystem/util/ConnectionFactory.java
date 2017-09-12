package com.liberarysystem.util;
/**
 * �Զ���Connection�������������Connection����
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
	 * ������� Connection����ķ���
	 * 
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Connection getConnection()
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		/* ����Mysql ---jdbc���� */
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		/* ���ݿ��URL */
		String url = "jdbc:mysql://localhost/liberarysystem?user=root&password=sxylmj96851029.&useUnicode=true&characterEncoding=utf8";
		/* ���ݿ�Ľ�ɫ�� */
		// String username ="1198138861";
		// /*���ݿ�Ľ�ɫ����Ӧ�ĵ�¼����*/
		// String password="sxylmj96851029.";
		/* ͨ������������ľ�̬����������Ӷ��� */
		cn = DriverManager.getConnection(url);
		return cn;
	}
}
