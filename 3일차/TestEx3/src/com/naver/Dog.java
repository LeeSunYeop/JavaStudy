package com.naver;

public class Dog {
	
	private int id;
	private String name;
	
	public void sleep() {
		System.out.println("잔다");
	}
	
	// 무반환 무파람
	// run
	//sysout("뛴다");
	public void run() {
		System.out.println("뛴다");
	}
	
	// 무반환 무파람,  eat,  sysout("먹는다");
	public void eat() {
		System.out.println("먹는다");
	}
	
	public void study() {
		System.out.println("공부한다");
	}

}
