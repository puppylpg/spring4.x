package com.smart.advisor;


import com.smart.aop.BeanSelfProxyAware;

public class NaiveStudent implements BeanSelfProxyAware {
	private NaiveStudent naiveStudent;

	public void setSelfProxy(Object object) {
		naiveStudent = (NaiveStudent)object;
	}

	public void play(String name){
		System.out.println("Start to play for: " + name);
		//naiveStudent.examine(name);
	}

	public void examine(String name) {
		System.out.println("Start to examine for: " + name);
	}
}
