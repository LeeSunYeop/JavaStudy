package com.naver;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.omg.CosNaming._BindingIteratorStub;

public class Dog {
	
	public void me1() {   // 출력하기
		OutputStream out = null;
		
		try {
			
			out = new FileOutputStream("C://a.txt"); // 그림판에서 했던 검정색 화살표가 생성됨
			
			out.write('a');   // 메모장에다 출력할 값을 적어준다.
			out.write('\n');
			out.write('d');
					
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void me2() {  // 읽어오기
		// C://a.txt 파일에 있는 데이터를 읽어와서 콘솔창에 출력하세요
		InputStream in = null;
		
		try {
			in = new FileInputStream("C://a.txt");
			
			int what = -1;   
		  //int what = in.read();
			
			while((what = in.read()) != -1) { // (what = in.read())이게 what이다
				
				System.out.println((char)what);
			}
			
//			while(true) {  //반복문에 if문 있으면 속도가 느려져 위에 코드처럼 짜야한다.
//				what = in.read();
//				if(what == -1) {
//					break;
//				}
//				System.out.println((char)what);
//			}
//			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}  
	}
	
	public void me3() {
		// C://a.txt 파일을 이용해서 파일 복사를 합니다.
		// 복사본 파일명을 C://b.txt
		// me1()메서드의 내용과 me2()메서드의 내용을 조합해서 만드세요
		InputStream in = null;
		OutputStream out = null;
		
		try {
			
			in = new FileInputStream("C://a.txt");
			out = new FileOutputStream("C://b.txt");
			
			int what = -1;
			
			while((what = in.read()) != -1) {
				out.write(what);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void me4() {
		// test.jpg 파일을 test2.jpg 파일로 복사하세요
		// 복사를 완료하는데 걸리는 시간도 측정하세요
		long a = System.currentTimeMillis();
		InputStream in = null;
		OutputStream out = null;
		
		try {
			in = new FileInputStream("C://test.jpg");
			out = new FileOutputStream("C://test2.jpg");
			
			int what = -1;
			
			while((what = in.read()) != -1) {
				out.write(what);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		long b = System.currentTimeMillis();
		System.out.println(b-a);
		
	}
	
	public void me5() {
		long a = System.currentTimeMillis();
		
		InputStream in = null;
		BufferedInputStream bis = null;  // BufferedInputStream 은 자바프로그램에 가깝기때문에 속도를 빠르게 해준다.
											
		OutputStream out = null;
		BufferedOutputStream bos = null;
		
		try {
			in = new FileInputStream("c://test.jpg");
			bis = new BufferedInputStream(in);
			
			out = new FileOutputStream("c://test3.jpg");
			bos = new BufferedOutputStream(out);
			
			int what = -1;
			
			while((what = bis.read()) != -1) {

				bos.write(what);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				bis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  // InputStream / BufferedInputStream 같이 쓰일때는 close 순서가 중요함
			
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				bos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		long b = System.currentTimeMillis();
		System.out.println(b-a);
	}
	
	public void me6() {
		long a = System.currentTimeMillis();
		
		InputStream in = null;
		OutputStream out = null;
		
		try {
			in = new FileInputStream("c://test.jpg");
			out = new FileOutputStream("c://test5.jpg");
			
			byte[] arr = new byte[1024];
			int len = -1;
			
			while((len = in.read(arr)) != -1) {
				 // len는 몇개 읽어왔는지 알수있다.
				
				out.write(arr, 0, len);
			}						
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {				
				e.printStackTrace();
			}
			
			try {
				out.close();
			} catch (IOException e) {			
				e.printStackTrace();
			}
		}
		
		long b = System.currentTimeMillis();
		System.out.println(b-a);
	}
	
	public void me7() {
		long a = System.currentTimeMillis();
		
		InputStream in = null;
		BufferedInputStream bis = null;
		
		OutputStream out = null;
		BufferedOutputStream bos = null;
	
		try {
			
			in = new FileInputStream("c:"+File.separator+"test.jpg");
			bis = new BufferedInputStream(in);
			
			out = new FileOutputStream("c:"+File.separator+"test7.jpg");
			bos = new BufferedOutputStream(out);
			
			byte[] arr = new byte[1024]; // 1024값을 높게하면할수록 속도가 빨라짐
			int len = -1;
			
			while((len = bis.read(arr)) != -1) {
				out.write(arr, 0, len);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				bis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				bos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		long b = System.currentTimeMillis();
		System.out.println(b-a);
	}

}
