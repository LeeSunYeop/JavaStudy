package kr.co.dwitt;

import com.naver.Cat;

import net.daum.Calculator;
import net.daum.Person;

public class MainEx {
	
	public static void main(String[] args) {
		
		Cat cat1 = new Cat();
		cat1.test(true);
		cat1.test2(34);
		
		Cat cat2 = new Cat();
		cat2.test3("철수");
		
		Calculator c1 = new Calculator();
		cat2.test4(c1);
		
		Cat cat3 = new Cat();
		cat3.setId(55);
		
		Person str1 = new Person();
		str1.say("철수");
	}

}
