package kr.co.dwitt;

import com.naver.Test;

public class MainEx {

	public static void main(String[] args) {
		Test.b = 100;  // 호출할때는 클래스명.변수명
		
		//Test.a = 100;
		Test t1 = new Test();  // 호출할때는 객체명.변수명
		t1.a = 100;  
		
		Test t2 = new Test();
		System.out.println(t1.a);
		System.out.println(t2.a);
		
		System.out.println(Test.b);
		System.out.println(t1.b);
		System.out.println(t2.b);
		
		t1.me1();
		Test.k1();
		
	}

}
