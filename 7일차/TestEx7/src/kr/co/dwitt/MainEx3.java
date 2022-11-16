package kr.co.dwitt;

import com.naver.Dog;

import net.daum.Cat;

public class MainEx3 {

	public static void main(String[] args) {
		// Member클래스의 사용자 생성자를 이용해서
		// kim이라는 객체를 만들고
		// kim이 갖고 있는 f1()메서드 호출
		// Dog dog1, Dog dog2, Cat cat1, int id, int name
		Dog dog1 = new Dog();
		Dog dog2 = new Dog(1, "해피");
		Cat cat1 = new Cat("c001", "양", new Dog());
		
		Member kim = new Member(dog1 , dog2, cat1, 1, 1004);
		kim.f1();
	}

}
