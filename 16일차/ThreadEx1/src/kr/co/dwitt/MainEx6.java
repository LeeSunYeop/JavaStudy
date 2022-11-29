package kr.co.dwitt;

import com.naver.TurtleThread;

public class MainEx6 {

	public static void main(String[] args) {
		// 대몬스레드: 메인스레드가 dead가 되면, 해당 스레드도 dead가 되는 스레드
		
		Thread t1 = new TurtleThread();
		t1.start();
		
		for(int i=0; i<100; i++) {
			System.out.println("main: "+i);
		}

	}

}
