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
		
		String sid = request.getParameter("mid");
		int mid = Integer.parseInt(sid);
		
		String name = request.getParameter("name");
		
		MemberDTO login = new MemberDAO().login(mid, name);
		
		HttpSession session = request.getSession();
		session.setAttribute("login", login);
		
		return new CommandAction(true, "/member/list.do");
	}

}
