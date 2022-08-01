package com.java8.features;

public class ThreadTest {

	public static void main(String[] args) {
		new Thread(() -> System.out.println("Hey i am thread")).start();
	}
}
