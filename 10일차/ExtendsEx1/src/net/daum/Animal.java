package net.daum;

public class Animal {
	
	private String id;
	private String name;
	
	public Animal() {
		// TODO Auto-generated constructor stub
	}
	
	public void sleep() {
		System.out.println("잡니다");
	}
	
	public void eat() {
		System.out.println("먹습니다");
	}
	
	

	public Animal(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
}
