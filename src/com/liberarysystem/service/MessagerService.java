package com.liberarysystem.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.liberarysystem.entity.LogEntity;
import com.liberarysystem.util.ConnectionFactory;

public class MessagerService {
private static ConnectionFactory connectionFactory;
private static Connection connection;
public MessagerService(){
}
public static Boolean isExistUser(String username,String password){
	setConnection();
	String sql ="select * from liberarysystem.messager where username="+"'"+username+"'"+"&& password="+"'"+password+"'";
	PreparedStatement  ps;
	ResultSet rs;

	boolean flag=false;
	int id=0;
	try {
	  ps= connection.prepareStatement(sql);
	  rs= ps.executeQuery();
		while(rs.next()){
			id=rs.getInt("id");
		}
//	  rs.getInt("id");
//	  System.out.println(id);
//	  flag=rs.next();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	if(id!=0){
		LogEntity log = new LogEntity("µÇÂ¼²Ù×÷" ,new Date(new java.util.Date().getTime()),id);
		LogService.addLog(log);
		return true;
	}else{
		return false;
	}
}
public static int getMessagerId(String username){
	setConnection();
	String sql ="select id from liberarysystem.messager where username=?";
	PreparedStatement  ps;
	ResultSet rs;

	boolean flag=false;
	int id=0;
	try {
	  ps= connection.prepareStatement(sql);
	  ps.setString(1, username);
	  rs= ps.executeQuery();
		while(rs.next()){
			id=rs.getInt("id");
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return id;
}
public static void setConnection(){
	 connectionFactory=new ConnectionFactory();
	 try {
		connection=connectionFactory.getConnection();
	} catch (InstantiationException e) {
		e.printStackTrace();
	} catch (IllegalAccessException e) {
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) { 
		e.printStackTrace();
	}
}
}
