package com.liberarysystem.entity;

import java.sql.Date;

public class LogEntity {
private String  name ;
private Date date;
private  int messagerId;
public LogEntity(){
}
public LogEntity( String name, Date date, int messagerId) {
	super();
	this.name = name;
	this.date = date;
	this.messagerId = messagerId;
}
public String getName() {
	return name;
}
public Date getDate() {
	return date;
}
public int getMessagerId() {
	return messagerId;
}
public void setName(String name) {
	this.name = name;
}
public void setDate(Date date) {
	this.date = date;
}
public void setMessagerId(int messagerId) {
	this.messagerId = messagerId;
}
}
