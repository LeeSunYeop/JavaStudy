package net.daum;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.naver.MemberDTO;

public class TestMap {
	
	public void h1() {
		// Map학습..
		// HashMap
		// Map, map1, key: Integer, Value: String
		Map<Integer, String> map1 = new HashMap<Integer, String>();
		
		// map2, key: String, Value: String
		Map<String, String> map2 = new HashMap<String, String>();
		
		// map3, key: list<Integer>, value: String
		Map<List<Integer>, String> map3 = new HashMap<List<Integer>, String>();
		
		// map4. key: map<String, String>, value: List<Integer>
		Map<Map<String, String>, List<Integer>> map4 = new HashMap<Map<String, String>, List<Integer>>();
		
		// map5, key :String, value: List<MemberDTO> --- 실무에서 많이 쓰는 형태
		Map<String, List<MemberDTO>> map5 = new HashMap<String, List<MemberDTO>>();
		
	}
	
	public void h2() {
		// map1, K: 3.1F, 4.8F, v: 1L, 2L, 5L
		Map<Float, Long> map1 = new HashMap<Float, Long>();
		map1.put(3.14F, 100L);
		map1.put(9.8F, 200L);
		map1.put(4.27F, 300L);
		map1.put(2.71F, 400L);
		map1.put(1.44F, 500L);
		map1.put(1.73F, 600L);
		map1.put(2.0F, 700L);
		map1.put(2.5F, 700L);
		map1.put(3.0F, 100L);
		map1.put(3.14F, 314L);
		
		System.out.println(map1.size());  // 9
		System.out.println(map1);
		// {2.0=700, 2.5=700, 3.0=100, 9.8=200, 1.44=500, 2.71=400, 1.73=600, 3.14=314, 4.27=300}
		// 원래 3.14F=100L 먼저 나오다가 나중에 3.14F=314L 으로 수정되어 출력됨
		
		Long val = map1.get(1.44F);
		System.out.println(val);
		
		val = map1.get(3.0F);
		System.out.println(val);
		
		Set<Float> set1 = map1.keySet();
		
		
//		List<Float> list = new ArrayList<Float>();
//		for(int i=0; i<list.size(); i++) {
//			float key = list.get(i);
//			val = map1.get(key);
//			System.out.println(val);
//		}
		
		Iterator<Float> it = set1.iterator();
		while (it.hasNext()) {
			Float key = it.next();
			val = map1.get(key);
			System.out.println(val);
		}		
	}
	
	public void h3() {
		// map1, K: "hello", "good", V: 1, 2, 4
		Map<String, Integer> map1 = new HashMap<String, Integer>();
		
		map1.put("one", 1);
		map1.put("two", 2);
		map1.put("three", 3);
		map1.put("four", 4);
		map1.put("one", 100);
		
		int size = map1.size(); 
		System.out.println(size);  // 4
		System.out.println(map1); // {four=4, one=100, two=2, three=3} 
		                          // {key=value, key=value, key=value}
		
		int num =  map1.get("one");
		System.out.println(num);
		
		// map1 요소 중 키가 three인 것의 값은?
		num = map1.get("three");
		System.out.println(num);
		
		
		
		Set<String> set1 = map1.keySet();
		
//		List<String> list = new ArrayList<String>(set1);
//		for(int i=0; i<list.size(); i++) {
//			String key =list.get(i);
//			int val = map1.get(key);
//			System.out.println(val);
//		}
				
		Iterator<String> it = set1.iterator(); // 회사가면 이코드를 많이 쓴다
		while (it.hasNext()) {
			String key = it.next();
			int val = map1.get(key);
			System.out.println(val);
			
		}
		
	}
	
