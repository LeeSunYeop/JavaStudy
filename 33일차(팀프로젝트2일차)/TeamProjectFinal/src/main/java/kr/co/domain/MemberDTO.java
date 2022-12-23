package kr.co.domain;

import java.io.Serializable;
import java.util.Objects;

public class MemberDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String mid;
	private String mpw;
	private String name;
	private String birth;
	
	public MemberDTO() {
		// TODO Auto-generated constructor stub
	}

	public MemberDTO(String mid, String mpw, String name, String birth) {
		super();
		this.mid = mid;
		this.mpw = mpw;
		this.name = name;
		this.birth = birth;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getMpw() {
		return mpw;
	}

	public void setMpw(String mpw) {
		this.mpw = mpw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
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
		return Objects.equals(mid, other.mid);
	}

	@Override
	public String toString() {
		return "MemberDTO [mid=" + mid + ", name=" + name + ", birth=" + birth + "]";
	}
			
}
