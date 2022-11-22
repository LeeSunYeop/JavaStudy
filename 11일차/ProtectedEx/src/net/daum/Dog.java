package net.daum;

import com.naver.Animal;

public class Dog extends Animal{
	
	private int test = 20;
	
	public Dog(int test) {
//		System.out.println(this.test);  // 20 나옴
//		System.out.println(super.test); // 부모클래스   10 남옴
//		this.test = test;  // 초기화 시킨다
//		
//		System.out.println(this.test);  // 5나옴
//		System.out.println(super.test);  // 10 나옴
	}

	public int getTest() {
		return test;
	}

	public void setTest(int test) {
		this.test = test;
	}
	
	public void tt1() {
		getTest();
		super.getTest();
	}
	
}

