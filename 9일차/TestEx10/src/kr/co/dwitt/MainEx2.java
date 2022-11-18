package kr.co.dwitt;

import com.naver.Dog;

public class MainEx2 {

	public static void main(String[] args) {
		// 배열 얇은복사하는 방법
		Dog[] arr = { // 1차원 배열임
			new Dog(), new Dog(1, "해피"), new Dog(2, "메리")
		};
		
		Dog[] arr2 = arr;
		
		System.out.println(arr2[0]);
		
		Dog dog = arr2[0];
		dog.setId(100);
		dog.setName("땡구");
		
		System.out.println(dog);
		
		Dog dog2 = arr[0];
		System.out.println(dog2);

	}

}
