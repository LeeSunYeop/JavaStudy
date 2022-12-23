package kr.co.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.domain.BoardDTO;
import kr.co.domain.CommandAction;
import kr.co.domain.MemberDTO;
import kr.co.repository.BoardDAO;
import kr.co.repository.MemberDAO;

public class Board_ReadCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		String snum = request.getParameter("num");
		int num = Integer.parseInt(snum);
		
		String scurPage = request.getParameter("curPage");
		int curPage = Integer.parseInt(scurPage);
		
		String criteria = request.getParameter("criteria");
		if (criteria == null) {
			criteria = "title";
		}
		
		String keyword = request.getParameter("keyword");
		if (keyword == null) {
			keyword = "";
		}
		
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		MemberDAO mdao = new MemberDAO();
		MemberDTO mdto = mdao.login(mid, mpw);
		request.setAttribute("mdto", mdto);

		
		BoardDAO dao = new BoardDAO();
		BoardDTO dto = dao.read(num);
		
		request.setAttribute("dto", dto);
		request.setAttribute("curPage", curPage);
		request.setAttribute("criteria", criteria);
		request.setAttribute("keyword", keyword);
		
		return new CommandAction(false, "/jsp/board/read.jsp");
	}

}
