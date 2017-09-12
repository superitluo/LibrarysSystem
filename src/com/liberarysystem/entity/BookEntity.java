package com.liberarysystem.entity;
/**
 *图书实体类
 */
import java.sql.Date;

public class BookEntity {
private int id;
private String name ;
private String author;
private int publishId;
private int typeId;
private Date inTime;
private int sumNum;
private int insumNum;
public  BookEntity(){
}
public BookEntity(int id, String name, String author, int publishId, int typeId, Date inTime, int sumNum,
		int insumNum) {
	super();
	this.id = id;
	this.name = name;
	this.author = author;
	this.publishId = publishId;
	this.typeId = typeId;
	this.inTime = inTime;
	this.sumNum = sumNum;
	this.insumNum = insumNum;
}
public int getId() {
	return id;
}
public String getName() {
	return name;
}
public String getAuthor() {
	return author;
}
public int getPublishId() {
	return publishId;
}
public int getTypeId() {
	return typeId;
}
public Date getInTime() {
	return inTime;
}
public int getSumNum() {
	return sumNum;
}
public int getInsumNum() {
	return insumNum;
}
public void setId(int id) {
	this.id = id;
}
public void setName(String name) {
	this.name = name;
}
public void setAuthor(String author) {
	this.author = author;
}
public void setPublishId(int publishId) {
	this.publishId = publishId;
}
public void setTypeId(int typeId) {
	this.typeId = typeId;
}
public void setInTime(Date inTime) {
	this.inTime = inTime;
}
public void setSumNum(int sumNum) {
	this.sumNum = sumNum;
}
public void setInsumNum(int insumNum) {
	this.insumNum = insumNum;
}

}
