package kr.co.dwitt;

public class MainEx5 {

	public static void main(String[] args) {
		
		boolean isTrue = true;
		
		if(isTrue) {
			isTrue = false;
		}
		
		//if(isTrue == false) {
		//	isTrue = true;
		//}
		
		if(!isTrue) {
			isTrue = true;  // 위 코드보다 이 코드가 더 좋다
		}

	}
}
