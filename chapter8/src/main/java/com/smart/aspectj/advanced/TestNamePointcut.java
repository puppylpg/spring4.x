package com.smart.aspectj.advanced;

import org.aspectj.lang.annotation.Pointcut;

public class TestNamePointcut {
	@Pointcut("within(com.smart.*)")
	private void inPackage(){}

	@Pointcut("execution(* examine(..)))")
    protected void examine(){}

    @Pointcut("inPackage() and examine()")
    public void inPkgGreetTo(){}
}
