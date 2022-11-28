package com.naver;

public class Sum {
	public int num1;	
	public int num2;	
	public int num3;
	
	Object key1 = new Object();	
	Object key2 = new Object();
	
	public void plus(int i) {
		
		synchronized (this) {  // synchronized 동기화 문제해결 키워드
			num1 += i;		// this 동기화블럭에 들어갈 수 있는 열쇠
		}
	}
	
	public void plus2(int i) {
		synchronized (key1) {   // 변수(num2)가 여러개 있으면  갯수만큼 key를 만들어준다
			num2 += i;
		}
	}
	
	public void plus3(int i) {
		synchronized (key2) {
			num3 += i;
		}
	}

}
