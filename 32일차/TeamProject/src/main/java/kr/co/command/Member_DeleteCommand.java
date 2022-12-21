package kr.co.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.domain.CommandAction;
import kr.co.repository.MemberDAO;

public class Member_DeleteCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String sid = request.getParameter("mid");
		int mid = Integer.parseInt(sid);
		
		String password = request.getParameter("password");
		
		MemberDAO dao = new MemberDAO();
		dao.delete(mid, password);
		
		return new CommandAction(true, "/member/list.do");
	}

}
