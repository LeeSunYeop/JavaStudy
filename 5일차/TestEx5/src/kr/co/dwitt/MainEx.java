package kr.co.dwitt;

import java.util.Date;

import com.naver.Dog;
import com.naver.ItemDTO;
import com.naver.MemberDTO;
import com.naver.TestDTO;

import net.daum.Cat;
import net.daum.Person;

public class MainEx {

	public static void main(String[] args) {
		
		System.out.println(111);
		System.out.println(true);
		System.out.println('a');
		System.out.println(2.1F);
		// 출력하는 기능인데 다 자료형이 다르다.
		
		Dog dog1 = new Dog();
		
		Cat cat1 = new Cat();
		cat1.setId(100);
		
		Cat cat2 = new Cat(200);
		
		//int a = 300;
		//Cat cat3 = new Cat(a);
		Cat cat3 = new Cat(300);
		
		//String a = new String("m001");
		//String b = new String("김유신");
		//Cat cat = new Cat(5);
		Person p1 = new Person("m001", "김유신", new Cat(5));
		
		// MerberDTO의 사용자 생성자를 이용해서  dto1 객체를 만들어 주세요
		//String a = new String("m001");
		//String b = new String("이순신");
		//String c = new String("서울");
		//Date d = new Date(111L);
		
		MemberDTO dto1 = new MemberDTO("m001", "이순신", "서울", new Date(111L));
		
		// Person 클래스의 사용자 생성자를 이용해서 p2 객체를 만들어 보세요
		Person p2 = new Person("m002", "야옹이", new Cat(3));
		
		
		ItemDTO idto1 = new ItemDTO(3, "배", false);
		System.out.println(idto1);  // return에 name만 되어 있어서 배만 출력됨
		
		ItemDTO idto2 = new ItemDTO(3, "파인애플", true);
		System.out.println(idto1 == idto2); // 힙메모리 주소값이 같냐 라는 뜻
		System.out.println(idto1.equals(idto2));
		
		TestDTO t1 = new TestDTO(1, "테스트");
		System.out.println(t1);
		
	}

}
