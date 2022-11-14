package net.daum;

import com.naver.Cat;
import com.naver.Dog;

public class Person {
	
		private Dog dog1;
		private Calculator cal;
		private Cat cat1 = new Cat();
		private int id;
		private String name;
		
		// 유반환 유파람.
		// 유반환 무파람, 무반환 유파람을 합친거라고 생각하면된다
		public int plus(int a, int b){
			// 21억 + 21먹 = 42억 int에 들어갈 범위가 오버됨..오버플로우
			// -21억 + -21억 = -42억 언더플로우
			int result = a + b;
			
			return result;
		}
		
		// 유반환 유파람 , plus() 함수는 외부에서 정수 1개를 입력받아서
		// 그 정수에 +3을 한 값을 반환한다.
		public int plus(int a) {
			// 오버플로우 발생할 수 있어서 이 코드는 잘못됨
			// 이해를 돕기위해서 짠것임 
			int result = a + 3;
			return  result;
		}
		
		// 유반환 유파람 , say()함수는 이름을 입력하면, "안녕하세요, 입력한 이름"이 반환됩니다.
		// 자바에서는 문자열끼리 더하기 가능합니다
		public String say(String name) {
			String result = "안녕하세요, "+ name;
			return result;
		}
		
		// 유반환 유파람, 메서드명 catSetIdNName(), 새로운 id(int)와 새로운 name(String) 입력받아서
		// cat1의 id와 name을 수정합니다
		// 그런 후에 cat1을 반환합니다
		public Cat catSetIdNName(int a, String b){
			cat1.setId(a);
			cat1.setName(b);
			return cat1;
		}
		
		
	
		
		public Dog getDog1() {
			return dog1;
		}
		public void setDog1(Dog dog1) {
			this.dog1 = dog1;
		}
		public Calculator getCal() {
			return cal;
		}
		public void setCal(Calculator cal) {
			this.cal = cal;
		}
		public Cat getCat1() {
			return cat1;
		}
		public void setCat1(Cat cat1) {
			this.cat1 = cat1;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
		public Cat catSetIdNName(int c, int e, String d) {
			cat1.setId(c);
			cat1.setName(d);
			return cat1;
		}
		
		public void test(Cat a){
			
//		int h =	a.getId();
//		String i = a.getName();
//		String j =a.setName();
//		a.setId(id);
//		
//		a.getName(name);
//		a.setName(name);
//			
		}
}


		

























