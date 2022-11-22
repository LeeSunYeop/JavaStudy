package com.tsla;

public class Outsterz extends User{
	private int str;
	
	public Outsterz() {
		
	}

	public Outsterz(String id, String name, int hp) {
		super(id, name, hp);
		
	}
	
	public Outsterz(String id, String name, int hp, int str) {
		super(id, name, hp);
		this.str = str;
		
	}
	
}
