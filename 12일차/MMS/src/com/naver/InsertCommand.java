package com.naver;

import java.util.Scanner;

import kr.co.dwitt.Command;

public class InsertCommand implements Command{

	@Override
	public boolean execute(Scanner sc) {
		// TODO Auto-generated method stub
		
		System.out.println("입력 기능");
		
		System.out.println("이름을 입력하세요");
		String name = sc.nextLine();
		
		return true;
		
	}

	@Override
	public String toString() {
		return "입력";
	}
	
	

}
