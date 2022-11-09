package kr.co.dwitt;

import com.naver.Dog;

public class MainEx {
	
	public static void main(String[] args) {
		
		int a = 10;
		int b = 20;
		int c = b;
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		
		c = 50;
		System.out.println(b);
		System.out.println(c); 
		// 기본자료형은 다시 값을 정하면 그 값을 출력한다
		// 참조자료형은 그 반대가 된다
		
		Dog d1 = new Dog();
		Dog d2 = new Dog();
		Dog d3 = d2;
		
		System.out.println(d1);
		// 힙메모리 주소가 나옴
		System.out.println(d2);
		System.out.println(d3);
		// d2와 d3는 같은 힙메모리주소를 가진다
		
		System.out.println(d2.test);
		
		d2.test = 100;  // d2에 값을 재지정함  그럼 d3도 d2와 같은 값을 받음
		System.out.println("::::::::::::");
		System.out.println(d2.test);
		System.out.println(d3.test);
		System.out.println(d1.test);
		
		
	}

}
