package net.daum;

import java.util.Objects;

public class Animal {
	
	private String id;
	private String name;
	
	public Animal() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Animal(String id, String name) {
		super();
		this.id = id;
		this.name = name;
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
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animal other = (Animal) obj;
		return Objects.equals(id, other.id);
	}
	@Override
	public String toString() {
		return "Animal [id=" + id + ", name=" + name + "]";
	}
	
	public void eat() {
		System.out.println("먹습니다.");
	}

}
