package kr.co.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.domain.CommandAction;
import kr.co.domain.MemberDTO;
import kr.co.repository.MemberDAO;

public class UpdateUICommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);
		
		MemberDTO dto = new MemberDAO().read(id);
		// 한번만 사용되니깐 이렇게 코드짜는게 좋다.
		
		request.setAttribute("dto", dto);
		
		//request.getRequestDispatcher("jsp/update.jsp").forward(request, response);
		return new CommandAction(false, "jsp/update.jsp");
	}

}
