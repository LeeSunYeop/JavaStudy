package net.daum;

public class Cat {
	
	public int a = 10;
	public final int HELLO_WORLD = 10; 
	// 상수는 다 대문자로 쓰며 띄어쓰기해야 할 곳을 _(언더바)를 사용한다.
	
	public void me() {
		// 변수: 값이 변하는 데이터 메모리
		// 상수: 값이 항상 같은 데이터 메모리
		
		a = 100;
		// HELLO_WORLD = 100; -> 오류뜸. 상수니깐 바꾸면 안된다.
		
		if(HELLO_WORLD == a) {
			System.out.println("실행");
		}
		
		if(HELLO_WORLD == 10) {
			System.out.println("실행");
		}
	}

}
