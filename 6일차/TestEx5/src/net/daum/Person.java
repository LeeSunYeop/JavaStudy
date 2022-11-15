package net.daum;

public class Person {
	
	private String id;
	private String name;
	private Cat cat;
	
	public Person() {
		id = "m001";
		name = "홍길동";
		cat = new Cat();
	}
	
	public Person(String a, String b, Cat c) {
		this.id = id;
		this.name  = name;
		this.cat = cat;
		
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
	public Cat getCat() {
		return cat;
	}
	public void setCat(Cat cat) {
		this.cat = cat;
	}

}
