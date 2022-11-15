package com.naver;

import java.io.Serializable;
import java.util.Objects;

public class ItemDTO implements Serializable{

	private static final long serialVersionUID = 5L;
	
	private int id;
	private String name;
	private boolean isSoldout;
	
	
	
	public ItemDTO() {
		id = 10000;
		name = "사과";
		isSoldout = true;
	}
	
	public ItemDTO(int id, String name, boolean isSoldout) {
		super();
		this.id = id;
		this.name = name;
		this.isSoldout = isSoldout;
	}
	
	public boolean isSoldout() {
		return isSoldout;
	}
	public void setSoldout(boolean isSoldout) { //is를 사용할경우 get이 아닌 set으로 나온다는거 알아두기
		this.isSoldout = isSoldout;
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
		ItemDTO other = (ItemDTO) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return name;    // sysout 햇을때 이상한 값 나오지않게 해주세요..
	}
	
	
}
