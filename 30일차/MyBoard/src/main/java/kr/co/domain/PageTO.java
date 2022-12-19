package kr.co.domain;

import java.util.List;

public class PageTO<T> {
	// 독립변수
	private int perPage = 10;  // 한 페이지당 최대로 표현하할 수 있는 게시글의 수
	private int amount;        // 게시글 총 수
	private int curPage;	   // 현재 페이지
	private int lineMax = 10;  //  페이징 최대 표현 수
	
	// 종속변수
	private int totalPage;  // 페이징의 최댓값
	private int startNum;   
	private int endNum;		
	
	// 종속변수
	private List<T> list;
	
	// 종속변수
	private int beginPageNum;  // 시작페이지수
	private int finishPageNum; // 끝페이지수
	
	// 디폴트 생성자
	public PageTO() {
		curPage = 1;
		
		execute();
	}
	
	// 사용자 생성자 curPage만 체크
	public PageTO(int curPage) {
		super();
		this.curPage = curPage;
		
		execute();
	}

	public int getPerPage() {
		return perPage;
	}

	public void setPerPage(int perPage) {
		this.perPage = perPage;
		
		execute();
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
		
		execute();
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
		
		execute();
	}

	public int getLineMax() {
		return lineMax;
	}

	public void setLineMax(int lineMax) {
		this.lineMax = lineMax;
		
		execute();
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getStartNum() {
		return startNum;
	}

	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}

	public int getEndNum() {
		return endNum;
	}

	public void setEndNum(int endNum) {
		this.endNum = endNum;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public int getBeginPageNum() {
		return beginPageNum;
	}

	public void setBeginPageNum(int beginPageNum) {
		this.beginPageNum = beginPageNum;
	}

	public int getFinishPageNum() {
		return finishPageNum;
	}

	public void setFinishPageNum(int finishPageNum) {
		this.finishPageNum = finishPageNum;
	}
	
	private void execute() {
		totalPage = ((amount-1) / perPage) + 1;
		startNum = (curPage-1) * perPage + 1;
		endNum = curPage * perPage;
		if(endNum > amount){
			endNum = amount;
		}
		
		beginPageNum = ((curPage - 1) / lineMax) * lineMax + 1;
		finishPageNum = (((curPage-1) / lineMax) + 1) * lineMax;		
		if (finishPageNum > totalPage) {
			finishPageNum = totalPage;
		}
	}

}
