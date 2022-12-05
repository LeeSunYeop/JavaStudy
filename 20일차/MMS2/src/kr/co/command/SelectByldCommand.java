package kr.co.command;

import java.util.Scanner;

import kr.co.domain.MemberDTO;
import kr.co.repository.MemberDAO;

public class SelectByldCommand implements Command {

	@Override
	public boolean execute(Scanner sc) {
		
		System.out.println("조회할 아이디를 입력하세요.");
		int id = sc.nextInt();
		sc.nextLine();
		
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.selectById(id);
		
		System.out.println(dto.getId());
		System.out.println(dto.getName());
		System.out.println(dto.getAge());
		
		//System.out.println(dto);  dto에서 toString할때 id,name,age를 다 체크했으면 이렇게 써도 된다.				
		
		return true;
	}

	@Override
	public String toString() {
		
		return "아이디로 조회";
	}

}
