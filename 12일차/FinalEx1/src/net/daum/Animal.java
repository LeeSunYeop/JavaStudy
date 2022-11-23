package net.daum;

public abstract class Animal {
	
	public void sleep() {
		System.out.println("잡니다.");
	}
	
	public abstract void eat(); // 반드시 오버라이딩해야함
	
	public final void run() {  // 메서드에 final이 붙으면 자식클래스에서는 절대로 오버라이딩을 하면 안됨
		System.out.println("달립니다.");
	}

}
