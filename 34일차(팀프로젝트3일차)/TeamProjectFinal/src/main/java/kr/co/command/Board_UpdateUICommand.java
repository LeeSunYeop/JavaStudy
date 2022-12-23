package kr.co.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.domain.BoardDTO;
import kr.co.domain.CommandAction;
import kr.co.repository.BoardDAO;

public class Board_UpdateUICommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		String snum = request.getParameter("num");
		int num = Integer.parseInt(snum);
		
		String scurPage = request.getParameter("curPage");
		int curPage = Integer.parseInt(scurPage);
		
		String criteria = request.getParameter("criteria");
		
		BoardDAO dao = new BoardDAO();
		
		BoardDTO dto = dao.updateui(num);
		
		request.setAttribute("dto", dto);
		request.setAttribute("curPage", curPage);
		request.setAttribute("criteria", criteria);
		
		return new CommandAction(false, "/jsp/board/update.jsp");
	}

}
