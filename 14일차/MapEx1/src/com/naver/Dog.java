package com.naver;

public class Dog {
	
	private MemberDTO dto;
	
	public Dog() {
		// TODO Auto-generated constructor stub
	}

	public Dog(MemberDTO dto) {
		super();
		this.dto = dto;
	}

	public MemberDTO getDto() {
		return dto;
	}

	public void setDto(MemberDTO dto) {
		this.dto = dto;
	}

}
