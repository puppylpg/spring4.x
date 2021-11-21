package com.smart.advisor;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;

public class PrepareDynamicPointcut extends DynamicMethodMatcherPointcut {
	private static List<String> toPrepare = new ArrayList<String>();

	static {
		toPrepare.add("math");
		toPrepare.add("physics");
	}

	@Override
	public ClassFilter getClassFilter() {
		return new ClassFilter() {
			public boolean matches(Class clazz) {
				boolean result = NaiveStudent.class.isAssignableFrom(clazz);
				System.out.println("STATIC check - prepare or not for class: " + clazz.getName());
				System.out.println("result is: " + result);
				return result;
			}
		};
	}

	@Override
	public boolean matches(Method method, Class clazz) {
		boolean result = "examine".equals(method.getName());
		System.out.println("STATIC check - prepare or not for method: " + clazz.getName() + "." + method.getName());
		System.out.println("result is: " + result);
		return result;
	}

	public boolean matches(Method method, Class clazz, Object[] args) {
		String name = (String) args[0];
		boolean result = toPrepare.contains(name);
		System.out.println("DYNAMIC check - prepare or not for: " + name + " in: " + clazz.getName() + "." + method.getName());
		System.out.println("result is: " + result);
		return result;
	}
}
