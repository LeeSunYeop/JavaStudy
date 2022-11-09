package com.naver;

public class Dog {
	// 변수 선언 위치: main(), 일반 메서드, 생성자 + 필드
	// member 변수 
	// 클래스안에 있는 변수를 멤버변수, 같은 변수를 중복사용하면 안된다.
	boolean booleanA = false;
	char charB = 'B';
	byte byteC = 0;
	short shortD = 2;
	int intE = 3;
	long longF = 3L;
	float floatG = 3.0F;
	double doubleH = 2.222;
	
	String stringI = new String("music");
	
	
	
	public Dog() {
		// 생성자
		// local 변수(지역변수)
		
		System.out.println(booleanA);
		int test = 1;
		System.out.println(test);
		
	}
	
	public void me1(char a) { //char a: 매개변수
		// 메서드
		// local 변수(지역변수)
		int test = 1;
		
		System.out.println(booleanA);
		
	}
	
	
	
	
	
	
	
	
	
}
