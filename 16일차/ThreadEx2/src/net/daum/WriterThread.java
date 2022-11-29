package net.daum;

import com.naver.Board;

public class WriterThread extends Thread {
	
	public Board board;
	
	public WriterThread() {
		// TODO Auto-generated constructor stub
	}
	
	public WriterThread(Board board) {
		super();
		this.board = board;
	}

	@Override
	public void run() {
		board.setPost("지금 글을 등록했습니다. 재밌게 보세요");
	}
}
