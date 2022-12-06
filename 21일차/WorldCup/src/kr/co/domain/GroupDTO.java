package kr.co.domain;

import java.io.Serializable;
import java.util.Objects;

public class GroupDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String gname;   //조별이름
	private String ctyname; // 국가이름
	private String hcname;  // 감독이름
	
	public GroupDTO() {
		// TODO Auto-generated constructor stub
	}

	public GroupDTO(int id, String gname, String ctyname, String hcname) {
		super();
		this.id = id;
		this.gname = gname;
		this.ctyname = ctyname;
		this.hcname = hcname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public String getCtyname() {
		return ctyname;
	}

	public void setCtyname(String ctyname) {
		this.ctyname = ctyname;
	}

	public String getHcname() {
		return hcname;
	}

	public void setHcname(String hcname) {
		this.hcname = hcname;
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
		GroupDTO other = (GroupDTO) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "MemberDTO [id=" + id + ", ctyname=" + ctyname + ", hcname=" + hcname + ", gname=" + gname + "]";
	}

}
