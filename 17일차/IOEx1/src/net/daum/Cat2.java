package net.daum;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class Cat2 {
	
	public void p1() {
		
		Reader in = null;
		BufferedReader br = null;
		
		Writer out = null;
		BufferedWriter bw = null;
		
		try {
			in = new FileReader("C:"+File.separator+"test_char.txt");
			br = new BufferedReader(in);
			
			out = new FileWriter("C:"+File.separator+"test_char3.txt");
			bw = new BufferedWriter(out);
			
			String msg = null;
			
			while((msg = br.readLine()) != null) {
				bw.write(msg);
				bw.write(System.getProperty("line.separator"));
			}
			
			bw.flush();
			
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
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				bw.close();
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
	
	public void p2() {
		Reader in = null;
		BufferedReader br = null;
		
		Writer out = null;
		BufferedWriter bw = null;
		
		try {
			
			in = new FileReader("C:"+File.separator+"test_char.txt");
			
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
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				bw.close();
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
	
	

}
