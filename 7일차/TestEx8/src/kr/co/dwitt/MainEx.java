package kr.co.dwitt;

import com.naver.Dog;

import net.daum.Fruit;

public class MainEx {

	public static void main(String[] args) {
		// Dog클래스의 사용자 생성자를 이용해서
		// dog1 객체를 만들고
		// dog1이 갖고 잇는 me1()메소드 호출
		Dog dog1 = new Dog(1, "멍멍");
		dog1.me1();
		
		dog1.me2();
		
		dog1.me4(100);
		
		dog1.me5(2);
		
		Fruit a = Fruit.APPLE;
		System.out.println(a);  // 출력 APPLE 나옴
		
		System.out.println(a.equals("APPLE"));  //출력 false 자료형이 달라 false로 나옴
		
		System.out.println(a.ordinal()); // 출력 0 나옴 순서가 0은 애플, 1은 바나나, 2는 멜론 이다
		
		Fruit b = Fruit.valueOf("APPLE");
		System.out.println(b);  //출력 APPLE 나옴
		
		System.out.println(a == b);  // 출력 true
		
		//Fruit c = Fruit.valueOf("CHERRY");
		//System.out.println(c); // 체리가 없다고 오류가 뜬다.
		
		switch (a) {
		case MELON:
			System.out.println("멜론");
			break;
		case APPLE:
			System.out.println("사과");
			break;
		case BANANA:
			System.out.println("바나나");
			break;	

		default:
			break;    // 출력 사과 나옴
		}
		
	}

}
