package kr.co.dwitt;

import java.util.Scanner;

import com.naver.InsertCommand;
import com.naver.StopCommand;

import net.daum.SelectCommand;

public class MainEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		Command[] menus = {new InsertCommand(), new SelectCommand(), new StopCommand()};
		
		Command menu = null;
				
		boolean isTrue = true;  // 무한반복
		
		while(isTrue) {
			System.out.println("메뉴를 선택하세요.");
			System.out.println("0: 입력, 1: 조회, 2: 종료");
			
			int idx = sc.nextInt();
			sc.nextLine();
			
			System.out.println("이름을 입력하세요");
			String name = sc.nextLine();			
			System.out.println("이름: "+ name);
			
			menu = menus[idx];
			// idx는 {new InsertCommand(), new SelectCommand(), new StopCommand()}를 말함
			
			isTrue = menu.execute(sc); // 무한반복할건지 빠져나올지 판단
						
		}
		
		sc.close();

	}

}
