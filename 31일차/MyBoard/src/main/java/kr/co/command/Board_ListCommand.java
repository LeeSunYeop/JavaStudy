package kr.co.command;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.domain.BoardDTO;
import kr.co.domain.CommandAction;
import kr.co.domain.PageTO;
import kr.co.repository.BoardDAO;

public class Board_ListCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int curPage = 1;
		
		String scurPage = request.getParameter("curPage");
		
		if (scurPage != null) {
			curPage = Integer.parseInt(scurPage);
		} 
		
		BoardDAO dao = new BoardDAO();
//		List<BoardDTO> list = dao.list();		
//		request.setAttribute("list", list);
		
		PageTO<BoardDTO> pt = dao.list2(curPage);
		request.setAttribute("pt", pt);
		
		return new CommandAction(false, "/jsp/board/list.jsp");
	}

}
