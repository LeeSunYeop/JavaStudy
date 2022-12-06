package kr.co.command;

import java.util.Scanner;

import kr.co.domain.GroupDTO;
import kr.co.repository.GroupDAO;

public class InsertCommand implements Command {

	@Override
	public boolean execute(Scanner sc) {
		
		System.out.println("아이디를 입력하세요.");
		int id = sc.nextInt();
		sc.nextLine();
		
		System.out.println("조별이름을 입력하세요.");
		String gname = sc.nextLine();
		
		System.out.println("국가이름을 입력하세요.");
		String ctyname = sc.nextLine();
		
		System.out.println("감독이름(한글)을 입력하세요");
		String hcname = sc.nextLine();
		
		GroupDTO dto = new GroupDTO(id, gname, ctyname, hcname);
		GroupDAO dao = new GroupDAO();
		int i = dao.insert(dto, id, ctyname, hcname);
		
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
