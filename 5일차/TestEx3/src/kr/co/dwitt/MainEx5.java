package kr.co.dwitt;

import com.naver.Cat;
import com.naver.Dog;

public class MainEx5 {
	
	public static void main(String[] args) {
		
		MainEx5 obj1 = new MainEx5();
		// 무반환 무파람
		// obj1이 갖고 있는 k1()메서드를 호출하세요
		// 객체명.메서드명();
		obj1.k1();
		
		// 유반환 무파람
		// obj1이 갖고 있는 k2()메서드를 호풀하세요
		// 반환형과같은자료형 변수명 = 객체명.메서드명();
		// 변수명 = 객체명.메서드(); // 변수명이 반환형과 같은 자료형을 갖고 있다면..
		int result1 = obj1.k2();
		
		// 무반환 유파람
		// obj1이 갖고 있는 k3() 메서드를 호출하세요
		// int형 변수 a를 선언하세요
		// int a = 3;
		// String 변수 b를 선언하세요
		// String b = new String("hello");
		// 또는 "hello";
		// Dog형 변수 c를 선언하세요
		// Dog c = new Dog();
		obj1.k3(3, "hello", new Dog());
		
		// 유반환 유파람
		// obj1이 갖고 있는 k4()메서드를 호출하세요
		Cat result2 = obj1.k4(10, "야옹이", new Cat());
		System.out.println(result2.getName());
		
	}
	
	public void k1() {
		System.out.println("k1()메서드입니다.");		
	}
	
	public int k2() {
		int a =30;
		
		return a;
	}
	
	public void k3(int a, String b, Dog c) {
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(c.getName());
	}
	
	public Cat k4(int a, String b, Cat c) {
		c.setId(a);
		c.setName(b);
		
		return c;
		
	}

}
