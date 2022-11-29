package net.daum;

import com.naver.Account;

public class HongThread extends Thread {
	
	private Account account;
	
	public HongThread() {
		// TODO Auto-generated constructor stub
	}

	public HongThread(Account account) {
		super();
		this.account = account;
	}

	@Override
	public void run() {
		long balance = account.getBalance();
		System.out.println(balance);
	}

}
