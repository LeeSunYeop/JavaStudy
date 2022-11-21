package net.daum;

public class Dog extends Animal{
	
	public Dog() {
		super();  // super라는게 new Animal이라는 의미를 가지고 있다.
	}

	public Dog(String id, String name) {
		super(id, name);  // 부모클래스
		// TODO Auto-generated constructor stub
	
	
		sleep(); 
		
		eat();
	
	}	
	
	
}
