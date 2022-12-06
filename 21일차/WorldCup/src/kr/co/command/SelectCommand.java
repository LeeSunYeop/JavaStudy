package kr.co.command;

import java.lang.reflect.Member;
import java.util.List;
import java.util.Scanner;

import kr.co.domain.GroupDTO;
import kr.co.repository.GroupDAO;

public class SelectCommand implements Command {

	@Override
	public boolean execute(Scanner sc) {
		
		GroupDAO dao = new GroupDAO();
		List<GroupDTO> list = dao.select();
		
		for (int i = 0; i < list.size(); i++) {
			GroupDTO dto = list.get(i);
			System.out.println(dto);
		}
		
		return true;
	}

	@Override
	public String toString() {
		
		return "전체 조회";
	}

}
