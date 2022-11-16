package kr.co.dwitt;

import com.naver.Dog;

import net.daum.Cat;

public class MainEx2 {

	public static void main(String[] args) {
		// Cat클래스의 디폴트 생성자를 이용해서
		// cat1을 생성하고
		// cat1이 갖고 있는 sleep()메서드 호출
		Cat cat1 = new Cat();
		cat1.sleep();
		System.out.println(cat1);
		
		// Cat클래스의 사용자 생성자를 이용해서
		// cat2를 생성하고
		// cat2가 갖고 있는 sleep()메서드 호출
		Cat cat2 = new Cat("c111", "야옹이", new Dog(111, "해피"));
		cat2.sleep();
		System.out.println(cat2);

	}

}
