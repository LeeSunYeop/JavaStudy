package com.naver;

public class Dog {
	
	public void h1() {
		System.out.println("h1()메서드 입니다.");
	}
	
	public void h1(int a) {
		System.out.println("h1()메서드 입니다.");
	}
	
	public void h1(long b) {
		System.out.println("h1()메서드 입니다.");
	}
	
	public void h1(int a, String b) {
		System.out.println("h1()메서드 입니다.");
	}
	
	public void h1(String a, int b) {
		System.out.println("h1()메서드 입니다.");
	}
	
	// Dog 클래스에 plus()메서드를 생성하세요
	// 두 개의 정수값을 받아서 더하기를 한 결과를 출력
	public void plus(byte a, byte b) {
		short result = (short) ((short)a + b);
		System.out.println(result);
	}
	
	public void plus(short a, short b) {
		int result = (int)a + b;
		System.out.println(result);
	}
	
	public void plus(int a, int b) {
		long result = (long)a + b;
		System.out.println(result);
	}
// ==============================================
	// 생성자
	private int id;

	public Dog() {  // 디폴트 생성자: 매개변수가 없는 생성자
		
	}
	
	public Dog(int a) {  // 사용자 생성자: 매개변수가 있는 생성자
		
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
}
