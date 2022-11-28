package net.daum;

import com.naver.Sum;

public class CalThread extends Thread {
	
	public Sum s;
	
	int start;
	int end;
	
	public CalThread() {
		// TODO Auto-generated constructor stub
	}

	public CalThread(Sum s) {
		
		this.s = s;
	}
		
	public CalThread(Sum s, int start, int end) {
		super();
		this.s = s;
		this.start = start;
		this.end = end;
	}

	@Override
	public void run() {
		for(int i=start; i < end+1; i++) {
			s.plus(i);
		}
	}

}
