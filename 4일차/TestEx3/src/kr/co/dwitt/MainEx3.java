package kr.co.dwitt;

import com.naver.Cat;
import com.naver.Dog;

import net.daum.Calculator;
import net.daum.Person;

public class MainEx3 {
	
	public static void main(String[] args) {
		// 무반환 유파람
		
		// Person클래스를 이용해서
		// kim이라는 객체, lee라는 객체를 생성해주세요
		Person kim = new Person();
		Person lee = new Person();
		
		// kim이 갖고 있는 id를 1111로 수정하세요				
		System.out.println(kim.getId());
		
		kim.setId(1111);
		int id = kim.getId();	
		System.out.println(id);
		
		// lee가 갖고 있는 name을 이순신으로 수정하세요
		lee.setName("이순신");
		System.out.println(lee.getName());
		
		// lee가 갖고 있는 cat1을 가져와서
		// 그 cat1의 이름을 "야옹이"로 수정하세요
		Cat cat1 = lee.getCat1();
		cat1.setName("야옹이");
		
		// kim이라고 하는 사람이 갖고 있는 고양이를
		// lee가 갖고 있는 고양이로 변경하세요
		System.out.println(kim.getCat1().getName()); // 바꾸기전 이름이 없음
		
		kim.setCat1(cat1);
		System.out.println(kim.getCat1().getName()); // 바꾸고 이름이 야옹이 됨
		
		// cal을 넣어 주겠습니다
		// kim, lee든 cal는 없는 상태입니다
		// cal를 저장할 수 있는 주머니는 있어요.
		// 하지만 그 주머니에 계산기는 없습니다
		// lee 객체가 갖고 있는 cal에 
		// Calculator 객체를 넣어 주세요
		lee.setCal(new Calculator());
		
		// kim가 갖고 있는 dog1에 새로운 개를 넣어 주세요
		kim.setDog1(new Dog());
		
		// kim이 갖고 있는 개의 이름을 "땡구"로 수정하세요
		kim.getDog1().setName("땡구");
		System.out.println(kim.getDog1().getName());
				
		
	}

}
