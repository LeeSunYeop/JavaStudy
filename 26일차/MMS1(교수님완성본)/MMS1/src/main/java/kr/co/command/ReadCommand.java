package kr.co.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.domain.CommandAction;
import kr.co.domain.MemberDTO;
import kr.co.repository.MemberDAO;

public class ReadCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);
		
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.read(id);
		
		request.setAttribute("dto", dto);
		
		
		//request.getRequestDispatcher("jsp/read.jsp")
		//.forward(request, response);
		
		return new CommandAction(false, "jsp/read.jsp");
		

	}

}
