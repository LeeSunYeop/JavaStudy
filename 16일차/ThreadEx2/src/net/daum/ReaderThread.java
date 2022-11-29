package net.daum;

import com.naver.Board;

public class ReaderThread extends Thread {
	
	public Board board;
	
	public ReaderThread() {
		// TODO Auto-generated constructor stub
	}

	public ReaderThread(Board board) {
		super();
		this.board = board;
	}

	@Override
	public void run() {
		
		String post = board.getPost();
		System.out.println(post);
	}
}
