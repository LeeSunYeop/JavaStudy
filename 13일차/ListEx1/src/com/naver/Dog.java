package com.naver;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Dog {
	
	public void me1() {
		// ArrayList를 이용해서 list 객체를 생성하세요
		// ArrayList<int> list = new ArrayList<int>();  오류남
		ArrayList<Integer> list = new ArrayList<Integer>();
	}
	
	public void me2() {
		List<String> list = new ArrayList<String>();
	}
	
	public void me3() {
		List<StringBuffer> list = new ArrayList<StringBuffer>();
	}
	
	public void me4() {
		List<Box<String>> list = new ArrayList<Box<String>>();
	}
	
	public void me5() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		List<String> list2 = new ArrayList<String>();
		
		List<StringBuffer> list3 = new ArrayList<StringBuffer>();
		
		List<Box<String>> list4 = new ArrayList<Box<String>>();
		
		List<Set<Box<Integer>>> list5 = new ArrayList<Set<Box<Integer>>>();
		
	}
	
	public void me6() {
		// 자료형: List, 변수명: list 객체생성, 제네릭타입: char
		List<Character> list = new ArrayList<Character>();
		
		list.add('a');
		list.add('a');
		list.add((char)97);
		list.add(new Character('a'));
		list.add('b');
		list.add('c');
		list.add('d');
		list.add('e');
		list.add('F');
		//System.out.println(list);
		// 출력 [a, a, a, a, b, c, d, e, F] 나옴
		
		int size = list.size();  // 갖고있는 요소가 몇개 있는지 알고 싶으면 size 쓴다
		System.out.println(size);  // 출력 9 나옴
		
		char a0 = list.get(0);   // get(인덱스번호)을 사용하여 a를 출력함 
		System.out.println(a0);  // 자료형은 char 임
		
		for(int i=0; i<list.size(); i++) {
			char c = list.get(i);
			System.out.println(c);  // list에 있는 모든요소 출력한다
		}
		
		// d, e를 삭제하세요
		System.out.println(list);
		list.remove(7);  // 요소하나씩 제거하기 remove(6)
		list.remove(6);  // list는 삭제를 안하고 저장만 한다.
		System.out.println(list);
	}
	
	public void me7() {
		// 제네릭타입: String
		// list에 5개의 값을 입력하세요
		List<String> list = new ArrayList<String>();
		
		list.add("안녕");
		list.add("하세");
		list.add("요.");
		list.add("^^");
		list.add("~~");
		System.out.println(list);
		
		int size = list.size();  
		System.out.println(size);
		
		String str3 = list.get(3);  // get를 사용하여 ^^ 요소를 가져온다
		System.out.println(str3);   // 자료형은 String
		
		for(int i=0; i<list.size(); i++) {
			String msg = list.get(i);
			System.out.println(msg);
		}
		
		System.out.println(list);  // 삭세하기전
		list.remove(new String("요."));  // 인덱스번호가 아닌 글자로 삭제하기
		System.out.println(list);  // 삭제 후
	}
	
	public void me8() {
		//제네릭타입 MemberDTO
		// list에 4개의 값을 입력하세요
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		
		list.add(new MemberDTO(1, "hi1"));
		list.add(new MemberDTO(2, "hi2"));
		list.add(new MemberDTO(3, "hi3"));
		list.add(new MemberDTO(4, "hi4"));
		System.out.println(list);
		
		int size = list.size();  
		System.out.println(size);
		
		MemberDTO a1 = list.get(1);  // list.get(1); 사용하여 "hi2" 를 출력한다
		System.out.println(a1);      // 자료형은 MemberDTO 임
		
		// al이 갖고있는 id 출력
		int id1 = a1.getId();
		System.out.println(id1);  // 2 나옴
		String name1 = a1.getName();
		System.out.println(name1);  // hi2 나옴
		
		for(int i=0; i<list.size(); i++) {
			MemberDTO dto = list.get(i);
			System.out.println(dto.getId()+":"+dto.getName());
			//1:hi1
			//2:hi2
			//3:hi3
			//4:hi4  나옴
			int id = dto.getId();
			String name = dto.getName();
			System.out.println(id+":"+name);
		
		}
		
		System.out.println(list);
		list.remove(new MemberDTO(4, null));  // 객체를 이용해서 삭제하기
		                 // (4, null) hashCode 만들때 id만 같아도 삭제되겠끔 만들어놔서 아이디랑 null값을 넣은거다
		System.out.println(list);
		
		list.clear(); // 한방에 다 삭제하기 삭제만 될뿐 저장된 공간은 그대로 남아 있음
		
	}

}
