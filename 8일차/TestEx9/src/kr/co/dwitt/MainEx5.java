package kr.co.dwitt;

public class MainEx5 {

	public static void main(String[] args) {
		// 7, 8, 11, 16, 23, 32, 43...100보다 작은 값이 나올 떄까지
		// 숫자들을 더하기 하세요..
		// 0, 1,  4   9  16   i*i +7 
	
		int sum = 0;
		int i = 0;
		int num = 0;
	
		while(num < 100) {
			num = i*i + 7;
			sum = sum + num; // sum += num;
		
			++i;
		}
		System.out.println(num);
		System.out.println(sum);
	
	}
}
