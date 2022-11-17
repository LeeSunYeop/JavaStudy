package kr.co.dwitt;

public class MainEx3 {

	public static void main(String[] args) {
		// 0~10까지의 합을 구하시오
		// 가장 적합한 반복문을 사용하시오
		
		int sum = 0;
		int i = 0;
		while(i < 11) {
			sum = sum + i;
			System.out.println(sum);
			++i;
		}
		
		int sum1 = 0;		
		for(int j = 0; j < 11; j++) {
			sum1 = sum1 + j;
			// sum1 = 0 + 0, sum1 = 0+1, sum1 = 0+1+2, sum1 = 0+1+2+3...
		}
		System.out.println(sum1);

	}

}
