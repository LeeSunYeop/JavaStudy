package kr.co.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.domain.CommandAction;
import kr.co.domain.MemberDTO;
import kr.co.repository.MemberDAO;

public class Member_ListCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		MemberDAO dao = new MemberDAO();
		List<MemberDTO> list = dao.list();
		
		request.setAttribute("list", list);		
		
		return new CommandAction(false, "/jsp/member/list.jsp");
	}

}
