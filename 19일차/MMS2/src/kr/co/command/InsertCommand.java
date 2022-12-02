package kr.co.command;

import java.util.Scanner;

import kr.co.domain.MemberDTO;
import kr.co.repository.MemberDAO;

public class InsertCommand implements Command {

	@Override
	public boolean execute(Scanner sc) {
		
		System.out.println("아이디를 입력하세요.");
		int id = sc.nextInt();
		sc.nextLine();
		
		System.out.println("이름을 입력하세요.");
		String name = sc.nextLine();
		
		System.out.println("나이를 입력하세요.");
		int age = sc.nextInt();
		sc.nextLine();
		
		MemberDTO dto = new MemberDTO(id, name, age);
		
		MemberDAO dao = new MemberDAO();
		int i = dao.insert(dto);
		
		if(i>0) {
			System.out.println("입력 성공");
		}else {
			System.out.println("입력 실패");
		}
		
		return true;
	}

	@Override
	public String toString() {
		
		return "입력";
	}

}
