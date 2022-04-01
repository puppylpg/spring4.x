package com.smart;

import com.smart.anno.NeedTest;

public interface Student {
	@NeedTest
	public void examine(String name);
	public void play(String name);
}
