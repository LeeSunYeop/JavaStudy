package kr.co.dwitt;

import com.naver.Sum;

import net.daum.CalThread;

public class MainEx5 {

	public static void main(String[] args) {
		
		Sum s = new Sum();
		
		CalThread t1 = new CalThread(s, 0, 5000);
		CalThread t2 = new CalThread(s, 5001, 10000);
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(s.num1);
	}

}
