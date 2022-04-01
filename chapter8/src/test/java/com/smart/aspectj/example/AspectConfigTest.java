package com.smart.aspectj.example;

import com.smart.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.*;


public class AspectConfigTest {

	@Test
	public void config(){
		String configPath = "com/smart/aspectj/example/beans.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
		Student student = (Student)ctx.getBean("student");
		student.examine("John");
		student.play("John");
		student.toString();
	}
}
