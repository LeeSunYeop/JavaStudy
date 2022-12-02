package kr.co.command;

import java.util.List;
import java.util.Scanner;

import kr.co.domain.MemberDTO;
import kr.co.repository.MemberDAO;

public class SelectCommand implements Command {

	@Override
	public boolean execute(Scanner sc) {
		
		MemberDAO dao = new MemberDAO();
		List<MemberDTO> list = dao.select();
		
		for(int i=0; i<list.size(); i++) {
			MemberDTO dto = list.get(i);
			System.out.println(dto);
		}
		
		return true;
	}

	@Override
	public String toString() {
		
		return "전체 조회";
	}

}
