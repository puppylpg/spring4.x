package com.smart.advice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.*;

public class AdviceTest {

	@Test
	public void advice() {
		String configPath = "com/smart/advice/beans.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);

		Student strengthen = (Student)ctx.getBean("strengthenStudent");
		strengthen.examine("math");
		strengthen.play("halo");
	}
}
