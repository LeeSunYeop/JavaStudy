package com.naver;

public class Box<T> {
	private T type;
	
	public Box() {
		// TODO Auto-generated constructor stub
	}

	public Box(T type) {
		super();
		this.type = type;
	}

	public T getType() {
		return type;
	}

	public void setType(T type) {
		this.type = type;
	}

}
