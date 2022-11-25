package net.daum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import com.naver.MemberDTO;

public class Test {
	
	public void y1() {
		// Set을 학습하려면, Set을 구현하고 있는 자식클래스를 알아야 합니다
		// Set을 100% 구현한 클래스는 무엇인가요?  HashSet
		// Set 객체를 set1 변수명으로 생성해 주세요
		Set<Boolean> set1 = new HashSet<Boolean>(); 
		
		// 변수명 set2, generic Type: 4L, 5L 6L
		Set<Long> set2 = new HashSet<Long>();
		
		// 변수명 set3, generic Type: MemberDTO
		Set<MemberDTO> set3 = new HashSet<MemberDTO>();
		
		// 변수명 set4, generic Type: String
		Set<String> set4 = new HashSet<String>();
		
	}
	
	public void y2() {
		// Set, generic Type: Double, 변수명 set1
		Set<Double> set1 = new HashSet<Double>();
		
		set1.add(new Double(3.14));
		set1.add(9.8);
		set1.add(9.8);
		set1.add(9.8);
		set1.add(9.8);
		set1.add(9.8);
		set1.add(9.8);
		set1.add(9.8);
		set1.add(9.8);
		set1.add(new Double(9.8));
		
		int size = set1.size();
		System.out.println(size);  // 2
		
		System.out.println(set1);  // [3.14, 9.8] 나옴 중복은 안됨..
		
		// set1.get(); get이란 메서드가 없다
		
		// set1에 들어 있는 요소값을 전부 출력하세요
		// 2가지 방법 다 이용하세요
		Iterator<Double> it = set1.iterator();
		List<Double> list = new ArrayList<>();
		
		while (it.hasNext()) {
			
			Double val = it.next();
			list.add(val);
		
		}
		
		List<Double> list2 = new ArrayList<>(set1);
		System.out.println(set1);  // [3.14, 9.8]   2가지 방법으로 작성이 가능하다.
		System.out.println(list2);  // [3.14, 9.8]
		
		List<Double> list3 = new ArrayList<>(set1);
		
		Collections.sort(list3);
		System.out.println(list3);
		
	}
	
	public void y3() {
		// Set, MemberDTO, set1
		Set<MemberDTO> set1 = new HashSet<MemberDTO>();
		
		set1.add(new MemberDTO(1, "kim"));
		set1.add(new MemberDTO(2, "lee"));
		set1.add(new MemberDTO(3, "park"));
		set1.add(new MemberDTO(1, "lee"));
		
		System.out.println(set1.size());  // 3나옴.. 중복되서 3나옴(id가 같으면 같은 객체로 인식됨)
		System.out.println(set1);  // [kim, lee, park] 나옴
		
		Iterator<MemberDTO> it = set1.iterator();
		List<MemberDTO> list = new ArrayList<>();
		
		while (it.hasNext()) {
			
			MemberDTO dto = it.next();
			list.add(dto);
			
			System.out.println(dto.getId() + " : " + dto.getName());
			
		}		
		
		List<MemberDTO> list2 = new ArrayList<MemberDTO>(set1);
		Collections.sort(list2);
		System.out.println(list2);
		
	}
	
	public void y4() {
		Set<String> set1 = new HashSet<String>();
		
		set1.add("hello");
		set1.add("world");
		set1.add("good");
		set1.add("morning");
		set1.add("HELLO");
		set1.add("Hello");
		set1.add("hello");
		
		System.out.println(set1.size());  // 6 중복되서..
		System.out.println(set1);  // [world, Hello, HELLO, hello, good, morning]
		
		
		Iterator<String> it = set1.iterator();
		//List<String> list = new ArrayList<>();
				
		while (it.hasNext()) { // it 뒤에 값이 있습니까? 라는 의미 
							// 값이 있으면 true가 밑에 코드가 실행된다.
			String val = it.next();
			//list.add(val);
			System.out.println(val);
			//world
			//Hello
			//HELLO
			//hello
			//good
			//morning 나옴
		}
		
		List<String> list = new ArrayList<>(set1);
		System.out.println(list);
		
		List<String> list2 = new ArrayList<>(set1);
		Collections.sort(list2);
		System.out.println(list2);
		
			
	}
	
	public void y5() {
		Random rnd = new Random();
		
		//int num = rnd.nextInt(45);  // 0부터 44까지 랜덤으로 숫자를 정해준다.		
		//System.out.println(num);
		
		// set을 이용해서 로또번호 6개 출력하기
		// 중복되면 안됨. set
		// int num = rnd.nextInt(45) + 1; // 1부터 45까지 랜덤으로 숫자나옴
		Set<Integer> set1 = new HashSet<Integer>();
		
		while (set1.size() < 6) {
			int num = rnd.nextInt(45) + 1;
			set1.add(num);
			
		}
		
		System.out.println(set1); // [32, 16, 35, 25, 27, 12]
		
		Iterator<Integer> it = set1.iterator();
		List<Integer> list = new ArrayList<Integer>();
		
		while (it.hasNext()) {
			Integer val = it.next();
			list.add(val);		
		}
		
		Collections.sort(list); // 번호순으로 나열해줌
		System.out.println(list); // [12, 16, 25, 27, 32, 35]
	}

}
