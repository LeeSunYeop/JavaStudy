package com.naver;

public class Car {
	
	private String model;
	
	// 상수의 명명법: 다 대문자, 띄어쓰기하지 말고 띄어쓰는 글자 앞에 _를 넣으세요
	
	// private final String COMPANY_NAME;  // 값을 설정을 안해서 에러가 뜸
	private final String COMPANY_NAME = "hyunDai";
	
	public Car() {
		model = "sonata";  // 초기화
		
		model = "genesis"; // 대입
		
		// company = "yyy"; 상수이기때문에 값을 대입이 안된다고 오류가 뜬다
		
	}

	public Car(String model) {
		super();
		this.model = model;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getCOMPANY_NAME() {
		return COMPANY_NAME;
	}

	
}
