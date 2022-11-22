package com.appl;

import java.io.Serializable;
import java.util.Objects;

public class MemberDTO extends Object implements Serializable{
	
	private static final long serserialVersionUID = 1L;
	
	private int id;
	private String name;
	
	public MemberDTO() {
		// TODO Auto-generated constructor stub
	}

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

	public static long getSerserialversionuid() {
		return serserialVersionUID;
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
		// TODO Auto-generated method stub
		System.out.println("hello");
		return super.toString();
	}

	
	
	

}
