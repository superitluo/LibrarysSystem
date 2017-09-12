package Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.liberarysystem.entity.BookEntity;
import com.liberarysystem.entity.BookTypeEntity;
import com.liberarysystem.entity.PublishEntity;
import com.liberarysystem.service.BookService;

public class bookServiceTest {

	public static void main(String[] args) {
		BookService bs=new BookService();
//		bs.addBook("算法设计","理工", "清华大学出版社", "王秋芬", 10);
		//根据图书类型和出版社中文名字来获得数据库对应的ID号并输出
		if( bs.addBook("php自学","理工","清华大学出版社","张三",-1)){
			System.out.println("添加书籍成功！");
		}else{
			System.out.println("添加书籍失败！");
		}
		System.out.println(bs.isExistBook("算法设计与分析","清华大学出版社","王秋芬"));
	   
		int i=bs.getBookTypeId("理工");
		int j=bs.getPublishId("电子工业出版社");
		System.out.println("理工类的Id是："+i+'\n');
		System.out.println("电子工业出版社的Id是："+j);
	    //获得图书类型对象的list集合
		List bookTypeList =bs.getBookTypeList();
		if(!bookTypeList.isEmpty()){
		Iterator it = bookTypeList.iterator();
		System.out.println("类型Id"+"       "+"类型名");
		while(it.hasNext()){
			BookTypeEntity bte =(BookTypeEntity) it.next();
			System.out.println(bte.getId()+"       "+bte.getName());
		}
		}else{
			System.out.println("图书类型数据为空！");
		}
		List publishList=bs.getPublishList();
		if(!publishList.isEmpty()){
			Iterator it = publishList.iterator();
			System.out.println("Id"+"       "+"出版社");
			while(it.hasNext()){
				PublishEntity publish= (PublishEntity) it.next();
				System.out.println(publish.getId()+"      "+publish.getName());
			}
		}else{
			System.out.println("获取出版社信息失败");
		}
		
		
		
		ArrayList bookList=bs.getBooksById("20170609");
		Iterator bookIt=bookList.iterator();
		while(bookIt.hasNext()){
			BookEntity book = (BookEntity) bookIt.next();
			System.out.println(book.getId()+"  "+book.getName()+"  "+book.getAuthor()+"  "+book.getPublishId()+"   "+book.getTypeId()+"  "+
			book.getInTime()+"   "+book.getInsumNum()+"  "+book.getSumNum());
		}  
		
		ArrayList bookList2=bs.getBooksByName("疯狂java讲义（第3版）");
		Iterator bookIt2=bookList2.iterator();
		while(bookIt2.hasNext()){
			BookEntity book = (BookEntity) bookIt2.next();
			System.out.println(book.getId()+"  "+book.getName()+"  "+book.getAuthor()+"  "+book.getPublishId()+"   "+book.getTypeId()+"  "+
			book.getInTime()+"   "+book.getInsumNum()+"  "+book.getSumNum());
		}  

	}
}
