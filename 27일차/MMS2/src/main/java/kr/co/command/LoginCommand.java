package kr.co.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.domain.CommandAction;
import kr.co.domain.MemberDTO;
import kr.co.repository.MemberDAO;

public class LoginCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);
		
		String name = request.getParameter("name");
		
		MemberDTO login = new MemberDAO().login(id, name);
		
		HttpSession session = request.getSession();
		session.setAttribute("login", login);
		
		//response.sendRedirect("/list.do"); //지금은 메인페이지로 넘어가게끔 함.
		return new CommandAction(true, "/member/list.do");
	}

}
