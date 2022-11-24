package kr.co.dwitt;

import com.naver.Box;
import com.naver.Dog;

public class MainEx {

	public static void main(String[] args) {
		
		Box<String> dog1 = new Box<String>("hello");
		// 클래스안에 자료형을 동적으로 바꾸고 싶으면 Dog<String> 이렇게 코드 짜면됨 그리고 Dog<T>클래스를 만든다
		String type = dog1.getType();
		System.out.println(type);
		System.out.println(":::::::::::::::");
		
		Dog dog2 = new Dog();
		dog2.me6();
		
		dog2.me7();
		
		dog2.me8();
				
	}

}
