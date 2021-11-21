package com.smart.advice;

import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.testng.annotations.*;

public class BeforeAdviceTest {

    @Test
	public void before() {
        Student target = new NaiveStudent();
        BeforeAdvice  advice = new PrepareBeforeAdvice();
        ProxyFactory pf = new ProxyFactory();
        pf.setInterfaces(target.getClass().getInterfaces());
        pf.setOptimize(true);
        pf.setTarget(target);
        pf.addAdvice(advice);

        Student proxy = (Student)pf.getProxy();
        proxy.examine("John");
        proxy.play("Tom");
	}
}
