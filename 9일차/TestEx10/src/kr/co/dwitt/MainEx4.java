package kr.co.dwitt;

import com.naver.Dog;
import com.naver.Person;

public class MainEx4 {

	public static void main(String[] args) {
		
		Dog[] dog1 = {
				new Dog(1, "해피"),
				new Dog(2, "메리"),
				new Dog(3, "벡구")
		};
		
		Person kim = new Person(0, "김유신", dog1);
		
		// kim이 갖고 있는 개들 중에서 인덱스가 0번인 것을 인덱싱하세요
		Dog[] dogs = kim.getDog1();
		Dog dog = dogs[0];
		
		// kim이 갖고 있는 개들 중에서 인덱스가 0인 요소의
		// id를 1000으로 변경하세요.
		// name은 happy로 변경하세요
		dog.setId(1000);
		dog.setName("happy");
		
		// kim이 갖고 있는 개들 중에서 인덱스가 가장 큰 것을 인덱싱하세요
		// dogs를 이용하세요		
		dog = dogs[dogs.length - 1];
		
		// dog 변수에 들어 있는 개의 아이디를 2000으로 변경
		// dog 변수에 들어 있는 개의 이름을 white dog로 변경하세요
		dog.setId(2000);
		dog.setName("white dog");
		
	}

}
