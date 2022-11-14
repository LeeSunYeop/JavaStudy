package kr.co.dwitt;

import com.naver.Cat;

import net.daum.Person;

public class MainEx4 {

	public static void main(String[] args) {
		// 유반환 유파람
		
		Person p1 = new Person();
		Person p2 = new Person();
		
		// p1객체가 갖고 있는 plus(int)메서드를 호출하세요
		// 인수가 필요한 메서드에는 변수 선언 공식의
		// = 의 우측에 들어가는 자료형에 맞는 값을 넣어 줌
		int result = p1.plus(111);
		
		// 메서드 호출할 때, ()에 넣는 값은
		// 변수 선언 공식의 우측의 자료형에 맞는 값이다.
		
		int a = 2100000000;
		int b = 2100000000;
		// p2 객체가 갖고 있는 plus(int, int)메서드를
		// 호출하세요. 단, 변수 a,b를 반드시 사용하세요
		int result2 = p2.plus(a, b);
		System.out.println(result2);
		// 오버플로우가 발생함
		
		int result3 = p2.plus(a, p1.plus(111));
		// 변수 선언할 떄, 자료형에 맞는 값
		// 값을 직접(literal), 변수명, 메서드를 넣어도 됨
		
		// p1 객체가 갖고 있는 say() 메서드를 호출하세요
		String str1 = p1.say("홍길동");
		System.out.println(str1);
		
		// p2 객체가 갖고 있는 catSetIdNName()메서드를 호출하세요
		Cat cat1 = p2.catSetIdNName(111, "홍길동");
		System.out.println(cat1.getName());
		System.out.println(cat1.getId());
		
		String msg = "vip#kim#200#서울";
		// msg객체가 갖고 있는 charAt()메서드를 호출하세요
		char c1 = msg.charAt(6);  // v->0, i->1, p->2, #->3, k->4, i->5, m->6....
		System.out.println(c1);  // 출력 m 나옴
		// 자바의 인덱스는 모두 몇부터 시작한다? 0
		// 단, stack과 오라클은 1부터 시작한다.
		
		
		// msg 객체가 갖고 있는 length()메서드를 호출하세요
		int size = msg.length();
		System.out.println(size);
		
		// msg가 갖고 있는 substring(int)메서드 호출
		String s1 = msg.substring(3); 
		// 값을 넣은 인덱스 숫자를 기준으로 vip는 잘라내고 #부터 출력을한다
		// substring 잘라내다 라는 의미가 잇다
		System.out.println(s1);  // 출력 #kim#200#서울
		
		// msg 객체가 갖고 있는 split()메서드가 있음
		String[] arr =  msg.split("#");
		System.out.println(arr);
		// 배열이다. 배열이라 출력값은 주소값만 나옴
					
	}

}
