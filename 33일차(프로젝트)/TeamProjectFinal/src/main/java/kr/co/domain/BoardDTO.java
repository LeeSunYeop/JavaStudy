package kr.co.domain;

import java.io.Serializable;
import java.util.Objects;

public class BoardDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int num;
	private String bid;
	private String title;
	private String content;
	private int pw;
	private String writeday;
	private int readcnt;
	private int repRoot;
	private int repStep;
	private int repIndent;
	
	public BoardDTO() {
	
	}

	public BoardDTO(int num, String bid, String title, String content, int pw, String writeday, int readcnt,
			int repRoot, int repStep, int repIndent) {
		super();
		this.num = num;
		this.bid = bid;
		this.title = title;
		this.content = content;
		this.pw = pw;
		this.writeday = writeday;
		this.readcnt = readcnt;
		this.repRoot = repRoot;
		this.repStep = repStep;
		this.repIndent = repIndent;
	}

	public BoardDTO(int num, String bid, String title, String writeday, int readcnt, int repRoot, int repStep,
			int repIndent) {
		super();
		this.num = num;
		this.bid = bid;
		this.title = title;
		this.writeday = writeday;
		this.readcnt = readcnt;
		this.repRoot = repRoot;
		this.repStep = repStep;
		this.repIndent = repIndent;
	}

	public BoardDTO(int num, String bid, String title, String content, int pw, int readcnt) {
		super();
		this.num = num;
		this.bid = bid;
		this.title = title;
		this.content = content;
		this.pw = pw;
		this.readcnt = readcnt;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getBid() {
		return bid;
	}

	public void setBid(String bid) {
		this.bid = bid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getPw() {
		return pw;
	}

	public void setPw(int pw) {
		this.pw = pw;
	}

	public String getWriteday() {
		return writeday;
	}

	public void setWriteday(String writeday) {
		this.writeday = writeday;
	}

	public int getReadcnt() {
		return readcnt;
	}

	public void setReadcnt(int readcnt) {
		this.readcnt = readcnt;
	}

	public int getRepRoot() {
		return repRoot;
	}

	public void setRepRoot(int repRoot) {
		this.repRoot = repRoot;
	}

	public int getRepStep() {
		return repStep;
	}

	public void setRepStep(int repStep) {
		this.repStep = repStep;
	}

	public int getRepIndent() {
		return repIndent;
	}

	public void setRepIndent(int repIndent) {
		this.repIndent = repIndent;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

	@Override
	public int hashCode() {
		return Objects.hash(bid, num);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BoardDTO other = (BoardDTO) obj;
		return Objects.equals(bid, other.bid) && num == other.num;
	}

	@Override
	public String toString() {
		return "BoardDTO [num=" + num + ", bid=" + bid + ", title=" + title + "]";
	}
	
	

}
