package com.naver;

public class Cat {
	
	private String id;
	private String name;
	
	public Cat() {
		// TODO Auto-generated constructor stub
	}

	public Cat(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public void sleep() {
		System.out.println("잡니다");
	}
	
	public void eat() {
		System.out.println("먹습니다");
	}
	
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
