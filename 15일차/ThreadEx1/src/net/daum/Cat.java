package net.daum;

// Cat클래스가 Runnable 인터페이스를 구현하도록 하세요.
public class Cat implements Runnable {  // Runnable클래스
	
	@Override
	public void run() {
		// 사용자 스레드 중에서 Cat클래스로 만들어진
		// 사용자 스레드의 영역
		System.out.println("캣 사용자 스레드 실행");
		
		Thread ct = Thread.currentThread();
		String name = ct.getName();
		System.out.println(name);  // Thread-1
	}

}
