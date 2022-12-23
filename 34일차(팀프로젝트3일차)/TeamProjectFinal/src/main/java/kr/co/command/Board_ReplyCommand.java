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

public class Board_ReplyCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		String sorgNum = request.getParameter("orgNum");
		int orgNum = Integer.parseInt(sorgNum);
		
		String bid = request.getParameter("mid");
		String name = request.getParameter("name");
		
		String spw = request.getParameter("pw");
		int pw = Integer.parseInt(spw);
		
		String title = request.getParameter("title");
		
		String content = request.getParameter("content");
		
		String scurPage = request.getParameter("curPage");
		int curPage = Integer.parseInt(scurPage);
		
		BoardDTO dto = new BoardDTO(-1, bid, title, content, pw, 
				null, -1, -1, -1, -1, name);
		
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
		
		BoardDAO dao = new BoardDAO();
		MemberDAO mdao = new MemberDAO();
		MemberDTO mdto = mdao.login(mid, mpw);
		
		dao.reply(orgNum, dto);

		request.setAttribute("mdto", mdto);
		
		StringBuffer sb = new StringBuffer();
		sb.append("/board/list.do?curPage=");
		sb.append(curPage);
		sb.append("&criteria=");
		sb.append(criteria);
		sb.append("&keyword=");
		sb.append(keyword);
		sb.append("&mid=");
		sb.append(mid);
		
		return new CommandAction(true, sb.toString());
	}

}
