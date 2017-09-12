package com.liberarysystem.entity;
/**
 * 管理员实体类
 */
import java.sql.Date;

public class MessagerEntity {
	private int id;
	private String name;
	private String sex;
	private Date birthday;
	private int typeId;
	private String  telphone;
	private String email;
	private String username;
	private String password;
	
public MessagerEntity(){
}

public MessagerEntity(int id, String name, String sex, Date birthday, int typeId, String telphone, String email,
		String username, String password) {
	super();
	this.id = id;
	this.name = name;
	this.sex = sex;
	this.birthday = birthday;
	this.typeId = typeId;
	this.telphone = telphone;
	this.email = email;
	this.username = username;
	this.password = password;
}

public int getId() {
	return id;
}

public String getName() {
	return name;
}

public String getSex() {
	return sex;
}

public Date getBirthday() {
	return birthday;
}

public int getTypeId() {
	return typeId;
}

public String getTelphone() {
	return telphone;
}

public String getEmail() {
	return email;
}

public String getUsername() {
	return username;
}

public String getPassword() {
	return password;
}

public void setId(int id) {
	this.id = id;
}

public void setName(String name) {
	this.name = name;
}

public void setSex(String sex) {
	this.sex = sex;
}

public void setBirthday(Date birthday) {
	this.birthday = birthday;
}

public void setTypeId(int typeId) {
	this.typeId = typeId;
}

public void setTelphone(String telphone) {
	this.telphone = telphone;
}

public void setEmail(String email) {
	this.email = email;
}

public void setUsername(String username) {
	this.username = username;
}

public void setPassword(String password) {
	this.password = password;
}
}
