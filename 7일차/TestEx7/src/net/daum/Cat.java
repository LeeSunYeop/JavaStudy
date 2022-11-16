package net.daum;

import com.naver.Dog;

public class Cat {
	
	private String id;
	private String name;
	private Dog dog;
	
	public Cat() {		
	}
	
	public Cat(String id, String name, Dog dog) {
		super();
		this.id = id;
		this.name = name;
		this.dog = dog;
	}

	public void sleep() {
		if(id == null) {
			id = "m001";
		}else {
			System.out.println(id);
		}			
	}
	
	public void w1(int score) {
		// score가 60 이상이면, "합격"
		// 그렇지 않으면 "불합격" 출력
		if(score >= 60) {
			System.out.println("합격");
		}else {
			System.out.println("불합격");
		}
	}
	
	public void w2(int score) {   // 이렇게 코드짜는게 깔끔하다.
		
		String msg = null;
		
		if(score >= 60) {
			msg = "합격";
		}else {
			msg = "불합격";
		}
		
		System.out.println(msg);
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

	public Dog getDog() {
		return dog;
	}

	public void setDog(Dog dog) {
		this.dog = dog;
	}

}
