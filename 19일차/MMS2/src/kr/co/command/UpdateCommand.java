package kr.co.command;

import java.util.Scanner;

import kr.co.domain.MemberDTO;
import kr.co.repository.MemberDAO;

public class UpdateCommand implements Command {

	@Override
	public boolean execute(Scanner sc) {
		System.out.println("수정할 회원의 아이디를 입력하세요.");
		int id = sc.nextInt();
		sc.nextLine();
		
		MemberDAO dao = new MemberDAO();
		
		MemberDTO dto = dao.selectById(id);
		
		if(dto != null) {
			System.out.println(dto);
			
			System.out.println("이름을 입력하세요.");
			String name = sc.nextLine();
			
			System.out.println("나이를 입력하세요.");
			int age = sc.nextInt();
			sc.nextLine();
			
			dto.setName(name);
			dto.setAge(age);
			
			int result = dao.update(dto);
			if(result > 0) {
				System.out.println("수정 성공");
			}else {
				System.out.println("수정 실패");
			}
			
		} else {
			System.out.println("존재하지 않는 회원입니다.");
		}
		
		return true;
	}

	@Override
	public String toString() {
		
		return "수정";
	}

}
