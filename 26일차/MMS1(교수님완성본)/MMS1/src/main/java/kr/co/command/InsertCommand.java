package kr.co.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.domain.CommandAction;
import kr.co.domain.MemberDTO;
import kr.co.repository.MemberDAO;

public class InsertCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// 1. 유저가 보내 준 데이터 획득 및 가공
		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);
		
		String name = request.getParameter("name");
		
		String sage = request.getParameter("age");
		int age = Integer.parseInt(sage);
		
		MemberDTO dto = new MemberDTO(id, name, age);
		
		// 2. DAO 객체 생성 및 해당 메서드 호출
		MemberDAO dao = new MemberDAO();
		dao.insert(dto);
		
		// 3. 데이터 바인딩
		
		// 4 포워딩: 목록으로 가기
		//response.sendRedirect("/list.do");
		return new CommandAction(true, "/list.do");
		
		
		
		
	}

}
