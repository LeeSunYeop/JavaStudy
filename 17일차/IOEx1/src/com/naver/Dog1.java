package com.naver;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Dog1 {
	
	public void me1() {
		long a = System.currentTimeMillis();
		
		InputStream in = null;
		BufferedInputStream bis = null;
		
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
	
	public void me2() {
		long a = System.currentTimeMillis();
		
		InputStream in = null;
		BufferedInputStream bis = null;
		
		OutputStream out = null;
		BufferedOutputStream bos = null;
		
		try {
			
			in = new FileInputStream("c://test.jpg");
			bis = new BufferedInputStream(in);
			
			out = new FileOutputStream("c://test12.jpg");
			bos = new BufferedOutputStream(out);
			
			byte[] arr = new byte[2048];
			int len = -1;
			
			while((len = bis.read(arr)) != -1) {
				bos.write(arr, 0, len);
			}
					
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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
		}
		
		long b = System.currentTimeMillis();
		System.out.println(b-a); // 90나옴
	}
	
	public void me3() {
		long a = System.currentTimeMillis();
		
		InputStream in = null;
		BufferedInputStream bis = null;;
		
		OutputStream out = null;
		BufferedOutputStream bos = null;
		
		try {
			in = new FileInputStream("c://test.jpg");
			bis = new BufferedInputStream(in);
			
			out = new FileOutputStream("c://test13.jpg");
			bos = new BufferedOutputStream(out);
			
			byte[] arr = new byte[2048];
			int len = -1;
			
			while((len = bis.read(arr)) != -1) {
				bos.write(arr, 0, len);
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
		System.out.println(b-a); // 28나옴
	}
}
