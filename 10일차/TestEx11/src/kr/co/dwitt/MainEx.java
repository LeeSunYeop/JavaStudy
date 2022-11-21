package kr.co.dwitt;

import com.naver.Frog;

public class MainEx {

	public static void main(String[] args) {
		// 자료형이 Frog클래스인 frog1 변수를 생성하고
		// 그 안에 있는 r1()메서드를 호출
		Frog frog1 = new Frog();
		frog1.r1();
		
		// forg1 객체가 갖고 있는 r2()메서드 호출
		frog1.r2();
		
		frog1.r3();
		
		frog1.r4();
		
		frog1.r6();
		
		frog1.r7(null);
		frog1.r7("hello");
		
		frog1.r8("hello");
		
		frog1.r9("          hi world        ");
		
		frog1.r10(null);
		frog1.r10_1("hi world");
		
		frog1.r11("01234567");
		
		String msg = frog1.r12("01234567", 1, 4);
		System.out.println(msg);
		
		frog1.r13();
		frog1.r14();
		frog1.r15();
		frog1.r16();
		
		frog1.r17();
		frog1.r18();
		frog1.r19();
	}

}
