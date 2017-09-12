package com.liberarysystem.entity;

import java.sql.Date;

/**
 * 读者实体类
 */
public class ReaderEntity {
private  int id;
private String name;
private String sex;
private Date birthday ;
private int typeid;
private String telphone;
private String email;
private Date createdate;
private  int messagerId;
public ReaderEntity(){
}
public ReaderEntity(int id, String name, String sex, Date birthday, int typeid, String telphone, String email,
		Date createdate, int messagerId) {
	super();
	this.id = id;
	this.name = name;
	this.sex = sex;
	this.birthday = birthday;
	this.typeid = typeid;
	this.telphone = telphone;
	this.email = email;
	this.createdate = createdate;
	this.messagerId = messagerId;
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
public int getTypeid() {
	return typeid;
}
public String getTelphone() {
	return telphone;
}
public String getEmail() {
	return email;
}
public Date getCreatedate() {
	return createdate;
}
public int getMessagerId() {
	return messagerId;
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
public void setTypeid(int typeid) {
	this.typeid = typeid;
}
public void setTelphone(String telphone) {
	this.telphone = telphone;
}
public void setEmail(String email) {
	this.email = email;
}
public void setCreatedate(Date createdate) {
	this.createdate = createdate;
}
public void setMessagerId(int messagerId) {
	this.messagerId = messagerId;
}

}
