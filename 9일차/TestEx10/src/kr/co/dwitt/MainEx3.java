package kr.co.dwitt;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MainEx3 {

	public static void main(String[] args) {
		// 배열 깊은 복사하는 방법
		int[] arr = {1, 2, 3, 4};
		
		int[] arr_c1 = arr.clone();  // 별개로 배열객체가 만들어 진다
		
		arr_c1[0] = 100;
		
		System.out.println(arr_c1[0]);  // 출력 100
		
		System.out.println(arr[0]);     // 출력 1
		// 서로 다른 객체를 가지고 있다는거..
		
		System.out.println(":::::::::::");
		
		int[] arr_c2 = Arrays.copyOf(arr, arr.length);
		arr_c2[0] = 200;
		System.out.println(arr_c2[0]);  // 200나옴
		System.out.println(arr[0]);    // 1 나옴
		
		System.out.println(":::::::::::");
		
		int[] arr_c3 = Arrays.copyOfRange(arr, 1, 3);  // 일부만 복사하고 싶을 때
		for(int i=0; i<arr_c3.length; i++) {
			
			System.out.println(arr_c3[i]);
		}
	}

}
