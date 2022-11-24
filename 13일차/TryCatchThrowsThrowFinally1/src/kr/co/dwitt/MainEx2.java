package kr.co.dwitt;

import com.naver.Dog;

public class MainEx2 {

	public static void main(String[] args) {
		// Dog클래스를 이용해서 dog2 변수를 생성
		// dog2가 갖고 있는 me5()메서드를 호출하세요
		Dog dog2 = new Dog();
		dog2.me5("hello", 0);
		dog2.me5("hello", "hello".length());
		// 인덱스의 값보다 큰값을 넣어서 오류가 뜸

	}

}
