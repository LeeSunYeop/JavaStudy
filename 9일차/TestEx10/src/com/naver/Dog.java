package com.naver;

import net.daum.Cat;

public class Dog {
	
	private int id;
	private String name;
	
	public Dog() {
		// TODO Auto-generated constructor stub
	}

	public Dog(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public void me1() {
		int a = 10;
		int b = 20;
		int c = 30;
		int d = 40;
		
		for(int i=0; i<4; i++) {
			System.out.println(a);
			System.out.println(b);
			System.out.println(c);
			System.out.println(d);
		}
	}
	
	public void me2() {
		int a0 = 10;
		int a1 = 20;
		int a2 = 30;
		int a3 = 40;
		
		for(int i=0; i<4; i++) {
			System.out.println("a"+i);
		}  // a0 a1 a2 a3 나오게 하려면 배열을 사용해야한다
	}
	
	public void me3() {
		// 배열 생성 방법1
		int[] arr1 = {10, 20, 30, 40};  
		System.out.println(arr1);  // 출력 [I@2a139a55 이 모습을 기억해야한다
	                              // 대괄호가 열려있고 닫혀잇지 않다
		System.out.println(arr1.length); // 출력 4 나옴, 배열의 크기를 알수 잇다
		
		// arr1의 10을 인덱싱해서 a에 초깃값으로 사용하세요
		int a = arr1[0];
		
		// arr1의 40을 인덱싱해서 d에 초깃값으로 사용하세요
		int d = arr1[3];		
		
		// arr1의 40을 인덱싱하는데 length속성을 이용해서
		int e = arr1[arr1.length-1];
		
		//int f = arr1[4]; // 인덱스 번호는 3이 최고인데 4를 입력해서 에러메시지 나온다
		
		int c = arr1[2];
		System.out.println(c); // 30 나옴
		
		arr1[0] = 100;
		int a1 = arr1[0];
		System.out.println(a1); // 100나옴
		
		arr1[2] = 300;
		int d1 = arr1[2];
		System.out.println(d1); // 300나옴
		
		arr1[arr1.length-1] = 400;
		int e1 = arr1[arr1.length-1];
		System.out.println(e1);  // 400나옴
		
		for(int i=0; i<arr1.length; i++) {
			int num = arr1[i];
			System.out.println(num);
		}	
	}
	
	/**
	 * 
	 */
	public void me4() {
		// 배열 생성 방법2
		int[] arr1 = new int[4];  // int[]는 대괄호가 들어가서 참조자료형이다, 4는 내가 원하는 크기 넣으면 됨
		Dog[] arr2 = new Dog[5];
		
		System.out.println(arr2.length); //출력 5 나옴
		
		for(int i=0; i<arr1.length; i++) {
			Dog dog = arr2[i];
			System.out.println(dog);  // null null null null null 5개 나온다
 		}
		
		// 100 200 300 400 500
		// 해피0 해피1 해피2 해피3 해피4		
		new Dog(100, "해피0");
		new Dog(200, "해피1");
		new Dog(300, "해피2");
		new Dog(400, "해피3");
		new Dog(500, "해피4");
		
		//0           1           2           3           4
		//(0+1)*100   (1+1)*100   (2+1)*100   (3+1)*100   (4+1)*100
		
		for(int i = 0; i < arr2.length; i++) {
			int id = (i+1)*100;
			String name = "해피"+i;
			arr2[i] = new Dog(id, name);
		}
		
		for(int i = 0; i < arr2.length; i++) {
			Dog dog = arr2[i];
			System.out.println(dog);
		}
	}  
		
	
	
	public void me5() {
		// 배열 생성 방법3
		int[] arr1 = new int[] {10, 20, 30, 40};
		
		System.out.println(arr1.length);  // 출력 4나옴
		
		// arr1의 길이를 출력하시오
		// arr1의 각 요솟값을 인덱싱한 후에 출력
		// arr1의 각 요솟값을 100, 200, 300, 400으로 수정
		System.out.println(arr1.length);
		
		int a = arr1[0];
		int b = arr1[1];
		int c = arr1[2];
		int d = arr1[arr1.length - 1];
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		
		arr1[0] = 100;
		arr1[1] = 200;
		arr1[2] = 300;
		arr1[arr1.length - 1] = 400;
		int a1 = arr1[0];
		int b1 = arr1[1];
		int c1 = arr1[2];
		int d1 = arr1[arr1.length - 1];
		System.out.println(a1);
		System.out.println(b1);
		System.out.println(c1);
		System.out.println(d1);
		
		// me5()메서드 안에 있는 arr1의 요솟값들을 for문을 이용해서 출력하시오
		for(int i = 0; i < arr1.length; i++) {
			int num = arr1[i];
			System.out.println(num);
		}
		
	}
	
	public void me6() {
		// true, false, true, false, true, false
		// 배열 arr1을 생성하시오
		boolean[] arr1 = {true, false, true, false, true, false};
		boolean[] arr2 = new boolean[6];
		boolean[] arr3 = new boolean[] {true, false, true, false, true, false};
		
		System.out.println(arr3.length); //출력 6나옴
	}
	
	public void me7() {
		// 3L  7L  11L  15L  19L  23L...1000개
		// arr1에 입력하세요
		// 0   4   8   12  16  20 ....
		long[] arr = new long[1000];
		
		for(int i=0; i<arr.length; i++) {
			long val = (i*4) + 3;
			
			arr[i] = val;
		}
		
		for(int i=0; i<arr.length; i++) {
			long val = arr[i];
			
			System.out.println(val);
		}
		
	}
	
	public void me8(int[] arr) {
		// arr의 요솟값을 전부 출력하세요.
		if(arr == null) {
			return;
		}
		
		for(int i=0; i<arr.length; i++) {
			int num = arr[i];
			System.out.println(num);
		}
	}
	
	// varargs(바라그스)
	public void me9(int... arr) {
		if(arr == null) {    // 값이 null이면 빠져나와라
			return;
		}
		
		for(int i=0; i<arr.length; i++) {
			int num = arr[i];
			System.out.println(num);
		}
	}
	
	public void me10(String a, int...arr) {  // int...arr은 맨 마지막에 넣어야한다.
		
	}
	
	public Cat[][] me11(){
		Cat[][] arr = new Cat[4][2];
		
		return arr;
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

	@Override
	public String toString() {
		return "Dog [id=" + id + ", name=" + name + "]";
	}
	
	
}
