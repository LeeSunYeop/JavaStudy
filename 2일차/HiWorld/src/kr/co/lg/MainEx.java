package kr.co.lg;

import com.naver.Dog;
import com.samsung.Cat;

public class MainEx {

	public static void main(String[] args) {
		// 자료형 변수명 = 자료형에 맞는 값;
		// 자료형 변수명 = new 자료형();
		// 자료형 변수명 = new 생성자();
		
		// com.naver 패키지에 있는 Dog클래스가 자료형
		// 변수명 d1
		// 위 정보를 이용해서 d1 변수를 선언하시오
		// 자료형 변수명 = 자료형에 맞는 값;
		// 참조자료형 변수명 = new 참조자료형();
		Dog d1 = new Dog();
		
		// com.samsung 패키지에 있는 Cat 클래스가 자료형
		// 변수명 c1
		// 위 정보를 이용해서 c1 변수를 선언하시오
		Cat c1 = new Cat(1);
		
		// 314를 변수 a에 입력하세요
		int a = 314;
		
		// true를 변수 b에 입력하세요
		boolean b = true;
		
		// 3.14를 변수 c에 입력하세요, 단, 정밀도는 고려하지 않고 메모리를 절약하도록
		// 선언하세요
		// float 은 4바이트 먹고 double은 8바이트 먹는다
		float c = 3.14f;
		
		// "hello world"를 변수 d에 입력하세요
		String d = new String("hello world");
		
		System.out.println(d1);
		System.out.println(c1);
		
		d1.me1();
	}
}





