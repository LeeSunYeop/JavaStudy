package kr.co.dwitt;

public class MainEx3 {

	public static void main(String[] args) {
		long a = System.currentTimeMillis();
		
		int sum = 0;
		
		for(int i=0; i<100; i++) {
			sum += i;
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println(sum);
		long b = System.currentTimeMillis();
		System.out.println(b-a);

	}

}
