package com.naver;

public class Dog extends Animal{

	@Override          // @Override 이 표시가 없어도 오버라이딩했다고 알고 있으면 된다.
	public void test1() {
		System.out.println("잡니다");
		
	}

	@Override
	public void test2() {
		System.out.println("먹습니다.");
		
	}

	@Override
	public void test3() {
		System.out.println("일합니다");
		
	}

	@Override
	public void test4() {
		System.out.println("뜁니다.");
		
	}

	@Override
	public void test5() {
		System.out.println("재롱부립니다.");
		
	}
	
}
