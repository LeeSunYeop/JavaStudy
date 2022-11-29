package com.naver;
// Thread클래스 상속하는 Dog클래스
public class Dog extends Thread {  // Thread클래스
	
	public Dog() {
		// TODO Auto-generated constructor stub
	}
		
	@Override
	public void run() {
		// 사용자 스레드 중에서 Dog 클래스로 만들어진 
		// 사용자 스레드의 영역
		System.out.println("도그 사용자 스레드 실행");
		
		Thread ct = Thread.currentThread();
		String name = ct.getName();
		System.out.println(name); // Thread-0
	}

}
