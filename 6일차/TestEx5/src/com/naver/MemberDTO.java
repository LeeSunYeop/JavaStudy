package com.naver;

import java.util.Date;

public class MemberDTO {
	
	private String id;
	private String name;
	private String address;
	private Date birthday;
	
	// 디폴트 생성자와 사용자 생성자를 만들어 주세요
	public MemberDTO() {
		id = "";
		name = "";
		address = "";
		birthday = new Date(1111L);
		
	}
	
	public MemberDTO(String id, String name, String address, Date birthday) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.birthday = birthday;
				
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
}
