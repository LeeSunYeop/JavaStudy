package kr.co.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.domain.BoardDTO;
import kr.co.domain.CommandAction;
import kr.co.repository.BoardDAO;

public class Board_InsertCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		
		String bid = request.getParameter("bid");
		String title = request.getParameter("title");
		String spw = request.getParameter("pw");
		int pw = Integer.parseInt(spw);
		String content = request.getParameter("content");
		String name = request.getParameter("name");

		
		BoardDTO dto = new BoardDTO(-1, bid, title, content, pw, null, 0, 0, 0, 0, name);
		BoardDAO dao = new BoardDAO();
		dao.insert(dto);
		
		return new CommandAction(true, "/board/list.do");
		
	}
	

}
