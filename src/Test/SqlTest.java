package Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.liberarysystem.util.ConnectionFactory;


public class SqlTest {
public SqlTest(){
	
}
public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
	
	ConnectionFactory cf= new ConnectionFactory();
	Connection con =cf.getConnection();
	System.out.println("连接成功");
     PreparedStatement ps= con.prepareStatement("select* from liberarysystem.book");
     ResultSet rs=ps.executeQuery();
     while(rs.next()){
    	 System.out.println(rs.getInt("id")+"|"+rs.getString("name"));
     }
}
}
