package com.naver;

public class Board {
	
	public String post;
	boolean isOk; // false 상태임
	
	public Board() {}

	public Board(String post) {
		super();
		this.post = post;
	}

	public String getPost() {
		if(!isOk) { 
			synchronized (this) {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
		return post;
	}

	public void setPost(String post) {
		this.post = post;
		isOk = true; //라이트스레드가 먼저 접근했을 때
		
		synchronized (this) {
			notifyAll();
		}
	}

}
