package kr.co.dwitt;

import com.naver.Dog;

import net.daum.Cat;

public class MainEx {

	public static void main(String[] args) {
		// main 스레드의 영역 스코프
		System.out.println("메인 스레드 시작");
		
		Thread dog_t1 = new Dog(); // 스레드객체입니다.
		
		Runnable run_cat1 = new Cat(); // Runnable객체입니다.
		Thread cat_t1 = new Thread(run_cat1); // 스레드객체
		
		dog_t1.start();
		cat_t1.start();
		
		try {
			dog_t1.join();
			cat_t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("메인 스레드 종료");

	}

}
