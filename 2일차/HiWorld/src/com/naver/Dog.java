package com.naver;

import com.samsung.Cat;

public class Dog {
	
	public Dog() {
		// TODO Auto-generated constructor stub
	}
	
	public void me1() {
	// 무반환 무파람
	// main()메서드에서만 변수 선언하나요? 절대 아닙니다.
		// 변수선언공식
		// 자료형 변수명 = 자료형에 맞는 값;
		boolean a = true;
		
		char b = '안';
		
		byte c = -128;
		short d = 300;
		int e = 2;
		long f = 3L;
		
		float g =3.14F;
		double h = 9.8;
		
		Cat i = new Cat(222);
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		// me1() 메서드 안에 선언된 변수들은 왜
		// 콘솔창에 출력이 안 됐을까요?
		
		
	}

}
