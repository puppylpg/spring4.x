package com.smart.advisor;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class PrepareBeforeAdvice implements MethodBeforeAdvice {

	public void before(Method method, Object[] args, Object obj) throws Throwable {
		String name = (String)args[0];
		System.out.println("[before]prepare for :" + name + " in: " + obj.getClass().getName()+"."+method.getName());
	}
}
