package net.daum;

public class Frog extends Animal{
	private int age;
	
	public Frog() {	}

	public Frog(String id, String name) {
		super(id, name);		
	}

	public Frog(int age) {
		// super(); 눈에 보이지는 않지만 생략되어 있다. 
		this.age = age;		
	}

	public Frog(String id, String name, int age) {
		super(id, name);
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public void eat() {
		int a = 10;  // 수정
	}

}
