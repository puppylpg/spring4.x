package com.smart.advisor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.*;
public class RegexpAdvisorTest {

	@Test
	public void regexp(){
		String configPath = "com/smart/advisor/beans.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
		NaiveStudent naiveStudent = (NaiveStudent)ctx.getBean("strengthenByRegexStudent");
		naiveStudent.examine("math");
		naiveStudent.play("halo");
	}
}
