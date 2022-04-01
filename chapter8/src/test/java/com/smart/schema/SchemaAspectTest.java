package com.smart.schema;

import com.smart.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.smart.Seller;
import org.testng.annotations.Test;

public class SchemaAspectTest {


	@Test
	public void schema(){
		String configPath = "com/smart/schema/beans.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
		Student naiveStudent = (Student) ctx.getBean("naiveStudent");
		Student naughtyStudent = (Student) ctx.getBean("naughtyStudent");
		Seller seller = (Seller) ctx.getBean("seller");
//		naiveStudent.examine("John");
//		naughtyStudent.examine("Tom");
		
		//后置增强
//		((SmartSeller)seller).sell("Beer","John");
		
		//环境增强
//		naiveStudent.play("John");
		
		//抛出异常增强
//		((SmartSeller)seller).checkBill(1);
		
		//final增强
//		naiveStudent.examine("John");
		
		//引入增强
//		((Seller)naiveStudent).sell("Beer","John");
//		((NaiveStudent)naiveStudent).smile("John", 2);
		
		//advisor
		naiveStudent.examine("John");
		
	}
}
