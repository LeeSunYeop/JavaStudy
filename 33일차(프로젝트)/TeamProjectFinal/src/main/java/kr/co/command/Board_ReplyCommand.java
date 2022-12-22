package kr.co.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.domain.BoardDTO;
import kr.co.domain.CommandAction;
import kr.co.repository.BoardDAO;

public class Board_ReplyCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		String sorgNum = request.getParameter("orgNum");
		int orgNum = Integer.parseInt(sorgNum);
		
		String bid = request.getParameter("bid");
		
		String spw = request.getParameter("pw");
		int pw = Integer.parseInt(spw);
		
		String title = request.getParameter("title");
		
		String content = request.getParameter("content");
		
		String scurPage = request.getParameter("curPage");
		int curPage = Integer.parseInt(scurPage);
		
		BoardDTO dto = new BoardDTO(-1, bid, title, content, pw, 
				null, -1, -1, -1, -1);
		
		String criteria = request.getParameter("criteria");
		if (criteria == null) {
			criteria = "title";
		}
		
		String keyword = request.getParameter("keyword");
		if (keyword == null) {
			keyword = "";
		}
		
		BoardDAO dao = new BoardDAO();
		dao.reply(orgNum, dto);
		
		StringBuffer sb = new StringBuffer();
		sb.append("/board/list.do?curPage=");
		sb.append(curPage);
		sb.append("&criteria=");
		sb.append(criteria);
		sb.append("&keyword=");
		sb.append(keyword);
		
		return new CommandAction(true, sb.toString());
	}

}
