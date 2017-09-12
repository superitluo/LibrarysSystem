package com.liberarysystem.entity;
/**
 * ΩË‘ƒ µÃÂ¿‡
 */
import java.sql.Date;

public class BorrowEntity {
private int id ;
private int readerId;
private int bookId;
private Date borrowTime;
private int borrowMessagerId;
private Date returnTime;
private int returnMessagerId;
private int isReturn;
private int overTimeDate;
private int overTimeFei;
public BorrowEntity(){
}
public BorrowEntity(int id, int readerId, int bookId, Date borrowTime, int borrowMessagerId, Date returnTime,
		int returnMessagerId, int isReturn, int overTimeDate, int overTimeFei) {
	super();
	this.id = id;
	this.readerId = readerId;
	this.bookId = bookId;
	this.borrowTime = borrowTime;
	this.borrowMessagerId = borrowMessagerId;
	this.returnTime = returnTime;
	this.returnMessagerId = returnMessagerId;
	this.isReturn = isReturn;
	this.overTimeDate = overTimeDate;
	this.overTimeFei = overTimeFei;
}
public int getId() {
	return id;
}
public int getReaderId() {
	return readerId;
}
public int getBookId() {
	return bookId;
}
public Date getBorrowTime() {
	return borrowTime;
}
public int getBorrowMessagerId() {
	return borrowMessagerId;
}
public Date getReturnTime() {
	return returnTime;
}
public int getReturnMessagerId() {
	return returnMessagerId;
}
public int getIsReturn() {
	return isReturn;
}
public int getOverTimeDate() {
	return overTimeDate;
}
public int getOverTimeFei() {
	return overTimeFei;
}
public void setId(int id) {
	this.id = id;
}
public void setReaderId(int readerId) {
	this.readerId = readerId;
}
public void setBookId(int bookId) {
	this.bookId = bookId;
}
public void setBorrowTime(Date borrowTime) {
	this.borrowTime = borrowTime;
}
public void setBorrowMessagerId(int borrowMessagerId) {
	this.borrowMessagerId = borrowMessagerId;
}
public void setReturnTime(Date returnTime) {
	this.returnTime = returnTime;
}
public void setReturnMessagerId(int returnMessagerId) {
	this.returnMessagerId = returnMessagerId;
}
public void setIsReturn(int isReturn) {
	this.isReturn = isReturn;
}
public void setOverTimeDate(int overTimeDate) {
	this.overTimeDate = overTimeDate;
}
public void setOverTimeFei(int overTimeFei) {
	this.overTimeFei = overTimeFei;
}

}
