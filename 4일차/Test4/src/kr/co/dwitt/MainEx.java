package kr.co.dwitt;

import com.naver.Test;

public class MainEx {
	
	public static void main(String[] args) {
		
		
		// 큰 자료형에서 작은 자료형으로 형변환
		Test t = new Test();
		// 강제 형변환
		t.me1((byte)0); // 방법1 --- 일반적으로 이 방법을 사용함
		
		// 정수형의 기본자료형은 int
		// 3의 자료형은? int
		// int형의 3이 자동으로 byte의 3으로 형변환 됐음.
		byte a = 3;
		t.me1(a);  //방법2
		
		// 작은 자료형에서 큰 자료형으로 형변환
		// int형인 44가 long형인 44로 자동 형변환
		long b = 44;
		// long 을 쓰면 뒤에 L을 써야되는데 자동 형변환되서 L을 안쓴다
		t.me2(44);
		
		t.me3((float)3.4); // --> 요방법은 큰 자료형을 작은 자료형으로 강제형변환하는 것으로 어쩔수 없을 때 사용한다
		t.me3(3.4F);
		
		t.plus(Integer.MAX_VALUE);
		
		t.plus2(Integer.MAX_VALUE);
		
		t.plus3(Integer.MAX_VALUE);
		
		t.plus4(Integer.MAX_VALUE);
		
		
		
	}

}
