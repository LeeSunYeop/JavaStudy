package com.google;

import java.util.Objects;

public class Weapon {
	private String id;
	private String name;
	private int attackPower;
	
	public Weapon() {
		// TODO Auto-generated constructor stub
	}

	public Weapon(String id, String name, int attackPower) {
		super();
		this.id = id;
		this.name = name;
		this.attackPower = attackPower;
	}
	
	public void attack() {
		System.out.println("공격합니다.");
	}
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAttackPower() {
		return attackPower;
	}

	public void setAttackPower(int attackPower) {
		this.attackPower = attackPower;
	}

	@Override
	public int hashCode() {
		return Objects.hash(attackPower, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Weapon other = (Weapon) obj;
		return attackPower == other.attackPower && Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Weapon [id=" + id + ", name=" + name + ", attackPower=" + attackPower + "]";
	}
	
	

}
