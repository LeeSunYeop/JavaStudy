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
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);
		
		String name = request.getParameter("name");
		
		String sage = request.getParameter("age");
		int age = Integer.parseInt(sage);
		
		MemberDTO dto = new MemberDTO(id, name, age);
		
		
		MemberDAO dao = new MemberDAO();
		dao.insert(dto);
		
		
		return new CommandAction(true, "/member/list.do");
	}

}
