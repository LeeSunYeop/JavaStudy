package kr.co.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.domain.CommandAction;
import kr.co.domain.MemberDTO;
import kr.co.repository.MemberDAO;

public class Member_LoginCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String mid = request.getParameter("mid");
		
		String mpw = request.getParameter("mpw");
		
		MemberDTO login = new MemberDAO().login(mid, mpw);
		
		HttpSession session = request.getSession();
		session.setAttribute("login", login);
		
		return new CommandAction(true, "/member/list.do");
	}

}
