package com.smart.aspectj.example;

import com.smart.NaiveStudent;
import com.smart.Student;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

import org.testng.annotations.Test;

public class AspectJProxyTest {


	@Test
	public void proxy(){
		Student target = new NaiveStudent();
		AspectJProxyFactory factory = new AspectJProxyFactory();
		factory.setTarget(target);
		factory.addAspect(PrepareAspect.class);
		Student proxy = factory.getProxy();
		proxy.examine("math");
		proxy.play("halo");
	}
}
