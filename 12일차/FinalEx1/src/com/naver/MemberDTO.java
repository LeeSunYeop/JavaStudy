package com.naver;

import java.io.Serializable;
import java.util.Objects;

public class MemberDTO extends Object implements Serializable{

	private static final long serialVersionUID = 1L;
	// final 붙으면 상수가 됨.. 항상 같은값이란 의미
	// 상수는 값을 수정할 수 없다.
	
	private int id;
	private String name;
	
	public MemberDTO() {}

	public MemberDTO(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MemberDTO other = (MemberDTO) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "MemberDTO [id=" + id + ", name=" + name + "]";
	}

}
