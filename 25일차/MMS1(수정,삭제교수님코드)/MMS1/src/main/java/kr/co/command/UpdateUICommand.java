package kr.co.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.domain.MemberDTO;
import kr.co.repository.MemberDAO;

public class UpdateUICommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);
		
		MemberDTO dto = new MemberDAO().read(id);
		
		request.setAttribute("dto", dto);
		
		request.getRequestDispatcher("jsp/update.jsp")
		.forward(request, response);

	}

}
