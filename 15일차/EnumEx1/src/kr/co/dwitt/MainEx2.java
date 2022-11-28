package kr.co.dwitt;

import net.daum.Animals;

public class MainEx2 {
	
	public static void main(String[] args) {
		Animals a = Animals.PIG;
		System.out.println(a);  // PIG
		
		boolean result = a.equals("PIG");
		System.out.println(result);  // false
		
		String name = a.name();
		System.out.println(name);  // PIG
		
		name = a.getName();
		System.out.println(name);  // 돼지
		
		Animals b = Animals.valueOf("CAT");  
		System.out.println(b);  // CAT
		name = b.name();
		System.out.println(name);  // CAT
		
		name = b.getName();
		System.out.println(name); // 고양이
	}

}
