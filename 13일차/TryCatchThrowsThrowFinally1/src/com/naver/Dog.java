package com.naver;

public class Dog {
	
	public void me1(int a, int b) {
		int c = a/b;
		System.out.println(c);
	}
	
	public void me2(int a, int b) {
		int c = -1;
		
		try {
			c = a/b;  // try안에 넣는건 오류가 날법한 코드를 넣는다. 즉, 외부에서 값을 입력받을 경우다
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); // 에러가 왜뜨는지 알려주는 코드
		}
		
		System.out.println(c);
	}
	
	public void me3(int a, int b) {
		try {
			int c = a/b;
			System.out.println(c);  // 문제가 생겼는데 이코드는 실행하지 않고 넘어간다
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("문제가 생겼군요. 1588-1111으로 연락주세요.");
			e.printStackTrace();
		}
	}
	
	public void me4(int a, int b) {
		try {
			int c = a/b;
			System.out.println(c);  
			
		} catch (ArithmeticException e) { // ArithmeticException 오류메시지에보면 나옴. 원래가 이코드임
			// TODO Auto-generated catch block
			System.out.println("문제가 생겼군요. 1588-1111으로 연락주세요.");
			e.printStackTrace();
		}
	}
	
	public void me5(String msg, int idx) {
		try {
			char c = msg.charAt(idx);
			System.out.println(c);
		} catch (StringIndexOutOfBoundsException e) {  // catch 코드를 넣은데 자료형이 큰거부터 먼저 입력한다.
			System.out.println("알맞은 인덱스를 입력하세요.");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("모르겠다");
			e.printStackTrace();
		}
	}

}
