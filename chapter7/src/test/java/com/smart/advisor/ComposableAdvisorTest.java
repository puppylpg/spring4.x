package com.smart.advisor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.*;
public class ComposableAdvisorTest {

	@Test
	public void composable(){
		String configPath = "com/smart/advisor/beans.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
		NaiveStudent naiveStudent = (NaiveStudent) ctx.getBean("waiter4");
		WaiterDelegate wd = new WaiterDelegate();
        wd.setNaiveStudent(naiveStudent);
		naiveStudent.play("Peter");
		naiveStudent.examine("Peter");
		wd.service("Peter");
	}
}
