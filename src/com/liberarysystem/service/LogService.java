package com.liberarysystem.service;
/**
 * 日志服务类，对业务操作进行日志的保存
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
	 * 供外界调用的添加日志信息的静态方法
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
