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
		
		String mid = request.getParameter("mid");
		
		String mpw = request.getParameter("mpw");
		
		String curPage = request.getParameter("curPage");	
		
		String criteria = request.getParameter("criteria");
		if(criteria == null) {
			criteria = "name";
		}
		
		String keyword = request.getParameter("keyword");
		if(keyword == null) {
			keyword = "";  			
		}
				
		MemberDAO dao = new MemberDAO();
		int result = dao.delete(mid, mpw);
		
		if (result > 0) {
			return new CommandAction(true, "/member/list.do");
		} else {
			return new CommandAction(true, "/member/list.do");
		}
		
	}

}
