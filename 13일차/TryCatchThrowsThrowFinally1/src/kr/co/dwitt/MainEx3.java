package kr.co.dwitt;

import net.daum.Cat;

public class MainEx3 {

	public static void main(String[] args) {
		Cat cat1 = new Cat();
		//cat1.me1();
		//cat1.me2();  //하면 오류메시지가 뜬다.  throws를 없애든지 try~catch를 하던지 방법을 제시한다.
		try {
			cat1.me2();
		} catch (Exception e) {
			System.out.println("시스템에 문제가 발생했습니다. 빠른 조치를 하겠습니다.");
			e.printStackTrace();
		}
		
		Thread t = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		});
		
		t.start();
		
		try {
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
