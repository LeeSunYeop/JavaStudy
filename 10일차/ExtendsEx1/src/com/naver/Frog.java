package com.naver;

public class Frog {
	
	private String id;
	private String name;
	
	public Frog() {
		// TODO Auto-generated constructor stub
	}

	public Frog(String id, String name) {
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
