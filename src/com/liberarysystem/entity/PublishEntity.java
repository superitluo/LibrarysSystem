package com.liberarysystem.entity;
/**
 * ������ʵ����
 * @author Admin
 *
 */
public class PublishEntity {
private int id;//������id
private String name;//����������

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
