package com.naver;

import javax.activation.CommandInfo;

import net.daum.Cat;
import net.daum.Command;

public class Dog {
	
	private int id;
	
	public class Test {
		private int score;
		
		public Test() {}

		public Test(int score) {
			super();
			this.score = score;
		}

		public int getScore() {
			return score;
		}

		public void setScore(int score) {
			this.score = score;
		}
		
	}

	public static class Test2{
		public void me1() {
			System.out.println("static");
		}
	}
	
	public static class Test3{
		private static int a;
	}
	
	public void sleep() {  // 로컬내부클래스
		 class Born{
			private int bid;
			 
			public Born() {
				// TODO Auto-generated constructor stub
			}

			public Born(int bid) {
				super();
				this.bid = bid;
			}
			 
		 }
		 
		 Born b = new Born();
	}
	
	public Command com1 = new Command() {
		
		@Override
		public void ex1() {
			System.out.println("익명의 내부클래스");
			
		}
	};
	
	public void eat() {  // 익명의 내부클래스

		new Command() {  
			
			@Override
			public void ex1() {
				// TODO Auto-generated method stub
				
			}
		}.ex1();  // 변수명도 없는 메서드 호출할때 .ex1(); 코드를 짠다.
		
		
		
		new Cat() {

			@Override
			public void attact() {
				// TODO Auto-generated method stub
				
			}			
		}.attact();  // 변수명도 없는 메서드 호출할때 .attact();  코드를 짠다.
	}
		
	

	
	
	

}
