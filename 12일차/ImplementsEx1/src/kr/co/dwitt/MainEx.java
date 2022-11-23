package kr.co.dwitt;

import com.naver.Iphone;
import com.naver.Phone;
import com.naver.SmartPhone;

public class MainEx {

	public static void main(String[] args) {
		Phone gal = new Iphone(); 
		
		//gal.play(); 인식이 안되서 오류뜸
		
		Iphone gal10 = null;
		if(gal10 instanceof Iphone) {
			gal10 = (Iphone)gal10;
			gal10.play();
		}
	}
}
