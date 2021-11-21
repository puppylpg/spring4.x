package com.smart.autoproxy;

import com.smart.advisor.NaiveStudent;
import com.smart.advisor.NaiveTeacher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.testng.annotations.*;
public class BeanNameAutoProxyCreatorTest {

	@Test
	public void autoProxy() {
		String configPath = "com/smart/autoproxy/beans.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
		NaiveStudent naiveStudent = (NaiveStudent) ctx.getBean("naiveStudent");
		NaiveTeacher naiveTeacher = (NaiveTeacher) ctx.getBean("naiveTeacher");
		naiveStudent.play("halo");
		naiveStudent.examine("math");
		naiveTeacher.examine("english");
	}
}
