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
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);
		
		String name = request.getParameter("name");
		
		MemberDTO login = new MemberDAO().login(id, name);
		
		HttpSession session = request.getSession();
		session.setAttribute("login", login);
		
		//response.sendRedirect("/list.do");
		
		return new CommandAction(true, "/list.do");
		
		
		

	}

}
