package com.naver;

public class Account {
	private long balance;
	private boolean isOk;
	
	public Account() {}

	public Account(long balance) {
		super();
		this.balance = balance;
	}

	public long getBalance() {
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
		
		return balance;
	}

	public void setBalance(long balance) {
		this.balance = balance;
		isOk = true;
		
		synchronized (this) {
			notifyAll();
		}
	}

}
