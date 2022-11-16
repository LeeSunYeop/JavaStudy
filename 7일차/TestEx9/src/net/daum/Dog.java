package net.daum;

public class Dog {
	
	public void k1() {
		
		for(int i = 0; i < 10; i++) {
			
			System.out.println(i);
		}
	}
	
	public void k2() {
		// 9 8 7 6 5 4 3 2 1 0 이 출력되게 
		// for문을 구현하세요
		
		for(int i = 9; i >= 0; i--) {
			System.out.println(i);
		}
	}
	
	public void k3() {
		// 홍길동1, 홍길동2, 홍길동3...홍길동100
		// for문을 이용해서
		for(int i = 0; i < 100; i++) {
			System.out.println("홍길동"+(i+1));
		}
	}
	
	public void k4() {
	
		for(int i = 0; i < 10; i++) {
			i += 1;
			System.out.println(i);
					
		}
	}
}
