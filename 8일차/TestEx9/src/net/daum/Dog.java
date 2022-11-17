package net.daum;

import com.naver.MemberDTO;

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
			int result = i + 1;
			System.out.println("홍길동"+result);
		}
	}
	
	public void k33() {
		
		for(int i = 0; i < 10; i++) {
			for(int j = 0; i > j; j++) {
				System.out.print("*");
			}
			
			System.out.println("");
		}
	}
	
	public void k4(int n) {
		// k4()메서드를 생성함.
		// 0부터 n까지의 숫자를 1씩 증가하면서 n+1개의 숫자를 출력합니다.
		// n은 k4()메서드를 호출할 떄, 외부에 입력합니다
		for(int i = 0; i < n+1; i++) {
			System.out.println(i);	
		}
	} 
	
	public void k5(int n, int m) {
		// k5()메서드르르 생성함
		// n부터 m까지의 숫자를 1씩 증가하면서 m-n+1개의 숫자를 출력합니다
		// n과 m은 k5()메서드를 호출할 때, 외부에서 입력합니다
		for(int i = n; i < m-n+1; i++) {
			System.out.println(i);
		}			
	}
	
	public void k6() {
		// k6()메서드르르 생성함
		// 0~10에 있는 숫자 중에서 2의 배수만 출력합니다
		for(int i = 0; i < 11; i++) {
			
			if(i % 2 == 0) {
				System.out.println(i);
			}
		}
	}
	
	public void k7() {
		// k7()메서드를 생성함
		// 0~100에 있는 숫자 중에서 5의 배수가 아닌 것만 출력합니다
		for(int i = 0; i < 101; i++) {
			
			if(i % 5 != 0) {
				System.out.println(i);
			}
		}
	}
	
	// k8()메서드를 생성함
	// 0~100에 있는 숫자 출력합니다.
	// k8()메소드를 호출할 떄, MemberDTO 객체를 입력받도록 수정하세요.
	// 외부에서 넘겨받은 MemberDTO 객체가 null이면, 0~100에 있는 숫자를 출력함
	public void k8(MemberDTO dto) {
		
		if(dto == null) {
			
			for(int i = 0; i < 101; i++) {
				System.out.println(i);			
			}			
		}
	}
	
	// k9()메서드를 생성함	
	// 외부에서 넘겨받은 MemberDTO 객체가 null 아니면, 0~100에 있는 숫자를 출력함
	public void k9(MemberDTO dto) {
		
		if(dto != null) {

			for(int i = 0; i < 101; i++) {
				System.out.println(i);
			}
		}
	}
	
	// k10()메서드는 구구단 중 5단을 출력하는 기능을 갖고 있음
	// 5 x 1 = 5, 5 x 2 = 10... 5 x 9 = 45
	public void k10() {
		
		for(int i = 1; i < 10; i++) {
			String msg = 5+" x "+i+" = "+(5*i);
			System.out.println(msg);
			//System.out.println("5 x " + i + " = " + 5*i);
		}
	}
	
	// k11()메서드는 구구단 중 3단을 출력하는 기능을 갖고 있음
	// 3 x 1 = 3, 3 x 2 = 6... 3 x 9 = 27
	public void k11() {
		
		for(int i = 1; i < 10; i++) {
			String msg = 3+" x "+i+" = "+(3*i);
			System.out.println(msg);
		}
	}
	
	// k12()메서드는 구구단 중 특정단을 출력하는 기능을 갖고 있음
	// 특정 단에 대한 정보는 k12()메서드 호출될 때 입력됨
	public void k12(int n) {
		
		for(int i = 1; i < 10; i++) {
			String msg = n+" x "+i+" = "+(n*i);
			System.out.println(msg);
		}
	}
	
	// k13()메서드는 구구단 전체를 출력하는 기능을 갖고 있음
	// 구현할때, 반드시 k12()를 활용하세요
	public void k13() {
				
		for(int dan = 2; dan < 10; dan++) {
			k12(dan);
		}
	}
	
	public void k14() {
		
		for(int dan = 2; dan < 10; dan++) {
			
			for(int i = 1; i < 10; i++) {
				String msg = dan+" x "+i+" = "+(dan*i);
				System.out.println(msg);   // 이렇게 코드를 짜면 안된다 
			}			
		}
	}
	
	// k15()메서드는 23이 소수[소쑤]인지 여부를
	// 알려주는 기능을 갖고 있습니다.
	// 소수[소쑤]는 1과 자기자신 외에는 약수가 없는 수
	// 1이나 자기자신으로 나누었을 때만 나머지가 0...
	public void k15() {
		for(int i = 2; i < 23; i++) {
			
			if(23 / i == 0) {
				System.out.println(23+"은 소수가 아닙니다");
			}
		}
	}
	
	public void k16() {
		for(int i = 2; i < 22; i++) {
			
			if(22 / i == 0) {
				System.out.println(22+"은 소수가 아닙니다");
			}
		}
	}

	// k17()메서드는 n이 소수[소쑤]인지 여부를 판결해주는 기능을 갖고 있습니다.
	// n은 k17()메서드 호출할 때, 외부로부터 입력받습니다.
	public void k17(int n) {
		for(int i = 2; i < n; i++) {
			
			if(n % i == 0) {
				System.out.println(n+"은 소수가 아닙니다.");
			}
		}
	}
	
	// k18()메서드는 n이 소수[소쑤]인지 여부를 판결해주는 기능을 갖고 있습니다.
	// n은 k18()메서드 호출할 때, 외부로부터 입력받습니다.
	// 소수일 때, "n은 소수입니다"가 출 되게 하세요 
	public void k18(int n) {    // 교수님 답
		String msg = n+"은 소수입니다.";
		
		for(int i = 2; i < n; i++) {
			if(n % i == 0) {
				System.out.println(i);
				msg = n +"은 소수가 아닙니다.";
			}
		}
		
		System.out.println(msg);
	}
	
	public void k188(int n) {    // 내가한 답
		for(int i = 2; i < n; i++) {
			
			if(n % i == 0) {
				System.out.println(n+"은 소수가 아닙니다.");
				break;
			}else {
				System.out.println(n+"은 소수입니다");
				break;
			}
		}
	}
	
	public void k19(int n) {    
		String msg = n+"은 소수입니다.";
		
		for(int i = 2; i < n; i++) {
			if(n % i == 0) {
				//System.out.println(i);
				msg = n +"은 소수가 아닙니다.";
				break;   // break는 if문만 빠져나온다
			}
		}
		
		System.out.println(msg);
	}
	
	// k20()메서드는 2~50의 숫자를 소수인지 아닌지 판별하는 기능을 갖고 있음
	// 구현할 때, k19()메서드를 활용하세요
	public void k20() {
		for(int i = 2; i < 51; i++) {
			k19(i);
		}
	}
	
	// k21()메서드는 n~m의 숫자를 소수인지 아닌지 판별하는 기능을 갖고 있음
	// 구현시, k19()메서드를 활용하세요
	public void k21(int n, int m) {
		for(int i = n; i < m+1; i++) {
			k19(i);
		}
	}
	
	// k22()메서드는 구구단 중에서 특정단을 제외하고 찍기
	// 구현시, k12()메서드를 활용하세요	
	public void k22() {
		int a = 5;
		
		for(int dan = 2; dan < 10; dan++) {
			if(dan != a) {
				k12(dan);
			}
		}
	}
	
	public void k23() {
		int a = 5;
		
		for(int dan = 2; dan < 10; dan++) {
			if(dan == a) {
				continue; // 그 밑에 있는 것은 실행하지 않고 다시 위로 올라간다
			}
			
			k12(dan);
		}
	}
	
	// k24()메서드는 구구단 중에서 특정단을 제외하고 찍기
	// 5, 9, 13, 17, 21, 25, 29...? 20개의 숫자 출력하기
	// 왜 0부터 시작하지 않을까 생각을 한다. 0+5
	// 0, 4 ,8, 12, 16, 20, 24... 4의배수 하고 마지막에 5를 더해준다
	public void k24() {
				
		for(int i = 0; i < 20; i++) {
			int num = i * 4 + 5;
			System.out.println(num);		
		}
	}
	
	// k25()메서드
	// 7, 8, 11, 16, 23, 32, 43...? 20개의 숫자 출력하기
	// 왜 0부터 시작하지 않을까?
	// 0, 1, 4, 9, 16, 25, 36, 49, 64, 81.. i*i 에다 +7을 하면 된다
	
	public void k25() {
		for(int i = 0; i < 20; i++) {
			int num = i*i+7;
			System.out.println(num);
		}
	}
}