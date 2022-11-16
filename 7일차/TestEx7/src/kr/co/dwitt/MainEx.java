package kr.co.dwitt;

import com.naver.Dog;

public class MainEx {

	public static void main(String[] args) {
		// Dog클래스르 이용해서 dog1 객체를 생성하고
		// dog1이 갖고 있는 t1()메서드를 호출하세요
		Dog dog1 = new Dog();
		//dog1.t1(false);
		int result = dog1.t1(false);
		System.out.println(result);
		
		// Dog클래스의 사용자 생성자를 이용해서
		// dog2 객체를 생성하고
		// dog2가 갖고 있는 t2()메서드를 호출
		Dog dog2 = new Dog(10, "멍멍");		
		dog2.t2(10);
				
	}

}
