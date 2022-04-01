package com.smart.aspectj.basic;

import com.smart.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.smart.Seller;
import org.testng.annotations.*;


public class DeclaredParentsTest {


	@Test
	public void parent() {
		String configPath = "com/smart/aspectj/basic/beans.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
		Student student = (Student)ctx.getBean("student");
		student.examine("John");
		Seller seller = (Seller) student;
		seller.sell("Beer", "John");
	}
}
