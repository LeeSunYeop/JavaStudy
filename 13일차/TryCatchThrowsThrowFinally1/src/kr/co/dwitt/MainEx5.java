package kr.co.dwitt;

import net.daum.Frog;

public class MainEx5 {

	public static void main(String[] args) {
		Frog frog1 = new Frog();
		
		//frog1.k1(1000);
		//frog1.k2("안녕하세요.");
		try {
			frog1.k2("야이개새야");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			frog1.k3("야이개새야");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
