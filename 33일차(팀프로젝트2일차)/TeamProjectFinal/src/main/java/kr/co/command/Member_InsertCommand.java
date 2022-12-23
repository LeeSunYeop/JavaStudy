package kr.co.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.domain.CommandAction;
import kr.co.domain.MemberDTO;
import kr.co.repository.MemberDAO;

public class Member_InsertCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String mid = request.getParameter("mid");
		
		String mpw = request.getParameter("mpw");		
		
		String name = request.getParameter("name");
		
		String birth = request.getParameter("birth");
		
		MemberDTO dto = new MemberDTO(mid, mpw, name, birth);
		
		
		MemberDAO dao = new MemberDAO();
		dao.insert(dto);
		
		return new CommandAction(true, "/member/list.do");
	}

}
