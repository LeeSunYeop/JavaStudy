package com.naver;

public class Turtle {
	
	public void y1() {
		
		int i = 0;
		
		while(i<10) {
			
			System.out.println(i);
			
			++i;
		}
	}
	
	public void y2() {
	// 9 8 7 6 5 4 3 2 1 0 이 출력되게 
	// while문을 구현하세요
		int i = 9;
		
		while(i >= 0){
			
			System.out.println(i);
			
			--i;
		}		
	}
	
	public void y3() {
		// 홍길동1, 홍길동2, 홍길동3...홍길동100
		// while문을 이용해서
		int i = 0;
		
		while(i < 101) {
			
			System.out.println("홍길동"+ i);
			
			++i;
		}
	}
	
	public void y4(int n) {
		int i = 0;
		while(i < n+1) {
			
			System.out.println(i);
			
			++i;
		}
	}
	
	public void y6() {
		// 10보다 작거나같은 2의 배수 출력하기
		int i = 0;
		while(i <= 10) {
			
				System.out.println(i);
				i = i + 2;
			
		}
	}
	
	public void y7() {
		// 0~91보다 작은 5의 배수 출력하기
		// while문 사용
		int i = 0;
		while(i < 91) {
			
			System.out.println(i);
			i = i + 5;
			
		}				
	}
	
	// y8()메서드를 호출할 때, 외부로부터 MemberDTO() 객체를 입력받음
	// dto가 null이면,
	// 0부터 100까지의 값을 출력한다
	public void y8(MemberDTO dto) {
		
		if(dto == null) {
			int i = 0;
			while(i<101) {
				System.out.println(i);
				
				++i;
			}			
		}
	}
	
	// y9()메서드를 호출할 때, 외부로부터 MemberDTO() 객체를 입력받음
	// dto가 null이 아니면,
	// 0부터 100까지의 값을 출력한다
	public void y9(MemberDTO dto) {
		
		if(dto != null) {
			
			int i = 0;
			while(i<101) {
				System.out.println(i);
				
				++i;
			}
		}
	}
	
	// y10()메서드는 구구단 중 5단을 출력함.
	// while문을 이용
	public void y10() {
		int dan = 5;
		int i = 1;
		while(i < 10) {
			
			System.out.println(dan+" x "+i+" = "+(dan*i));
			
			++i;
		}
	}
	
	// y11()메서드는 구구단 중 3단을 출력함.
	public void y11() {
		int dan = 3;
		int i = 1;
		while(i < 10) {
			
			System.out.println(dan+" x "+i+" = "+(dan*i));
			
			++i;
		}
	}
	
	// y12()메서드는 구구단 중 n단을 출력함.
	// n은 y12()메서드를 호출할 때, 외부에 입력함
	public void y12(int n) {
		int dan = n;
		int i = 1;
		while(i < 10) {
			
			String msg = dan+" x "+i+" = "+(dan*i);
			System.out.println(msg);
			
			++i;
		}
	}
	
	// y13()메서드는 구구단 출력하는 기능
	// y12()를 이용하고 while문을 이용
	public void y13() {
		int i = 2;
		while(i < 10) {
			y12(i);
			
			++i;
		}
	}
	
	public void y15() {
		String msg = "소수입니다.";
		int num = 23;
		int i = 2;

		while(i < num) {
				
			if(num % i == 0) {
				msg = "소수가 아닙니다.";
				System.out.println(msg);
				
			}
			
			++i;
		}
		
		System.out.println(msg);
	}
}
