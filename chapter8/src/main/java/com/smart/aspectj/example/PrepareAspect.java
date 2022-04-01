package com.smart.aspectj.example;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
@Aspect
public class PrepareAspect {
	@Before("execution(* examine(..))")
	public void prepare(){
		System.out.println("[before]prepare for : ... for what???");
	}
}
