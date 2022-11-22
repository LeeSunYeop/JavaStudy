package com.google;

import java.util.Objects;

public class Gun extends Weapon{
	
	public Gun() {
		// TODO Auto-generated constructor stub
	}

	public Gun(String id, String name, int attackPower) {
		super(id, name, attackPower);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void attack() {
		System.out.println("권총으로 공격합니다.");
	}		
}
