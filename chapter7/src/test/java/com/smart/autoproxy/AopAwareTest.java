package com.smart.autoproxy;

import com.smart.advisor.NaiveStudent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

public class AopAwareTest {
	@Test
	public void autoProxy() {
		String configPath = "com/smart/autoproxy/beans-aware.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
		NaiveStudent naiveStudent = (NaiveStudent) ctx.getBean("naiveStudent");
		naiveStudent.play("halo");
		naiveStudent.examine("math");
	}
}
