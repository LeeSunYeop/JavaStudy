package net.daum;

public class Cat {
	// try~catch와 throws를 구분해서 사용할 줄 알아야 합니다.
	// 1. 내가 최종 사용자인가?
	// 2. 예외처리에 대한 권한이 내게 있는가?
	
	public void me1() {
		try {
			String msg1 = "1";
			int num1 = Integer.parseInt(msg1);
			
			String msg2 = "hello";
			int num2 = Integer.parseInt(msg2);
			
			System.out.println(num1);
			System.out.println(num2);
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("문제가 없습니다.");
		
	}
	
	public void me2() throws Exception {  
		String msg1 = "1";
		int num1 = Integer.parseInt(msg1);
		
		String msg2 = "hello";
		int num2 = Integer.parseInt(msg2);
		
		System.out.println(num1);
		System.out.println(num2);
		
		System.out.println("문제가 없습니다.");		
	}
	

}
