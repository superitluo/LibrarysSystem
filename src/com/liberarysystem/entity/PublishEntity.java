package com.liberarysystem.entity;
/**
 * 出版社实体类
 * @author Admin
 *
 */
public class PublishEntity {
private int id;//出版社id
private String name;//出版社名称

public PublishEntity() {
	super();
}
public PublishEntity(int id, String name) {
	super();
	this.id = id;
	this.name = name;
}
public int getId() {
	return id;
}
public String getName() {
	return name;
}
public void setId(int id) {
	this.id = id;
}
public void setName(String name) {
	this.name = name;
}

}
