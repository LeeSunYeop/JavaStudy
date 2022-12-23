package kr.co.domain;

import java.io.Serializable;
import java.util.Objects;

public class MemberDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int mid;
	private String password;
	private String name;
	private int age;
	
	public MemberDTO() {
		// TODO Auto-generated constructor stub
	}

	public MemberDTO(int mid, String password, String name, int age) {
		super();
		this.mid = mid;
		this.password = password;
		this.name = name;
		this.age = age;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(mid);
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
		return mid == other.mid;
	}

	@Override
	public String toString() {
		return "MemberDTO [mid=" + mid + ", password=" + password + ", name=" + name + ", age=" + age + "]";
	}
	
}
