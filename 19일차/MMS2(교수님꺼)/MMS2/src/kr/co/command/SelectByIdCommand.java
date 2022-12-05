package kr.co.command;

import java.util.Scanner;

import kr.co.domain.MemberDTO;
import kr.co.repository.MemberDAO;

public class SelectByIdCommand implements Command {

	@Override
	public boolean execute(Scanner sc) {
		
		System.out.println("조회할 아이디를 입력하세요.");
		int id = sc.nextInt();
		sc.nextLine();
		
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.selectById(id);
		
		System.out.println(dto);
		
		
		
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "아이디로 조회";
	}

}
