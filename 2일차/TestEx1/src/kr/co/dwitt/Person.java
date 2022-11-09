package kr.co.dwitt;

import com.naver.Dog;

import net.daum.Cat;

public class Person {
	
	String id;
	String name;
	Dog dog1;  // 있을수도 있고 없을 수도 있다
	Cat cat1 = new Cat();  // cat은 무조건 있다.
	
	// id = new String("m001"); -> 필드에서는 대입이 불가하다
	
	public Person() {
		
	}
	
	public void me1() {
		
	}
	

}
