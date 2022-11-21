package com.naver;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Frog {
	
	public void r1() {
		// string 클래스의 명시적 객체 생성법
		String str = new String("hello world");
		System.out.println(str);
	}
	
	public void r2() {
		// string 클래스의 암시적(묵시적) 객체 생성법
		String str = "id is teacheryo";
		System.out.println(str);
	}
	
	public void r3() {
		String str1 = new String("hi");
		String str2 = "hi";
		
		System.out.println(str1);
		System.out.println(str2);
		
		System.out.println(str1 == str2);  // 같은 객체냐? false로 나옴(저장공간이 다르다)
		System.out.println(str1.equals(str2)); // hi 같냐? true로 나옴(문자열이 같다) - 동등성 비교
		
	}
	
	public void r4() {
		String a = "hi";
		String b = "hi";
		String c = "Hi";
		String d = new String("hi");
		
		System.out.println(a == b); // true 나옴(저장공간이 같다) - 동일성 비교
		System.out.println(a == c); // false 나옴(저장공간이 다르다) 
	}
	
	public void r5() {
		// String 틀래스의 변하지 않는 성격(불변적 성격)
		String a = "hi";
		a = "good";   // hi라는 문자열이 사라지는 것이 아니라 메모리에 계속 저장되어있다
	}
	
	public void r6() {
		// StringBuild
		// StringBuffer클래스를 사용한다
		
		StringBuffer sb = new StringBuffer();
		sb.append("안녕");
		sb.append("하세요");
		sb.append("!");
		sb.append("저는");
		sb.append("엽이");
		sb.append("입니다");
		String str = sb.toString();
		System.out.println(str);  
		// 또는 System.out.println(sb);  // sb.toString() 이 생략되어 있다
	}
	
	public void r7(String msg) {
		// msg가 null이면 return
		if(msg == null) {
			System.out.println("::::::::");
			return;
		}
		// 문자열로 된 문자를 문자로 변경할 때
		char c =  msg.charAt(0);
		System.out.println(c);
		// frog1.r7(null);  값이 null 입력해서 :::::::: 나옴
		// frog1.r7("hello"); 출력 h 나옴
	}
	
	public void r8(String msg) {
		if(msg == null) {
			return;
		}
		
		int len = msg.length();
		System.out.println(len);
		// frog1.r8("hello");  출력 5 나옴		
	}
	
	public void r9(String msg) {
		// "         hello world        "  좌우공백 제거하기
		if(msg != null) {
			String str = msg.trim();
			System.out.println(str);
			// frog1.r9("          hi world        ");  
			// 출력 좌우공백 제거되서 hi world 나옴
		}
	}
	
	public void r10(String msg) {
		// msg가 갖고 있는 substring()메서드 호출
		// substring() 문자열 자라내기 이다		
		// msg.substring(3);
		// frog1.r10(null); 하면 출력에 객체가 없는데 객체를 호출한다고 에러메시지 나옴
		// 그래서 밑에 있는 코드처럼 짜는거다
	}
	
	public void r10_1(String msg) {
		
		if(msg == null) {
			return;
		}
		
		try {
			msg.substring(3); 
		} catch (Exception e) {
			// TODO: handle exception
			// e.printStackTrace();  // 에러가 발생해도 출력하겠다는 코드임
			System.out.println("글자는 "+ msg.length()+" 자입니다");
			
			String str = msg.substring(0);
			System.out.println(str);			
		} 
	}
	
	public void r11(String msg) {
		if(msg == null) {
			return;
		}
		
		String str = msg.substring(3, 5);  // 3인곳부터 5인곳까지 잘라내겠다라는 의미
		System.out.println(str);
		// frog1.r11("01234567");  출력 34 나옴		
	}
	
	// 외부로부터 문자열과 그 문자열을 자를 범위에 관한 정보를 입력 받은 후
	// 잘라내기한 문자열을 반환하는 기능
	public String r12(String msg, int begin, int stop) {
		if(msg == null) {
			return "";
		}
		
		String str = msg.substring(begin, stop);
		return str;
		
		// MainEx 가서
		// String msg = frog1.r12("01234567", 1, 4);
		// System.out.println(msg);  출력 123 나옴
	}
	
	public void r13() {
		String msg = "hello world";
		
		String str = msg.replace('h', 't');
		System.out.println(str);  // h를 t로 바꾸겠다라는 의미
		// frog1.r13();  출력 tello world
	}
	
	public void r14() {
		String msg = "hello world";
		String str = msg.replace("ll", "rr");
		System.out.println(str);
		// frog1.r14();   출력 herro worrd		
	}
	
	public void r15() {
		String msg = "hello world";
		String str = msg.replace('l', 'r');
		System.out.println(str);
		// frog1.r15(); 출력 herro worrd   l 이 전부다 r로 바뀜
	}
	
	public void r16() {
		String msg = "hello world";
		msg.endsWith(".jpg");  // 확장자가 jpg 냐 라는 의미
		msg.contains("h");
		msg.startsWith("h"); // h로 시작했냐?
		int idx = msg.indexOf('h'); // 'h' 0반환해준다
		msg.startsWith("l"); // 2를 반환해준다
		String str = msg.toUpperCase();   // 대문자로 만들어준다
		String str2 = msg.toLowerCase();  // 소문자로 만들어준다
		System.out.println(str);
		System.out.println(str2);		
	}
	
	public void r17() {
		String msg = "id#pw#grade#point";
		
		String[] arr = msg.split("#");
		
		for(int i=0; i<arr.length; i++) {
			String token = arr[i];
			System.out.println(token);
			// id  
			// pw
			// grade
			// point
		}
	}
	
	public void r18() {
		String msg = "id#pw##grade#point";
		
		String[] arr = msg.split("#");
		
		for(int i=0; i<arr.length; i++) {
			String token = arr[i];
			System.out.println(token);
			//id
			//pw
			//
			//grade
			//point 중간에 한칸 띄고 이렇게 나옴 
		}
	}
	
	public void r19() {
		String msg = "id#pw##grade#point";
		StringTokenizer st = new StringTokenizer(msg, "#");
		// StringTokenizer 핵심 포인트임
		
		String[] arr = new String[st.countTokens()];
		int i = 0;
		
		while(st.hasMoreTokens()) {
			
			String token = st.nextToken();
			System.out.println(token);
			arr[i] = token;
			
			++i;
		}
	}
	
	public void r20() {
		String msg = "id#pw##grade#point";
		StringTokenizer st = new StringTokenizer(msg, "#");
		
		String[] arr = new String[st.countTokens()];
		int i = 0;
		
		while(st.hasMoreTokens()) {
			
			String token = st.nextToken();
			System.out.println(token);
			arr[i++] = token;						
		}
	}
	
	public void r20_1() {
		String msg = "id#pw##grade#point";
		StringTokenizer st = new StringTokenizer(msg, "#");
		
		List<String> list = new ArrayList<String>();
		
		while(st.hasMoreTokens()) {
			
			String token = st.nextToken();
			System.out.println(token);
			
			list.add(token);
		}
	}
}