	public void h4() {
		// 각자가 자신이 설계가 map 객체 만들어 보고
		// map에 값을 입력하고
		// map 들어 있는 요소들의 수를 출력하고
		// map에 들어 있는 특정 key에 해당하는 val를 출력
		// map에 들어 있는 전체 val 출력
		
		// k: String, V: Integer
		Map<String, Integer> map1 = new HashMap<String, Integer>();
		
		map1.put("하하", 10);
		map1.put("허허", 20);
		map1.put("호호", 30);
		map1.put("후후", 40);
		map1.put("히히", 50);
		
		//int size = map1.size();
		System.out.println(map1.size());
		
		//int val = map1.get("히히");
		System.out.println(map1.get("히히"));
		
		Set<String> set1 = map1.keySet();
		
		Iterator<String> it = set1.iterator();
		while (it.hasNext()) {
			String key = it.next();
			int val = map1.get(key);
			System.out.println(key + " : " + val);
			
		}
		
		List<String> list = new ArrayList<String>(set1);
		for(int i=0; i<list.size(); i++) {
			String key = list.get(i);
			int val = map1.get(key);
			System.out.println(val + " : " + key);
		}
		
	}
	
	public void h5() {
		Map<String, List<MemberDTO>> map1 = new HashMap<String, List<MemberDTO>>();
		
		List<MemberDTO> list1 = new ArrayList<>();
		list1.add(new MemberDTO(1, "kim"));
		list1.add(new MemberDTO(2, "lee"));
		list1.add(new MemberDTO(3, "park"));
		
		List<MemberDTO> list2 = new ArrayList<MemberDTO>();
		list2.add(new MemberDTO(1, "김"));
		list2.add(new MemberDTO(2, "박"));
		
		List<MemberDTO> list3 = new ArrayList<MemberDTO>();
		list3.add(new MemberDTO(100, "마이클"));
		
		map1.put("대한민국", list1);
		map1.put("북한", list2);
		map1.put("미국", list3);
		
		List<MemberDTO> list_north = map1.get("북한");
		MemberDTO dto = list_north.get(0);
		System.out.println(dto.getId());    // 1
		System.out.println(dto.getName());  // 김
		
		// map1에 있는 value들의 최종요소값의 id와 name을 출력하세요
		Set<String> set1 = map1.keySet();
		
		List<String> list = new ArrayList<String>(set1);
		
		for(int i=0; i<list.size(); i++) {
			String key = list.get(i);
			
//			List<MemberDTO> list_m = map1.get(key);
//			for(int j=0; j<list_m.size(); j++) {
//				dto = list_m.get(j);
//				System.out.println(dto.getId());
//				System.out.println(dto.getName());
//			}  주석으로 친 코드가 밑에 있는 코드로 다시 짜여져 간결하게 할 수 있다.
			printIdNName(map1, key);

		}
	
	}
	
	private void printIdNName(Map<String, List<MemberDTO>> map1, String key) {
		List<MemberDTO> list_m = map1.get(key);
		for(int j=0; j<list_m.size(); j++) {
			MemberDTO dto = list_m.get(j);
			System.out.println(dto.getId() + " : " + dto.getName());
//			100 : 마이클
//			1 : kim
//			2 : lee
//			3 : park
//			1 : 김
//			2 : 박

		}
		
	}
	
	public void h6(String id, String name, String birth) {
		// map은 dto클래스 생성하기 싫을 때, 많이 사용함.
		// 이런 상황에서는 무조건 key의 자료형은 String
		// Value의 자료형은 상황을 봐야하는데, Value자료형이 다 같으면 해당 자료형 사용
		// 다르면 Object 사용
		Map<String, String> map1 = new HashMap<String, String>();
		
		map1.put("id", id);
		map1.put("name", name);
		map1.put("brith", birth);
		
		System.out.println(map1);
		
	}
	
	public void h7(int id, String name, Date birth) {
		Map<String, Object> map1 = new HashMap<String, Object>();
		
		map1.put("id", id);
		map1.put("name", name);
		map1.put("birth", birth);
		
		System.out.println(map1);
	}

}
