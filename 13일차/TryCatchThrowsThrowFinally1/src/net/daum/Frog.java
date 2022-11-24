package net.daum;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Frog {
	
	public void k1(int idx) {
		int[] arr = {100, 200};
		
		int num =  arr[idx];
		
		System.out.println(num);
	}
	
	public void k2(String msg) throws Exception {
		
		if(msg.equalsIgnoreCase("야이개새야")) {
			throw new Exception("욕설 금지");
		}
		
		
		System.out.println(msg);
	}
	
	public void k3(String msg) throws DoNotSwearException {
		
		if(msg.equalsIgnoreCase("야이개새야")) {
			throw new DoNotSwearException("욕설 금지");
		}
		
		
		System.out.println(msg);
	}

}
