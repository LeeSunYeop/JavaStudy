package kr.co.dwitt;

import com.naver.Cat;
import com.naver.Dog;

import net.daum.Calculator;
import net.daum.Person;

public class MainEx {
	
	public static void main(String[] args) {
		
		Cat cat1 = new Cat();
		cat1.test(true);
		cat1.test2(34);
		
		Cat cat2 = new Cat();
		cat2.test3("철수");
		
		Calculator c1 = new Calculator();
		cat2.test4(c1);
		
		Cat cat3 = new Cat();
		cat3.setId(55);
		
		Person str1 = new Person();
		str1.say("철수");

// ===============================================		
		// 무반환 무파람 메서드 호출 방법
		// 자바에서는 메서드를 호출하려면, 클래스를 이용해서 객체를 만들고
		// 그 객체가 갖고 있는 메서드를 호출해야 합니다
		// 객체가 갖고 있는 메서드에 접근할 때, .(닷연산자)를 이용해서 접근합니다.
		Dog dog1 = new Dog();
		Dog dog2 = new Dog();
		Dog dog3 = new Dog();
		Dog dog4 = dog3;
		
		dog1.sleep();
		
		// dog3한테 달리라고 명령해 보세요
		dog3.run();
		
		// dog2한테 먹으라고 명령해 보세요
		dog2.eat();
		
	//	dog4.id = 111;
		// 에러메시지 The field Dog.id is not visible
		// 접근제한자 때문에 보이지 않습니다라는 의미
		int id = dog4.getId();
		System.out.println("수정전: "+id);
		dog4.setId(111);
		System.out.println("비정상: "+id);
		id = dog4.getId();
		System.out.println("정상: "+id);
		
	
	}

}
