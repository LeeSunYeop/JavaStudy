package kr.co.dwitt;

import com.naver.TurtleThread;

public class MainEx7 {
	
	public static void main(String[] args) {
		// 대몬스레드: 메인스레드가 dead가 되면, 해당 스레드도 dead가 되는 스레드
		
		Thread t2 = new TurtleThread();
		t2.setDaemon(true);  // 대몬스레드가 되어짐 setDaemon, start하고 순서가 바뀌면 안된다
		t2.start();
		
		for(int i=0; i<100; i++) {
			System.out.println("main: "+i);
		}
		
	}

}
