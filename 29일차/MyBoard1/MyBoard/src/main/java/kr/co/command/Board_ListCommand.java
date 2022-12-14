package kr.co.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.domain.BoardDTO;
import kr.co.domain.CommandAction;
import kr.co.repository.BoardDAO;

public class Board_ListCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		BoardDAO dao = new BoardDAO();
		List<BoardDTO> list = dao.list();
		
		request.setAttribute("list", list);
		
		return new CommandAction(false, "/jsp/board/list.jsp");
	}

}
