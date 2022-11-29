package kr.co.dwitt;

import com.naver.Account;

import net.daum.HongThread;
import net.daum.KimThread;

public class MainEx2 {

	public static void main(String[] args) {
		// 김유신 스레드가 account에 돈을 1만원 입금하고,
		// 홍길동 스레드에서는 account에 있는 잔액을 콘솔창에 출력하도록 해주세요
		// 반드시 홍길동 스레가 실행되면 콘솔에 1만원이 출력되어야 함
		
		Account account = new Account();
		
		HongThread ht = new HongThread(account);
		Thread kt = new KimThread(account);
		
		ht.start();
		kt.start();

	}

}
