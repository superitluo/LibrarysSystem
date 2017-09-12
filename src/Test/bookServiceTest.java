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
//		bs.addBook("�㷨���","��", "�廪��ѧ������", "�����", 10);
		//����ͼ�����ͺͳ���������������������ݿ��Ӧ��ID�Ų����
		if( bs.addBook("php��ѧ","��","�廪��ѧ������","����",-1)){
			System.out.println("����鼮�ɹ���");
		}else{
			System.out.println("����鼮ʧ�ܣ�");
		}
		System.out.println(bs.isExistBook("�㷨��������","�廪��ѧ������","�����"));
	   
		int i=bs.getBookTypeId("��");
		int j=bs.getPublishId("���ӹ�ҵ������");
		System.out.println("�����Id�ǣ�"+i+'\n');
		System.out.println("���ӹ�ҵ�������Id�ǣ�"+j);
	    //���ͼ�����Ͷ����list����
		List bookTypeList =bs.getBookTypeList();
		if(!bookTypeList.isEmpty()){
		Iterator it = bookTypeList.iterator();
		System.out.println("����Id"+"       "+"������");
		while(it.hasNext()){
			BookTypeEntity bte =(BookTypeEntity) it.next();
			System.out.println(bte.getId()+"       "+bte.getName());
		}
		}else{
			System.out.println("ͼ����������Ϊ�գ�");
		}
		List publishList=bs.getPublishList();
		if(!publishList.isEmpty()){
			Iterator it = publishList.iterator();
			System.out.println("Id"+"       "+"������");
			while(it.hasNext()){
				PublishEntity publish= (PublishEntity) it.next();
				System.out.println(publish.getId()+"      "+publish.getName());
			}
		}else{
			System.out.println("��ȡ��������Ϣʧ��");
		}
		
		
		
		ArrayList bookList=bs.getBooksById("20170609");
		Iterator bookIt=bookList.iterator();
		while(bookIt.hasNext()){
			BookEntity book = (BookEntity) bookIt.next();
			System.out.println(book.getId()+"  "+book.getName()+"  "+book.getAuthor()+"  "+book.getPublishId()+"   "+book.getTypeId()+"  "+
			book.getInTime()+"   "+book.getInsumNum()+"  "+book.getSumNum());
		}  
		
		ArrayList bookList2=bs.getBooksByName("���java���壨��3�棩");
		Iterator bookIt2=bookList2.iterator();
		while(bookIt2.hasNext()){
			BookEntity book = (BookEntity) bookIt2.next();
			System.out.println(book.getId()+"  "+book.getName()+"  "+book.getAuthor()+"  "+book.getPublishId()+"   "+book.getTypeId()+"  "+
			book.getInTime()+"   "+book.getInsumNum()+"  "+book.getSumNum());
		}  

	}
}
