package kr.co.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.domain.CommandAction;
import kr.co.repository.BoardDAO;
import kr.co.repository.MemberDAO;

public class Member_DeleteCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");

		System.out.println(mid);
		System.out.println(mpw);
		
				
		MemberDAO mdao = new MemberDAO();
		int result2 = mdao.delete(mid, mpw);
		
		if (result2 > 0) {
			return new CommandAction(true, "/member/logout.do");
		} else {
			return new CommandAction(false, "/jsp/member/err.jsp");
		}
		
	}

}
