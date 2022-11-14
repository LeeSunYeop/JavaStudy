package kr.co.dwitt;

import com.naver.Dog;

public class MainEx {

	public static void main(String[] args) {
		
		Dog dog1 = new Dog();		
		dog1.a = 100;
		//dog1.b = 200;
		// protected : 같은 패키지에서는 접근 가능 + 상속관계가 성립하면 타 패키지 접근 가능
		//dog1.c = 300;
		//dog1.d = 400;
		
		Cat cat1 = new Cat();
		cat1.a = 1000;
		cat1.b = 2000;
		cat1.c = 3000;
		//cat1.d = 4000; // 깉은클래스가 아니라서 오류뜸

	}

}
