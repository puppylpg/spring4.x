package com.smart;

import com.smart.anno.NeedTest;

@Monitorable
public class NaiveStudent implements Student {
	public void examine(String name) {
		System.out.println("Start to examine as student for: " + name);
	}	
	@NeedTest
	public void play(String name){
		System.out.println("Start to play as student for: " + name);
	}
	public void smile(String clientName,int times){
		System.out.println("NaiveStudent:smile to  "+clientName+ times+"times...");
	}	
}
