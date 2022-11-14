package net.daum;

public class Cat {
	private int id;
	
	public Cat() { // 디폴트 생성자
		id = 0;		
	}
	
	public Cat(int a) { // 사용자 생성자
		id = a;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
