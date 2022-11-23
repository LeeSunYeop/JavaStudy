package kr.co.dwitt;

import com.naver.Dog;

public class MainEx {

	public static void main(String[] args) {
		
		
		Dog.Test test1 = new Dog().new Test();
		
		System.out.println(test1.getScore());
		
		System.out.println("::::::::::");
		
		Dog.Test2 test2 = new Dog.Test2();
		test2.me1();
		
		Dog dog1 = new Dog();
		dog1.com1.ex1();
		
		
		new Thread(new Runnable() { // 쓰레드안에 익명의 내부클래스가 있다
			
			@Override
			public void run() {
				System.out.println("안녕1");
				
			}
		}).start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("안녕2");
				
			}
		}).start();
		
		
		new Thread(new Runnable() { 
			
			@Override
			public void run() {
				System.out.println("안녕3");
				
			}
		}).start();
		
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("안녕4");
				
			}
		}).start();

	}

}
