package kr.co.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.domain.CommandAction;
import kr.co.domain.MemberDTO;
import kr.co.repository.MemberDAO;

public class Member_UpdateCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String sid = request.getParameter("mid");
		int mid = Integer.parseInt(sid);
		
		String password = request.getParameter("password");
		
		String name = request.getParameter("name");
		
		String sage = request.getParameter("age");
		int age = Integer.parseInt(sage);
		
		MemberDTO dto = new MemberDTO(mid, password, name, age);
		
		MemberDAO dao = new MemberDAO();
		dao.update(dto);
		
		return new CommandAction(true, "/member/read.do?id="+mid);
	}

}
