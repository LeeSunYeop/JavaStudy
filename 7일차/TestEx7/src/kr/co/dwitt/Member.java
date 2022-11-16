package kr.co.dwitt;

import com.naver.Dog;

import net.daum.Cat;

public class Member {
	
	private Dog dog1;
	private Dog dog2;
	
	private Cat cat1;
	
	private int id;
	private int name;
	
	public Member() {		
	}
	
	public Member(Dog dog1, Dog dog2, Cat cat1, int id, int name) {
		super();
		this.dog1 = dog1;
		this.dog2 = dog2;
		this.cat1 = cat1;
		this.id = id;
		this.name = name;
	}

	public void f1() {
		if(id > 10) {
			System.out.println("id가 10보다 큼");
		}else  if(id < 10) {
			System.out.println("id가 10보다 작음");
		}else {
			System.out.println("id가 10입니다");
		}
	}
	
	public void f2(int month) {
		// month가 1, 3, 5, 7, 8, 10, 12일 때는 31 출력
		// month가 2, 4, 6, 9, 11일 때는 30 출력
		// month가 2이면 28 출력..
		if(month == 1 || month == 3 || month == 5 || month == 7 || 
				month == 8 || month == 10 || month == 12) {
			System.out.println("31");
		}else if(month == 2 || month == 4 || month == 6 || month == 9 || month == 11) {
			System.out.println("30");
		}else {
			System.out.println("28");
		}
	}

	public Dog getDog1() {
		return dog1;
	}
	public void setDog1(Dog dog1) {
		this.dog1 = dog1;
	}
	public Dog getDog2() {
		return dog2;
	}
	public void setDog2(Dog dog2) {
		this.dog2 = dog2;
	}
	public Cat getCat1() {
		return cat1;
	}
	public void setCat1(Cat cat1) {
		this.cat1 = cat1;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getName() {
		return name;
	}
	public void setName(int name) {
		this.name = name;
	}
	
}
