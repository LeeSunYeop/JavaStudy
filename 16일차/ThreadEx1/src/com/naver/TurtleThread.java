package com.naver;

public class TurtleThread extends Thread {

	@Override
	public void run() {
		for(int i=0; i<100; i++) {
			System.out.println(i);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}	
}
