package kr.co.dwitt;

import com.naver.Dog;

public class MainEx {
	
	public static void main(String[] args) {
		
		// 지역변수 선언 공식
		// 지료형 변수명 = 자료형에 맞는 값;
		// 참조자료형의 변수 선언 공식
		// 참조자료형 변수명 = new 참조자료형();
		// 참조자료형 변수명 = new 생성자();
		// 클래스명과 생성자의 이름은 같다.
		
		Turtle t1 = new Turtle();
		
		System.out.println(t1.isMale);
		System.out.println(t1.sex);
		System.out.println(t1.age);
		System.out.println(t1.id);
		System.out.println(t1.name);
		System.out.println(t1.cat);
		
		
		// Dog d1 = new Dog();
		// System.out.println(d1.booleanA);
		
	}

}
