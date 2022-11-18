package com.naver;

import net.daum.Cat;

public class Person {
	
	private int id;
	private String name;
	
	private Dog[] dog1;  //배열을 사용하여 dog100 마리 천마리를 만들수 있다
	
	private Cat cat1 = new Cat();
	
	public Person() {}
	
	

	public Person(int id, String name, Dog[] dog1) {
		super();
		this.id = id;
		this.name = name;
		this.dog1 = dog1;
	}



	public Person(int id, String name, Dog[] dog1, Cat cat1) {
		super();
		this.id = id;
		this.name = name;
		this.dog1 = dog1;
		this.cat1 = cat1;
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

	public Dog[] getDog1() {
		return dog1;
	}

	public void setDog1(Dog[] dog1) {
		this.dog1 = dog1;
	}

	public Cat getCat1() {
		return cat1;
	}

	public void setCat1(Cat cat1) {
		this.cat1 = cat1;
	}
		


}
