package kr.co.dwitt;

import com.naver.Dog;

import net.daum.Cat;

public class MainEx2 {

	public static void main(String[] args) {
		System.out.println("메인 스레드 시작");
		
		Thread ct = Thread.currentThread();
		String name = ct.getName();
		System.out.println(name);  // main
		
		// Dog 클래스를 이용해서 dog_t2
		// Cat 클래스를 이용해서 cat_t2
		// 스레드를 만들어 주세요
		Dog dog_t2 = new Dog();
		
		Cat run_cat2 = new Cat();   // 이 방법이 실무에서 많이 쓰인다.
		Thread cat_t2 = new Thread(run_cat2);		
		
		dog_t2.start();
		cat_t2.start();
		
		try {
			dog_t2.join();
			cat_t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("메인 스레드 종료");

	}

}
