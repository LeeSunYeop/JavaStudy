package net.daum;

import com.naver.Animal;
import com.naver.Cat;
import com.naver.Dog;

public class Person {
	
	private Animal animals = new Dog();
	
	private Animal animals2 = new Cat();
	
	public Person() {
		animals.sleep();	
		((Dog)animals).show(); // Animal자료형이 다르기 때문에 형변환으로 바꿔줘야한다.
				
	}
	
	public void me1() {
		
		((Cat)animals2).show();
		((Dog)animals2).show(); // MainEx가서 실행시키면 오류가 뜬다
	}
	
	public void me2() {
		Dog dog = null;
		
		if(animals2 instanceof Dog) { // animals2가 Dog클래스의 인스턴스냐? 라는 의미
			                          // animals2가 Dog클래스를 이용해서 만든 객체냐? 라는 의미
			                          // 객체 = 인스턴스
			dog = (Dog) animals2; // animals2을 (Dog)로 형변환하고 그 값을 dog에 넣어라 는 의미임
			dog.show();
		}else {
			System.out.println("Dog 클래스로 만든게 아님.");
		}   // kim.me2();  -> Dog 클래스로 만든게 아님. 나옴
	}
	
	public void me2_1() {   // 개발자라면 이 코드처럼 짜야한다.
		Cat cat = null;
		
		if(animals2 instanceof Cat) {
			
			cat = (Cat) animals2; 
			cat.show();   // kim.me2_1(); -> 실을 굴립니다. 나옴
		}
	}

}
