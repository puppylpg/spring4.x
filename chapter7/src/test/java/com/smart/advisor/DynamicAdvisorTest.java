package com.smart.advisor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.*;
public class DynamicAdvisorTest {

	@Test
	public void dynamic() {
		String configPath = "com/smart/advisor/beans.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
		NaiveStudent strengthenByDynamicStudent = (NaiveStudent) ctx.getBean("strengthenByDynamicStudent");

		System.out.println("==========");

		strengthenByDynamicStudent.examine("math");
		strengthenByDynamicStudent.play("halo");
		strengthenByDynamicStudent.examine("english");
		strengthenByDynamicStudent.play("minecraft");
	}
}
