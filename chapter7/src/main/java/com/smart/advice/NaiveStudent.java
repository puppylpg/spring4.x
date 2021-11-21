package com.smart.advice;

public class NaiveStudent implements Student {

	public void examine(String name) {
		System.out.println("Start to examine for: " + name);
	}
	
	public void play(String name){
		System.out.println("Start to play: " + name);
	}
}
