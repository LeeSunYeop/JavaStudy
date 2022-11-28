package com.naver;

public class SumThread extends Thread {
	
	private int sum;
	private int start;
	private int end;
	
	public SumThread() {
		// TODO Auto-generated constructor stub
	}

	public SumThread(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}

	@Override
	public void run() {
		for(int i=start; i < end+1; i++) {
			sum += i;
		}
		
		System.out.println(sum);
	}

}
