package com.naver;

public class Turtle {
	// 예외가 발생하든, 그렇지 않든 무조건 실행해야 하는 코드
	// 그 코드는 finally 구문에 작성하시면 됨
		
	public void me1() {
		int a = 10;
		int b = 20;
		int c = 0;
		int result = -1;
		
		try {
			result = a/b;
			System.out.println("작업 끝");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("작업 끝");
		}
		
		try {
			result = a/c;
			System.out.println("작업 끝2");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("작업 끝2");
		}
	}
	
	public void me2() {
		int a = 10;
		int b = 20;
		int c = 0;
		int result = -1;
		
		try {
			result = a/b;			
		} catch (Exception e) {
			e.printStackTrace();			
		} finally {
			System.out.println("작업 끝");
		}
		
		try {
			result = a/c;			
		} catch (Exception e) {
			e.printStackTrace();			
		}finally {
			System.out.println("작업 끝2");
		}
	}
	
	public int me3() {
		int a = 10;
		int b = 20;
		int c = 0;
		int result = -1;
		
		try {
			result = a/b;	
			
			return 300;
		} catch (Exception e) {
			e.printStackTrace();	
			
			return 500;
		} finally {
			System.out.println("작업 끝");
		}  // finally가 있으면 마지막은 무조건 finally안에 있는 코드가 실행된다
		   // 예외 여부와 상관없이 반드시 실행할 코드는 finally 구문에 작성한다.
	}
	
	public int me4() {
		int a = 10;
		int b = 20;
		int c = 0;
		int result = -1;
		
		try {
			result = a/b;
			return 30;
		} catch (Exception e) {
			e.printStackTrace();
			return 500;
			
		} finally {
			System.out.println("작업 끝");
		}
	}
		
}
