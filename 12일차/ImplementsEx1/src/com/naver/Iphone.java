package com.naver;

public abstract class Iphone extends Object implements Camera, PC, Phone{

	@Override
	public int senfMsg(String from, String to, String msg) {
		
		return 0;
	}
	
	@Override
	public void take() {
		// TODO Auto-generated method stub
		
	}
	
	public void play() {
		System.out.println("게임합니다.");
	}
	
	
}
