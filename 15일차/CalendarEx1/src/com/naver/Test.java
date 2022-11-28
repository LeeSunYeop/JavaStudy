package com.naver;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.text.html.HTMLDocument.HTMLReader.CharacterAction;

public class Test {
	
	public void me1() {
		// Calendar클래스 학습
		// cal
		Calendar cal = Calendar.getInstance(); // new Calendar(); 이코드는 안된다.
	}
	
	public void me2() {
		// Calendar클래스 이용해서 cal 객체 생성
		// sysout까지
		Calendar cal = Calendar.getInstance();
		System.out.println(cal);
	}
	
	public void me3() {
		// Calendar클래스 이용해서 cal 객체 생성
		Calendar cal = Calendar.getInstance();
		
		int year = cal.get(Calendar.YEAR);
		System.out.println(year);  // 2022
		
		// 월 정보 출력하기
		int month = cal.get(Calendar.MONTH);
		System.out.println(month+1);  // 11
		
		int[] months = {
				1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};		
		System.out.println(months[month]);  // 11
		
		int date = cal.get(Calendar.DATE);
		System.out.println(date);  // 28
		
		date = cal.get(Calendar.DAY_OF_MONTH);
		System.out.println(date);  // 28
		
		int day = cal.get(Calendar.DAY_OF_WEEK);
		System.out.println(day);  // 2
		
		int hour = cal.get(Calendar.HOUR);
		System.out.println(hour);  // 3   12시간으로 했을 때
		hour = cal.get(Calendar.HOUR_OF_DAY);
		System.out.println(hour);  // 15  24시간으로했을때
	}
	
	public void me4() {
		
		Calendar cal = Calendar.getInstance();
		Calendar cal2 = (Calendar) cal.clone();  // 처음 날짜 cal꺼 복사하기
		System.out.println(cal);
		
		cal.set(Calendar.YEAR, 2021);
		//System.out.println(cal);   // 년도, 월, 날짜 하나하나 set으로 바꿔줘야한다.
		
		cal.set(Calendar.MONTH, 9);
		System.out.println(cal);
		
		cal.clear();   // 전체 초기화 시키기
		System.out.println(cal);
		
		System.out.println(cal2);  // cal초기화 된걸 cal2 값을 대입을 받아 처음날짜로 바꿔준다
		cal = cal2; 
	}
	
	public void me5() {
		Calendar cal = Calendar.getInstance();
		Calendar cal2 = (Calendar) cal.clone();
		System.out.println(cal);
		
		cal.add(Calendar.DAY_OF_MONTH, 3);  // add 날짜더하기
		System.out.println(cal);
		
		cal = cal2;
	}
	
	public void me6() {
		Calendar cal = Calendar.getInstance();
		Calendar cal2 = (Calendar) cal.clone();
		
		System.out.println(cal);
		cal.roll(Calendar.DAY_OF_MONTH, 3);
		System.out.println(cal);
		
		cal = cal2;
	}
	
	public void me7() {
		//Calendar -> Date 로
		//Date -> Calendar 로
		
		Date date = new Date();
		System.out.println(date);
	}
	
	public void me8() {
		//Calendar -> Date 로
		Calendar cal = Calendar.getInstance();
		Date date1 = cal.getTime();		
		System.out.println(date1);
	}
	
	public void me9() {
		//Date -> Calendar 로
		Calendar cal = Calendar.getInstance();
		Calendar cal2 = (Calendar) cal.clone();
		
		Date date1 = new Date(0);
		System.out.println(date1);
		
		cal.setTime(date1);
		
		System.out.println(cal.get(Calendar.YEAR));
		
		cal = cal2;
		
	}
	
	public void me10() {
		Date date1 = new Date();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a HH"); 
		String str_date = sdf.format(date1);
		System.out.println(str_date);  // 2022-11-28 오후 16  16은 24시간 기준 시간을 나타냄 오후4시
	}                                  // 오전 오후는 a, 초는 ss, 분은 mm
	
	public void me11() throws Exception {
		// 문자열 -> Date -> Calendar
		String msg = "2022-10-10";
		System.out.println(msg); // 2022-10-10
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = sdf.parse(msg);  // parse 문자열을 해석하는 역할을 수행한다고 예측이 가능
		System.out.println(date1);   // Mon Oct 10 00:00:00 KST 2022
		
	}
	

}
