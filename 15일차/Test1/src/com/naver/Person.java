package com.naver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Person {
	private String id;
	private List<Dog> dogs;
	private Cat[] cat;
	
	public Person() {
		// TODO Auto-generated constructor stub
	}
	
	public Person(String id, List<Dog> dogs, Cat[] cat) {
		super();
		this.id = id;
		this.dogs = dogs;
		this.cat = cat;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Dog> getDogs() {
		return dogs;
	}

	public void setDogs(List<Dog> dogs) {
		this.dogs = dogs;
	}

	public Cat[] getCat() {
		return cat;
	}

	public void setCat(Cat[] cat) {
		this.cat = cat;
	}
	
	public Map<String, Cat> {
		String id;
		
		return id;
	}		

}
