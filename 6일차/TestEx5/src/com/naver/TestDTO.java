package com.naver;

import java.io.Serializable;
import java.util.Objects;

public class TestDTO implements Serializable {
	
	private static final long serialVersionUID = 10L;
	
	private int tid;
	private String tname;
	
	
	public TestDTO() {
		tid = 0;
		tname = "";
	}
	

	
	public TestDTO(int tid, String tname) {
		super();
		this.tid = tid;
		this.tname = tname;
	}


	public int getTid() {
		return tid;
	}



	public void setTid(int tid) {
		this.tid = tid;
	}



	public String getTname() {
		return tname;
	}



	public void setTname(String tname) {
		this.tname = tname;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	@Override
	public int hashCode() {
		return Objects.hash(tid, tname);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TestDTO other = (TestDTO) obj;
		return Objects.equals(tid, other.tid) && Objects.equals(tname, other.tname);
	}



	@Override
	public String toString() {
		return tid + tname;
	}
	
	
	
}
