package kr.co.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.domain.BoardDTO;
import kr.co.domain.CommandAction;
import kr.co.domain.MemberDTO;
import kr.co.domain.SearchPageTO;
import kr.co.repository.BoardDAO;
import kr.co.repository.MemberDAO;

public class Board_SearchCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		int curPage = 1;
		
		String scurPage = request.getParameter("curPage");
		
		if (scurPage != null) {
			curPage = Integer.parseInt(scurPage);
		}
		
		String criteria = request.getParameter("criteria");
		String keyword = request.getParameter("keyword");
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		
		
		
		BoardDAO dao = new BoardDAO();
		SearchPageTO<BoardDTO> pt = dao.search(curPage, criteria, keyword);


		MemberDAO mdao = new MemberDAO();
		MemberDTO mdto = mdao.login(mid, mpw);
		
		
		
		request.setAttribute("pt", pt);
		request.setAttribute("mdto", mdto);
		
		return new CommandAction(false, "/jsp/board/search.jsp?curPage="+curPage
				+ "criteria="+criteria+"&keyword="+keyword+"&mid="+mid);
		
	}

}
