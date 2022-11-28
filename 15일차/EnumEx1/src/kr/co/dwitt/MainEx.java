package kr.co.dwitt;

import com.naver.Weapon;

public class MainEx {

	public static void main(String[] args) {
		Weapon w = Weapon.TANK;
		
		System.out.println(w); // TANK
		
		boolean result = w.equals("TANK");
		System.out.println(result);  // false
		String w_name = w.name();  // w.name(); enum의 값을 문자로 변경할 때
		System.out.println(w_name); // TANK
		
		result = w_name.equals("TANK");
		System.out.println(result);  // true
		
		// 문자열을 이용해서 enum 생성
		Weapon newTest = Weapon.valueOf("GUN");
		System.out.println(newTest);  // GUN
		
		newTest = Weapon.valueOf("TANK");
		
		result = w.equals(newTest);
		System.out.println(result);  // true
	}

}
