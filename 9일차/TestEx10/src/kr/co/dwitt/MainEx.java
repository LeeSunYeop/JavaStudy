package kr.co.dwitt;

import com.naver.Dog;

import net.daum.Cat;

public class MainEx {

	public static void main(String[] args) {
		// Dog클래스의 사용자 생성자를 이용해서
		// dog1 객체를 생성하고
		// me2()메서드를 호출하세요
		Dog dog1 = new Dog(10, "멍멍");
		
		int[] arr = {1, 2, 3};
		dog1.me8(arr);
		
		Cat cat = new Cat();
		cat.w5();
		
		System.out.println(":::::::::::");
		dog1.me9(1, 2, 3);  // 값을 직접 넣어서 출력 할 수도 있다.

	}
}
