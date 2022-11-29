package net.daum;

import com.naver.Account;

public class KimThread extends Thread {
	
	private Account account;
	
	public KimThread() {
		// TODO Auto-generated constructor stub
	}

	public KimThread(Account account) {
		super();
		this.account = account;
	}

	@Override
	public void run() {
		account.setBalance(10000);
	}

}
