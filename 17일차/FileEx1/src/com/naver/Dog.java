package com.naver;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.Date;

public class Dog {
	
	public void me1() {
		// File 클래스
		// directory(=folder), file
		// directory 생성, 삭제
		// file 삭제
		// f는 파일이 아닙니다.
		// f는 파일객체입니다.
		File f = new File("C:"+File.separator+"AAA");
		
		f.mkdir();  // 폴더 AAA가 생성된다
	}				// mkdir 는 make디렉토리
	
	public void me2() {
		File f = new File("C:"+File.separator+"AAA");
		
		if(!f.exists()) {  // 실무에선 이렇게 코드를 짠다.
			f.mkdir();
		}
		
	}
	
	public void me3() {
		// File 클래스로 파일 생성은 안된다.
		File f = new File("C:"+File.separator+"a500.txt");
		
		if(!f.exists()) {  
			try {
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void me4() {   // 폴더생성하고 폴더안에 또 폴더 생성하기
		// Calendar 객체 생성하시오
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1;
		int date = cal.get(Calendar.DATE);
		
		File f1 = new File("C:", ""+year);
		if(!f1.exists()) {
			f1.mkdir();  // 2022폴더가 생성됨
		}
		
		File f2 = new File(f1, month+"");
		if(!f1.exists()) {
			f2.mkdir();  // 2022폴더안에 11이 생성됨
		}
		
		File f3 = new File(f2, date+"");
		if(!f3.exists()) {
			f3.mkdir();  // 2022폴더안에 11폴더 안에 30폴더 생성됨
		}
	}
	
	public File me5() { // me6에 파일 저장하기 위해서 File 씀
		Calendar cal = Calendar.getInstance();
		
		Calendar cal2 = (Calendar) cal.clone();
		cal.add(Calendar.DATE, 1);
		System.out.println(cal); // 1을 더한 날짜 폴더가 생성됨
		
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1;
		String s_month = String.format("%02d", month); 
		// %02d d는 정수, s는 string, f는 실수,  2는 두자리 를 뜻함, %는 값을 입력하겠다는 의미임
		
		int date = cal.get(Calendar.DATE);
		String s_date = String.format("%02d", date);
		
		File f1 = new File("C:", ""+year);
		if(!f1.exists()) {
			f1.mkdir();  
		}
		
		File f2 = new File(f1, s_month);
		if(!f1.exists()) {
			f2.mkdir();  
		}
		
		File f3 = new File(f2, s_date);
		if(!f3.exists()) {
			f3.mkdir();  
		}
		
		cal = cal2;
		
		return f3;  // 날짜꺼 파일 객체 반환
	}
	
	public void me6() {
		File f1 = me5();
		
		String path = f1.getAbsolutePath();
		System.out.println(path.substring(2));  //path -> C:\2022\12\01 이렇게 나옴
		// path.substring(2) -> \2022a\12\01 나옴 C: 코드가 삭제됨
	}
	
	public void me7() {
		File f = new File("C:"+File.separator+"test100.txt");
		if(f.exists()) {  // 파일 삭제하기
			f.delete();   // test100.txt 삭제됨
		}
	}
	
	public void me8() {
		File f = new File("C:"+File.separator+"a200.txt");
		
		String path = f.getAbsolutePath();
		System.out.println(path);  // C:\a200.txt 확장자가 붙은 파일명까지 나옴 
	}
	
	public void me9() {
		File f = new File("."); // .은 현재 디렉토리를 말함
		
		String[] arr = f.list();
		
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
//			.classpath
//			.project
//			.settings
//			bin
//			src	     파일명이 나온다
		}
		
		System.out.println(">>>>>>>>>>>");
		System.out.println(f.getName());  // . 나옴
		System.out.println(f.getAbsolutePath());
		// D:\java\workspace_java\FileEx1\. 나옴 
	}
	
	public void me10() {
		File f = new File("C:", "test.jpg");
		//System.out.println(f.getName());  // test.jpg나옴
		//System.out.println(f.length());  // 8396916 8메가정도 나온다.
		long size = f.length();
		long ori = size;
		
		File f2 = new File("C:", "zzz.jpg");
		InputStream in = null;
		BufferedInputStream bis = null;
		
		OutputStream out = null;
		BufferedOutputStream bos = null;
		
		try {
			in = new FileInputStream(f);
			bis = new BufferedInputStream(in);
			
			out = new FileOutputStream(f2);
			bos = new BufferedOutputStream(out);
			
			byte[] arr = new byte[1024];
			int len = -1;
			
			while((len = bis.read(arr)) != -1) {
				bos.write(arr, 0, len);
				
				size = size - len;
				System.out.println((size*100)/ori+" 만큼 남았습니다.");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {	
			try {
				bis.close();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
			try {
				in.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			try {
				bos.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
						
			try {
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		f.delete();

	}

}
