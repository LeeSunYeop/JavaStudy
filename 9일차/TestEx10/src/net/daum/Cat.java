package net.daum;

public class Cat {
	
	public void w1() {
		int[][] arr = {
				{1, 2},
				{3, 4},
				{5, 6}
		};
		
		System.out.println(arr.length);
	}
	
	public void w2() {
		boolean[][][][][][][][][][] arr = new boolean[2][3][2][5][3][2][3][1][3][8];
		System.out.println(arr.length);
	}
	
	public void w3() {
		char[][] arr = {
				{'a', 'b', 'c', 'd'},
				{'A', 'B', 'C', 'D'}
		};
		
		System.out.println(arr.length);
		System.out.println(":::::::::::::");
		
		for(int i=0; i<arr.length; i++) {
			
			char[] arr11 = arr[i];
			
			for(int j=0; j<arr[i].length; j++) {
				//char c = arr[i][j];  // 방법1
				//System.out.println(c);
				
				w4(arr[i]);   // 방법2
			}
		}	
	}
	
	public void w4(char[] arr) {
		
		//char[] arr11 = arr[i];
		
		for(int j=0; j<arr.length; j++) {
			char c = arr[j];
			System.out.println(c);
		}
	}
	
	public void w5() {
		String msg = "m001#1234#kim#vip#10000000";
		
		String[] arr = msg.split("#");  // #을 구분지어서 배열을 짠다
		
		for(int i=0; i<arr.length; i++) {
			String token = arr[i];
			System.out.println(token); // 출력 m001 1234 kim vip 10000000 나옴
		}
		
	}
		
	

}
