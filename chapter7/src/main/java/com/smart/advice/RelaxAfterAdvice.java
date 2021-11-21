package com.smart.advice;

import java.lang.reflect.Method;
import org.springframework.aop.AfterReturningAdvice;

public class RelaxAfterAdvice implements AfterReturningAdvice {

	public void afterReturning(Object returnObj, Method method, Object[] args, Object obj) throws Throwable {
		String name = (String) args[0];
		System.out.println("[after]relax for :" + name);
	}
}
