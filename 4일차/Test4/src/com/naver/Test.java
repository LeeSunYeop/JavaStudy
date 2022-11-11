package com.naver;

public class Test {
	
	public void me1(byte a) {
		System.out.println(a);
	}
	
	public void me2(long a) {
		System.out.println(a);
	}
	
	public void me3(float a) {
		System.out.println(a);
	}
	
	public void plus(int a) {
		int result = a + 3;
		System.out.println(result);
	}
	
	public void plus2(int a) {
		long result = a + 3;
		System.out.println(result);
	}
	
	public void plus3(int a) {
		long result = (long)(a + 3); // a+3 계산을 하고나서 형변환를 하기때문에 결국 형변환이 안된다
		System.out.println(result);
	}
	
	public void plus4(int a) {
		long result = (long)a + 3;    // a+3이 계산되기전에 먼저 a를 형변환을 시켜준다
		System.out.println(result);
	}
	
	// BigInteger: 엄청 큰/작은 정수
	// BigDecimal: 엄청 큰/작은 실수

}
