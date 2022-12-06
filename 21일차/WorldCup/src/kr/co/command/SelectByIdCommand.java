package kr.co.command;

import java.util.Scanner;

import kr.co.domain.GroupDTO;

import kr.co.repository.GroupDAO;


public class SelectByIdCommand implements Command {

	@Override
	public boolean execute(Scanner sc) {
		
		System.out.println("조회할 아이디를 입력하세요.");
		int id = sc.nextInt();
		sc.nextLine();
		
		GroupDAO dao = new GroupDAO();
		GroupDTO dto = dao.selectById(id);
		
		System.out.println(dto.getId());
		System.out.println(dto.getGname());
		System.out.println(dto.getCtyname());
		System.out.println(dto.getHcname());
		
		return true;
	}

	@Override
	public String toString() {
		
		return "아이디로 조회";
	}
	
	

}
