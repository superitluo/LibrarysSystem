package Test;

import java.sql.Date;

import com.liberarysystem.entity.LogEntity;
import com.liberarysystem.service.LogService;

public class LogServiceTest {
public static void main(String[] args) {
	LogEntity log = new LogEntity("É¾³ý¶ÁÕß²Ù×÷" ,new Date(new java.util.Date().getTime()),1);
	LogService.addLog(log);
}
}
