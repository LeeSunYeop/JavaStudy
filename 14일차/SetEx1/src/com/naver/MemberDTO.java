package com.naver;

import java.io.Serializable;
import java.util.Objects;

public class MemberDTO implements Serializable, Comparable<MemberDTO>{ // Comparable인터페이스임

	private static final long serialVersionUID = 1L;
	
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
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
		return id == other.id && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "MemberDTO [id=" + id + ", name=" + name + "]";
	}

//	@Override
//	public int compareTo(MemberDTO dto) {
//		// TODO Auto-generated method stub
//		return this.id - dto.getId();
//		//return (this.id - dto.getId())* (-1); 이렇게 짜면 id값이 큰값부터 출력된다
//	}
	
	@Override
	public int compareTo(MemberDTO dto) {
		// TODO Auto-generated method stub
		return this.name.compareTo(dto.getName()); // 가나다 순으로 출력이 됨 
		//return (this.name.compareTo(dto.getName()))* (-1); 이렇게 짜면 다나가 순으로 출력이 됨 
	}
	
	
	
	

}
