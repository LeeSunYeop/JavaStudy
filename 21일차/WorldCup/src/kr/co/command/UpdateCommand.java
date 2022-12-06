package kr.co.command;

import java.util.Scanner;

import kr.co.domain.GroupDTO;
import kr.co.repository.GroupDAO;

public class UpdateCommand implements Command {

	@Override
	public boolean execute(Scanner sc) {
		System.out.println("수정할 아이디를 입력하세요.");
		int id = sc.nextInt();
		sc.nextLine();
		
		GroupDAO dao = new GroupDAO();
		
		GroupDTO dto = dao.selectById(id);
		
		if (dto != null) {
			System.out.println(dto);
			
			System.out.println("국가이름을 입력하세요.");
			String ctyname = sc.nextLine();
			
			System.out.println("감독이름을 입력하세요.");
			String hcname = sc.nextLine();
			
			dto.setCtyname(ctyname);
			dto.setHcname(hcname);
			
			int result = dao.update(dto, id, ctyname, hcname);
			if (result > 0) {
				System.out.println("수정 성공");
			} else {
				System.out.println("수정 실패");
			}
			
		} else {
			System.out.println("존재하지 않는 아이디입니다.");
		}
		
		return true;
	}

	@Override
	public String toString() {
		
		return "수정";
	}

}
