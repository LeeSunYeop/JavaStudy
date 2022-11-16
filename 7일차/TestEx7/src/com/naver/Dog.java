package com.naver;

public class Dog {
	
	private int id;
	private String name;
	
	public Dog() {		
	}
		
	public Dog(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int t1(boolean a) {
		if(a) {// a == true와 같은 의미
			return 100;  // a가 true면 100을 반환
		}
		
		System.out.println("hello");
		
		return -1;  // a가 true가 아니면 -1을 반환
	}
	
	public void t2(int a) {
		if(a % 5 == 0) {
			System.out.println(a);
		}
		
		System.out.println("t2()메서드 호출");
	}
	
	public void t3() {
		if(true) {
			System.out.println(1);
			int a = 3;
			int b = 4;
			int temp = a;
			a = b;
			b = temp;
		}
	}
		
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
