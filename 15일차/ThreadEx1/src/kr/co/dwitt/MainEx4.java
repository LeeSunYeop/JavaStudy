package kr.co.dwitt;

import com.naver.SumThread;

public class MainEx4 {

	public static void main(String[] args) {
		
		SumThread t1 = new SumThread(0, 500);
		SumThread t2 = new SumThread(501, 1000);
		
		t1.start();
		t2.start();

	}

}
