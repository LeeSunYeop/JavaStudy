package kr.co.command;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.domain.BoardDTO;
import kr.co.domain.CommandAction;
import kr.co.domain.PageTO;
import kr.co.domain.SearchPageTO;
import kr.co.repository.BoardDAO;

public class Board_ListCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String title = "검색 결과";
		
		int curPage = 1;
		
		String scurPage = request.getParameter("curPage");
		
		if (scurPage != null) {
			curPage = Integer.parseInt(scurPage);
		}
		
		String criteria = request.getParameter("criteria");
		if(criteria == null) {
			criteria = "title";
		}
		
		String keyword = request.getParameter("keyword");
		if(keyword == null || keyword.equals("")) {
			keyword = "";  //전체목록을 가져올수 있다.
			title = "게시글 목록";
		}
			
		
		BoardDAO dao = new BoardDAO();
		
		SearchPageTO<BoardDTO> pt = dao.list(curPage, criteria, keyword);
		request.setAttribute("pt", pt);
		request.setAttribute("title", title);
		
		return new CommandAction(false, "/jsp/board/list.jsp");
	}

}
