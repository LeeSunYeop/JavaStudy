package com.naver;

public class Test {
	
	public int a = 10;
	public static int b = 10;
	
	public void me1() {
		System.out.println(111);
		
		k1();
		b = 100;
		
	}
	
	public static void k1() {
		System.out.println(2222);
		
		// a = 200; 인스턴스변수를 static에 넣어서 실행하면 오류가뜬다
		// 왜냐면 아직 힙메모리에 인스턴스변수가 저장이 되지 않아 실행이 안된다
		// static은 입력하는 즉시 힙메모리에 저장이 되기 때문에 아무때나 사용이 가능하다
		Test t = new Test();
		t.a = 300;
	}
}
