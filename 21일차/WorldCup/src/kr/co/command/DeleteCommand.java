package kr.co.command;

import java.util.Scanner;

import kr.co.domain.GroupDTO;
import kr.co.repository.GroupDAO;

public class DeleteCommand implements Command {

	@Override
	public boolean execute(Scanner sc) {
		System.out.println("삭제할 아이디를 입력하세요.");
		int id = sc.nextInt();
		sc.nextLine();
		
		GroupDAO dao = new GroupDAO();
		GroupDTO dto = dao.selectById(id);
		
		if (dto != null) {
			System.out.println("국가이름을 입력하세요.");
			String ctyname = sc.nextLine();
			
			System.out.println("감독이름을 입력하세요.");
			String hcname = sc.nextLine();
			
			System.out.println("조별이름을 입력하세요.");
			String gname = sc.nextLine();
			
			int result = dao.delete(new GroupDTO(id, ctyname, hcname, gname), 0);
			
			if (result > 0) {
				System.out.println("삭제 성공");
			} else {
				System.out.println("삭제 실패");
			}
		} else {
			System.out.println("존재하지 않는 아이디입니다.");
		}
		
		
		return true;
	}

	@Override
	public String toString() {
		
		return "삭제";
	}
	
	

}
