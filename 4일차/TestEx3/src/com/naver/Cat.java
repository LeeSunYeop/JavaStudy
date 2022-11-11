package com.naver;

import net.daum.Calculator;

public class Cat {
	
	private int id;
	private String name;
	
	
//  자동으로 만들기
//  직접 타이핑해서 만들어도 되구요.
//	이클립스의 기능을 이용해도 됩니다
//	보통 이클립스의 기능을 이용합니다.
//	필드 영역에 마우스 우클릭
//	source-Generate getters/setters를 선택하고
//	select all 버튼을 클릭 후
//	generate 버튼 클릭	
	public int getId() {
		return id;
	}


	public String getName() {
		return name;
	}


	// 무반환 유파람
	public void test(boolean a) {
		if(a) {
			System.out.println("show");
		}else {
			System.out.println("no");
		}
	}
	
	
	// 무반환 유파람 메서드 학습 , test2() 메서드는 메서드 호출할 때 34와 같은 값을 입력받아서
	// 그값을 출력하는 기능을 갖고 있다.
	public void test2(int a) {
		System.out.println(a);
	}
	
	// 무반환 유파람 메서드 학습 , test3() 메서드는 사람 이름을 입력 받아서 
	// 그 이름을 출력하는 기능을 갖고 있음
	public void test3(String name) {
		System.out.println(name);
	}
	
	// 무반환 유파람 메서드 학습, test4()메서드는 Calculator로 만들어진 객체를 넘겨받아서 
	// 그 객체에 있는 second값을 출력하는 기능을 갖고 있다
	public void test4(Calculator a) {
		// 호출한 메서드의 반환형이 void가 아니면 반환형을 자료형으로 하는 선언한다.
		// 초깃값은 해당 메서드가 반환하는 값
		double c = a.getSecond(); 
		System.out.println(c);
	}
	
	// 무반환 유파람 메서드, setId()를 생성하시오
	public void setId(int a) {
		id = a;
	}
	
	// 무반환 유파람 메서드, name 값을 수정하는 메서드를 생성하시오
	public void setName(String b) {
		name = b;
	}

}
