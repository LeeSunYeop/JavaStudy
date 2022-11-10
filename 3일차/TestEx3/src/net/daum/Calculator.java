package net.daum;

import com.naver.Dog;

import kr.co.dwitt.MainEx;

public class Calculator {
	
	private double first;  // private 해당클래스에서만 사용가능하며 다른클래스에서는 사용못함
	private double second;
	private double result;
	
	// 유반환 무파람 메서드 학습
	
	// plus,  first + second 그 결과값을 반환하는 기능을 갖고 있습니다
	public double plus() {
		result = first + second;
		return result;
	}
	
	// 유반환 무파람 메서드, say(), "안녕하세요"를 반환합니다
	public String say() {    // 많이 사용함
		return "안녕하세요";
	}
	
	public String say2() {
		String msg = new String("안녕하세요");
		return msg;
	}
	
	public String say3() {
		return new String("안녕하세요");
	}
	
	// 유반환 무파람 메서드 ,  callDog() 메서드는 Dog 클래스로 만들어진 변수(객체)를 반환합니다
	public Dog callDog() {
		Dog dog = new Dog();
		return dog;
	}
	
	// 유반환 무파람 메서드,  callMain() 메서드, MainEx로 만들어진 객체를 반환합니다
	public MainEx callMain() {
		MainEx mainEx = new MainEx();
		return mainEx;
	}
	
	// 유반환 무파람 메서드 , onoff(),  반환되는 값은 false/true 중 하나 맘대로 정하세요
	public boolean onoff() {
		return true;
	}
	
	// getFirst() 메서드를 만들어 주세요. 멤버변수 first를 반환함.
	public double getFirst() {  //getFirst--get+첫글자대문자이면 private이 사용되고 있구나를 생각하면됨
		return first;
	}
	
	// 멤버변수 second를 반환하는 메서드를 만들어 주세요
	public double getSecond() {
		return second;
	}
	
	
// 자동으로 만들기
// 직접 타이핑해서 만들어도 되구요.
//	이클립스의 기능을 이용해도 됩니다
//	보통 이클립스의 기능을 이용합니다.
//	필드 영역에 마우스 우클릭
//	source-Generate getters/setters를 선택하고
//	select all 버튼을 클릭 후
//	generate 버튼 클릭
	public double getResult() {
		return result;
	}

	public void setResult(double result) {
		this.result = result;
	}

	public void setFirst(double first) {
		this.first = first;
	}

	public void setSecond(double second) {
		this.second = second;
	}
	
	

}
