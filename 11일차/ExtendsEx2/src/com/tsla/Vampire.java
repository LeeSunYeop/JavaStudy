package com.tsla;

public class Vampire extends User{
	private int str;
	
	public Vampire() {
		
	}

	public Vampire(String id, String name, int hp, int str) {
		super(id, name, hp);
		this.str = str;
		
	}
	
	

}
