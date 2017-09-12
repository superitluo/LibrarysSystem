package com.liberarysystem.service;

/*
 * 图书实体类的数据处理类
 * （1）添加图书对象到数据库
 * （2）获的给出字符串的书类名字对应的ID
 * （3）获的给出字符串的出版社名字对应的ID
 * （4）获得所有图书类的list集合
 * （5）获得所有出版社的list集合
 */
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.liberarysystem.entity.BookEntity;
import com.liberarysystem.entity.BookTypeEntity;
import com.liberarysystem.entity.LogEntity;
import com.liberarysystem.entity.PublishEntity;
import com.liberarysystem.util.ConnectionFactory;

public class BookService {
	public Connection connection;

	public BookService() {
		try {
			connection = (Connection) new ConnectionFactory().getConnection();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 添加图书对象到数据库
	 * 
	 * @param bookName
	 * @param bookType
	 * @param publisher
	 * @param auther
	 * @param bookSum
	 * @return
	 */
	public boolean addBook(String bookName, String bookType, String publisher, String auther, int bookSum) {
		int bookTypeId = getBookTypeId(bookType);
		int publishId = getPublishId(publisher);
		if (bookTypeId == 0 || publishId == 0 || bookName.equals(null) || bookName.equals("") || auther.equals(null)
				|| auther.equals("") || bookSum == 0 || bookSum < 0 || bookSum > 1000) {
			return false;
		} else {
			int isSuccess = 0;
			try {
				PreparedStatement ps = connection.prepareStatement("insert into "
						+ "book(name,author,publishId,typeId,inTime,sumNum,inSumNum)" + "values(?,?,?,?,?,?,?)");
				ps.setString(1, bookName);
				ps.setString(2, auther);
				ps.setInt(3, publishId);
				ps.setInt(4, bookTypeId);
				ps.setDate(5, new Date(new java.util.Date().getTime()));
				ps.setInt(6, bookSum);
				ps.setInt(7, bookSum);
				ps.executeUpdate();
				isSuccess = 1;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (isSuccess == 0) {
				return false;
			} else {
				return true;
			}
		}
	}

	/**
	 * 获的给出字符串的书类名字对应的ID
	 * 
	 * @param bookTypeName
	 * @return 书类型的id
	 */
	public int getBookTypeId(String bookTypeName) {
		int id = 0;
		try {
			PreparedStatement pre = connection
					.prepareStatement("select id from liberarysystem.booktype where name='" + bookTypeName + "'");
			ResultSet rs = pre.executeQuery();
			if (rs.next()) {
				id = rs.getInt("Id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
		return id;
	}

	/**
	 * 获的给出字符串的出版社名字对应的ID
	 * 
	 * @param publishName
	 * @return 出版社的id
	 */
	public int getPublishId(String publishName) {
		int id = 0;
		try {
			PreparedStatement pre = connection
					.prepareStatement("select id from liberarysystem.publish where name='" + publishName + "'");
			ResultSet rs = pre.executeQuery();
			if (rs.next()) {
				id = rs.getInt("Id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
		return id;
	}

	/**
	 * 获得所有图书类的list集合
	 * 
	 * @return
	 */
	public ArrayList getBookTypeList() {
		ArrayList<BookTypeEntity> bookTypeList = new ArrayList<BookTypeEntity>();
		try {
			PreparedStatement pre = connection.prepareStatement("select * from liberarysystem.booktype");
			ResultSet rs = pre.executeQuery();
			while (rs.next()) {
				String name = rs.getString("name");
				int id = rs.getInt("id");
				BookTypeEntity bte = new BookTypeEntity();
				bte.setId(id);
				bte.setName(name);
				bookTypeList.add(bte);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return bookTypeList;
	}

	/**
	 * 获得所有出版社的list集合
	 * 
	 * @return
	 */
	public ArrayList getPublishList() {
		ArrayList<PublishEntity> publishList = new ArrayList<PublishEntity>();
		try {
			PreparedStatement pre = connection.prepareStatement("select * from liberarysystem.publish");
			ResultSet rs = pre.executeQuery();
			while (rs.next()) {
				String name = rs.getString("name");
				int id = rs.getInt("id");
				PublishEntity publish = new PublishEntity();
				publish.setId(id);
				publish.setName(name);
				publishList.add(publish);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return publishList;
	}

	public boolean isExistBook(String bookName, String publisher, String auther) {
		boolean flag =true;
		int id = 0;
		try {
			PreparedStatement ps = connection
					.prepareStatement("select * from liberarysystem.book where " + "name=?&& publishId=?&&author=?");
			ps.setString(1, bookName);
			ps.setInt(2, getPublishId(publisher));
			ps.setString(3, auther);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				id = rs.getInt("id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("id="+id);
		if (id != 0) {
			return true;
		} else {
			return false;
		}
	}
	/**
	 * 通过图书Id获得图书的相关信息
	 * @param id
	 * @return
	 */
	public  ArrayList getBooksById(String id){
		ArrayList<BookEntity> bookList = new ArrayList<BookEntity>();
		int bookId=Integer.valueOf(id);
		try {
			PreparedStatement pre = connection.prepareStatement("select * from liberarysystem.book where id=?");
			pre.setInt(1, bookId);
			ResultSet rs = pre.executeQuery();
			while (rs.next()) {
				BookEntity book= new BookEntity();
				book.setId(bookId);
				book.setName(rs.getString("name"));
				book.setAuthor(rs.getString("author"));
				book.setPublishId(rs.getInt("publishId"));
				book.setTypeId(rs.getInt("typeId"));
				book.setInTime(rs.getDate("inTime"));
				book.setSumNum(rs.getInt("sumNum"));
				book.setInsumNum(rs.getInt("inSumNum"));
				bookList.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return bookList;
	}
	
	/**
	 * 通过图书名称获得图书的相关信息
	 */
	public  ArrayList<BookEntity> getBooksByName(String name){
		ArrayList<BookEntity> bookList = new ArrayList<BookEntity>();
		try {
			PreparedStatement pre = connection.prepareStatement("select * from liberarysystem.book where name=?");
			pre.setString(1,name);
			ResultSet rs = pre.executeQuery();
			while (rs.next()) {
				BookEntity book= new BookEntity();
				book.setId(rs.getInt("id"));
				book.setName(rs.getString("name"));
				book.setAuthor(rs.getString("author"));
				book.setPublishId(rs.getInt("publishId"));
				book.setTypeId(rs.getInt("typeId"));
				book.setInTime(rs.getDate("inTime"));
				book.setSumNum(rs.getInt("sumNum"));
				book.setInsumNum(rs.getInt("inSumNum"));
				bookList.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return bookList;
	}
	
	public boolean deleteBook(String id){
		try {
			int bookid=Integer.valueOf(id);
			PreparedStatement pre = connection.prepareStatement("delete from liberarysystem.book where id=?");
			pre.setInt(1, bookid);
			pre.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
