package com.liberarysystem.service;
/**
 * ��־�����࣬��ҵ�����������־�ı���
 */
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLType;
import java.sql.Types;

import com.liberarysystem.entity.LogEntity;
import com.liberarysystem.util.ConnectionFactory;

public class LogService {
	/**
	 * �������õ������־��Ϣ�ľ�̬����
	 * @param log
	 */
public static void addLog(LogEntity log){
	try {
		Connection connection = new ConnectionFactory().getConnection();
		String sql ="insert into liberarysystem.log(name,date,messagerId)  values(?,?,?)";
		PreparedStatement ps= connection.prepareStatement(sql);
		ps.setString(1, log.getName());
		ps.setDate(2,log.getDate());
		ps.setInt(3, log.getMessagerId());
		ps.executeUpdate();
	} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}
}
}
