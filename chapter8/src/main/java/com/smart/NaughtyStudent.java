package com.smart;

public class NaughtyStudent implements Student {
	public void examine(String name) {
		System.out.println("NaughtyStudent: examine: " + name);
	}	
	public void play(String name){
		System.out.println("NaughtyStudent: play: "+ name);
	}
	public void joke(String name, int times){
        	System.out.println("NaughtyStudent: behave "+ times +" jokes to "+ name +"...");
	}
}
