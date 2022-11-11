package kr.co.dwitt;

public class MainEx2 {

	public static void main(String[] args) {
		
		// Wrapper 클래스
		// 기본자료형으로 객체를 못 만듦.
		// 객체에게만 유용한 기능을 제공해주는 클래스들이 있음.
		// java collection framework..
		// 기본자료형은 jcf에 집어 넣을 수 없습니다.
		// Wrapper 클래스가 만들어 집니다.
		// 기본자료형을 이용해서 객체를 만들 수 있게 하기 위해서 Wrapper 클래스가 만들어짐.
		// boolean -> Boolena
		// char -> Character----
		// byte -> Byte
		// short -> Short
		// int -> Integer----
		// long -> Long
		// float -> Float
		// double -> Double
		
		String msg1 = "true";
		boolean a = Boolean.parseBoolean(msg1);
		System.out.println(a);
		
		String msg2 = "-128";
		byte b = Byte.parseByte(msg2);  
		System.out.println(b);
		
		String msg3 = "-129";
		short c = Short.parseShort(msg3);
		System.out.println(c);
		
		String msg4 = "2100000000";
		int d = Integer.parseInt(msg4);
		System.out.println(d);
		
		String msg5 = "3000000000";
		long e = Long.parseLong(msg5);
		System.out.println(e);
		
		String msg6 = "3.14F";
		float f = Float.parseFloat(msg5);
		System.out.println(f);
		
		String msg7 = "9.8";
		double g = Double.parseDouble(msg7);
		System.out.println(g);
		
		String msg8 = "c";
		char h = msg8.charAt(0);  // char만 조심하면 된다
		System.out.println(h);
		
		

	}

}
