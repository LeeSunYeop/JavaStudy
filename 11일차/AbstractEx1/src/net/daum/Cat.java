package net.daum;

import java.util.ArrayList;
import java.util.List;

import com.naver.Animal;
import com.naver.Dog;

public class Cat {
	
	public void k1() {
		// 자료형은 더 큰 자료형, 값은 더 작은 자료형
		// 형태는 같아야 한다.
		
		long a = (byte)3;
		long b = (short)3;
		long c = 3;
		//long d = true; 자료형이 달라 에러남
		long e = 'a';  // 문자형이지만 아스키코드에서 65라는 숫자를 가지고 있다
		
	}
	
	public void k2() {
		// 1. List와 ArrayList 중에서 누가 더 클까요?
		//    -> 누가 부모클래스(인터페이스)고, 누가 자식 클래스입니까?
		// 2. List와 ArrayList는 형태가 같을까요?
		// 다형성: 자료형은 부모, 값은 자식생성자를 이용해서 변수 생성하는 방법
		// 참조자료형 변수명 = new 참조자료형의 생성자();
		// 부모자료형 변수명 = new 자식자료형의 생성자();  -> 다형성으로 만들때
		List<String> a = new ArrayList<String>();
		
	}
	
	public void k3() {
		// 다형성을 이용해서 객체를 생성
		// Animal 클래스의 객체 생성하기
		// 부모자료형 변수명 = new 자식자료형의 생성자();  -> 다형성으로 만들때
		Animal a = new Dog();
		
	}
	
	public void k4() {
		
		Animal a = new Dog();
		Animal b = new Turtle();
		String c = new String();
		StringBuffer d = new StringBuffer();
		// 자료형 변수명 = 자료형에 맞는 값;
		// 자료형은 Animal Animal 	String 	StringBuffer
	}

}
