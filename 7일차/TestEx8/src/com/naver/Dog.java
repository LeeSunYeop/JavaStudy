package com.naver;

public class Dog {
	
	private int id;
	private String name;
	
	public Dog() {}
		
	public Dog(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public void me1() {
		int a = 2;
		
		System.out.println("start");
		switch (a) {
		case 0:
			System.out.println("0입니다.");
			break;
		case 1:
			System.out.println("1입니다.");
			break;
		case 2:
			System.out.println("2입니다.");
		case 3:
			System.out.println("3입니다.");
			break;			

		default:
			System.out.println("default입니다.");
		}
		
		System.out.println("end");
	}
	
	public void me2() {
		String msg = new String("hello");
		
		switch (msg) {
		case "good":
			System.out.println("good");			
			break;
		case "hello":
			System.out.println("hello");
			break;
		default:
			System.out.println("없음");			
		}
	}
	
	public void me3() {
		long a = 30L;
		
		//switch (a) {
		//case value:
			
		//	break;

		//default:
		//	break;
		//}         switch ~case문에 사용할 수 있는 자료형은 
		         // int, String, enum 3개만 된다
	}
	
	public void me4(int score) {
		// switch ~ case문을 이용해서
		// 성적을 분류해주세요
		// 수우미양가
		int result = score / 10;
		
		switch (result) {
		case 10 :
			
		case 9 :
			System.out.println("수");
			break;
		case 8 :
			System.out.println("우");
			break;
		case 7 :
			System.out.println("미");
			break;
		case 6 :
			System.out.println("양");
			break;		
		default:
			System.out.println("가");
			
		}
	}
	
	public void me5(int month) {
		// switch ~ case문을 이용해서
		// 각 월별 마지막 일자를 출력하세요
		
		switch (month) {         
		case 2:
			System.out.println(28);
			break;
		case 4:
		case 6:
		case 9:
		case 11:	
			System.out.println(30);
			break;
		default:
			System.out.println(31);
		
		}
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
