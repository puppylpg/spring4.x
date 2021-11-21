package com.smart.advisor;

import java.lang.reflect.Method;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;

public class PrepareAdvisor extends StaticMethodMatcherPointcutAdvisor {

	public boolean matches(Method method, Class clazz) {
		return "examine".equals(method.getName());
	}

	@Override
	public ClassFilter getClassFilter(){
		return new ClassFilter(){
			public boolean matches(Class clazz){
				return NaiveStudent.class.isAssignableFrom(clazz);
			}
		};
	}
}
