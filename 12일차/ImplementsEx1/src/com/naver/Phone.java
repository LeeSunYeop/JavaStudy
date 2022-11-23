package com.naver;

public interface Phone {
	public static final int PRICE = 100;
	
	public abstract int senfMsg(String from, String to, String msg);
}
