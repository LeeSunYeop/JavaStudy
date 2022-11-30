package net.daum;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PipedWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;

public class Cat {
	
	public void p1() {  // 출력하기
		// 문자스트림의 최상위 부모클래스
		// Writer: 출력에 관한 문자스트림의 최상위 부모클래스: 추상클래스
		// Reader: 입력에 관한 문자스트림의 최상위 부모클래스: 추상클래스
		
		Writer out = null;
		
		try {
			out = new FileWriter("C:"+File.separator+"test_char.txt");
			out.write("딘딘");
			out.write(System.lineSeparator());
			out.write("카타르 월드컵");
			out.write(System.getProperty("line.separator"));
			out.write("1무2패 예언");
			
			out.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void p2() {  // 읽어오기
		// c:test_char.txt 파일의 내용을 읽어와서 콘솔창에 출력하세요.
		Reader in = null;
		
		try {
			in = new FileReader("C:"+File.separator+"test_char.txt");
			
			int what = -1;
			
			while((what = in.read()) != -1) {
				System.out.println((char)what);
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
		}
	}
	
	public void p3() {  // 배열을 이용한 속도향상
		// c:/test_char.txt의 내용을 읽어와서 콘솔창에 출력하세요
		// 배열을 이용하세요
		Reader in = null;		
		
		try {
			in = new FileReader("C:"+File.separator+"test_char.txt");
			
			char[] arr = new char[1024];
			int len = -1;
			
			while((len = in.read(arr)) != -1) {
				for(int i=0; i<len; i++) {
					System.out.println(arr[i]);
				}
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
		}		
	}
	
	public void p4() {  // BufferedReader사용하여 속도향상
		Reader in = null;
		BufferedReader br = null;
		
		try {
			in = new FileReader("C:"+File.separator+"test_char.txt");
			br = new BufferedReader(in);
			
			String what = null;
			
			while((what = br.readLine()) != null) {
				
				System.out.println(what); // 원본에는 줄바꿈이 있는데 읽어올때는 줄바꿈없이 읽어온다
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {				
				e.printStackTrace();
			}
			
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}		
	}
	
	public void p5() {
		// c:/test_char.txt의 파일을 복사하세요
		// c:/test_char2.txt의 파일로..
		long a = System.currentTimeMillis();
		
		Reader in = null;
		BufferedReader br = null;
		
		Writer out = null;
		BufferedWriter bw = null;
		
		try {
			in = new FileReader("C:"+File.separator+"test_char.txt");
			br = new BufferedReader(in);
			
			out = new FileWriter("C:"+File.separator+"test_char2.txt");
			bw = new BufferedWriter(out);
					
			String what = null;
			
			while((what = br.readLine()) != null) {
				
				bw.write(what);
				bw.write(System.getProperty("line.separator"));
			}
			
			bw.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			try {
				in.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			try {
				bw.close();
			} catch (IOException e1) {
				e1.printStackTrace();
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
	
	public void p6() {
		//PrintWriter  기존에 있던 내용을 없애고 그위에 덮어 씌운다.
		PrintWriter pw = null;
		
		try {
			pw = new PrintWriter("C:"+File.separator+"test_char.txt");
			pw.append("hello");
			pw.append("word");
			pw.print(false);     // hellowordfalse 나옴
			pw.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pw.close();
			} catch (Exception e) {				
				e.printStackTrace();
			}
		}
	}
	
	public void p7() {
		Writer out = null;
		PrintWriter pw = null;
		
		try {
			out = new FileWriter("C:"+File.separator+"test_char.txt", true);
			pw = new PrintWriter(out);
			
			pw.append("append test");
			pw.write("\n");
			pw.write("today");
			pw.write("\n");
			pw.write("hhhh"); 	
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			try {
				out.close();
			} catch (IOException e) {			
				e.printStackTrace();
			}
			
			try {
				pw.close();
			} catch (Exception e) {				
				e.printStackTrace();
			}
		}
	}
	
	public void p8() {
		// 모든 장비는 바이트스트림을 지원합니다.
		// 하지만 문자스트림은 일부 장비만 지원합니다.
		// 문자스트림으로 작업을 하고 싶을 때가 있습니다.
		// 그런데 해당 장비는 바이트스트림을 지원할 때.
		// 어떻게 해야하는가?
		// InputStreamReader
		// OutputStreamWriter
		// 자바프로그램 - 문자스트림 - isr or osw - 바이트스트림 - 장치
		
		InputStream in = null;
		InputStreamReader isr = null;  // 중간에 양쪽을 이어주는 역할
		BufferedReader br = null;
		
		try {
			in = new FileInputStream("C:"+File.separator+"test_char.txt");
			isr = new InputStreamReader(in);
			br = new BufferedReader(isr);
			// new 를 사용할 때만 close() 메서드를 사용하고
			// get 을 사용한 메서드는 close() 메서드를 사용하면 안된다.
			
			String what = null;
			while((what = br.readLine()) != null) {
				System.out.println(what);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				isr.close();
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
		}
	}
	

}
