package com.smart.advisor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

public class StaticMethodAdvisorTest {

	@Test
	public void staticMethod(){
		String configPath = "com/smart/advisor/beans.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
		NaiveStudent strengthenStudent = (NaiveStudent)ctx.getBean("strengthenStudent");
		NaiveTeacher strengthenTeacher = (NaiveTeacher)ctx.getBean("strengthenTeacher");
		strengthenStudent.examine("math");
		strengthenStudent.play("halo");
		strengthenTeacher.examine("math");
	}
}
