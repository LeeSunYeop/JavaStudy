package com.naver;

public abstract class Animal {
	
	private String id;
	private String name;
	private int age;
	
	public Animal() {
		// TODO Auto-generated constructor stub
	}

	public Animal(String id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void sleep() {
		// TODO Auto-generated method stub
		
	}
	
	

}
