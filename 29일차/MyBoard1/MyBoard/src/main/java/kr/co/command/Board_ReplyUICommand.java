package kr.co.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.domain.CommandAction;

public class Board_ReplyUICommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String sorgNum = request.getParameter("orgNum");
		int orgNum = Integer.parseInt(sorgNum);
		
		request.setAttribute("orgNum", orgNum);
		
		return new CommandAction(false, "/jsp/board/reply.jsp");
	}

}
