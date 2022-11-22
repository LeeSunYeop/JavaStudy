package com.google;

public class Cannon extends Weapon{
	
	public Cannon() {
		// TODO Auto-generated constructor stub
	}

	public Cannon(String id, String name, int attackPower) {
		super(id, name, attackPower);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void attack() {
		System.out.println("대포로 공격합니다.");
	}

	
}
