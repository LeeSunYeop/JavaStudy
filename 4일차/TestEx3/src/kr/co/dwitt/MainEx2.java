package kr.co.dwitt;

import com.naver.Cat;
import com.naver.Dog;

import net.daum.Calculator;
import net.daum.Person;

public class MainEx2 {
	
	public static void main(String[] args) {
		// 유반환 무파람 메서드 호출
		
		// 개 1마리 만듦
		// 고양이 1마리 만듦
		// 계산기 1대 만듦
		// 사람 1명 만듦
		Dog dog1 = new Dog();
		Cat cat1 = new Cat();
		Calculator c1 = new Calculator();
		Person p1 = new Person();
		
		// 개가 가지고 있는 id 값을 출력해보세요
		int id = dog1.getId();		
		System.out.println(id);
		
		// 고양이의 이름을 가져와서 출력하세요
		String name = cat1.getName();		
		cat1.setName("고양이");
		name = cat1.getName(); 
		// 만약 String name = cat1.getName(); 보존해야 한다면..
		// name = cat1.getName(); 을 다시 String name2 = cat1.getName(); 새로 만들어 준다
		System.out.println(name);
		
		// 계산기에 있는 더하기 기능을 호출해 보세요
		double result = c1.plus();
		
		// 계산기에 있는 callDog() 메서드를 호출하세요
		Dog dog2 = c1.callDog();  // 개가 1마리 더 만들어짐
		Dog dog3 = c1.callDog();  // 개가 또 1마리 더 만들어짐
		
		System.out.println(dog1); //com.naver.Dog@2a139a55 주소값이 다 다르다
		System.out.println(dog2); //com.naver.Dog@15db9742
		System.out.println(dog3); //com.naver.Dog@6d06d69c
		// 총 3개의 객체가 만들어진 것이다
		
		String name2 = dog2.getName();
		
		
		// p1이 갖고 있는 cat1의 이름을 출력하시오
		String catName = p1.getCat1().getName();
		System.out.println(catName);
		
		// 교수님이 작성해주신거
		Cat cat2 = p1.getCat1();
		String name3 = cat2.getName();
		System.out.println(name3);
		
		// p1이 갖고 있는 cal의 plus()메서드를 호출하세요
		Calculator c2 = p1.getCal();
		double result2 = c2.plus();
		
		// dog1이 갖고 있는 getId()를 메서드를 호출하세요
		id = dog1.getId();
				
	}

}
