package net.daum;

public class Cat extends Animal{
	
	public Cat() {
		// TODO Auto-generated constructor stub
	}
	
	public Cat(String id, String name) {
		super(id, name);
			
	}

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("생선을 ");  // 추가
		super.eat();
	}
	
	

}
