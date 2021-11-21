package com.smart.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class PrepareRelaxAroundInterceptor implements MethodInterceptor {

	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object[] args = invocation.getArguments();
		String name = (String)args[0];
		System.out.println("[around]prepare for: " + name);
		
		Object obj = invocation.proceed();

		System.out.println("[around]relax for: " + name);
		return obj;
	}
}
