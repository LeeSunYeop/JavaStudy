package net.daum;

public enum Animals {
	PIG("돼지"), CAT("고양이"), DOG("개"); // 값을 적어줄 때는 ; 을 넣어준다.
	
	private final String name;
	
	private Animals(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
		
}
