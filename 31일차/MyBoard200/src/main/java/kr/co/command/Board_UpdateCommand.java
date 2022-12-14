package kr.co.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.domain.BoardDTO;
import kr.co.domain.CommandAction;
import kr.co.repository.BoardDAO;

public class Board_UpdateCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String snum = request.getParameter("num");
		int num = Integer.parseInt(snum);
		
		String scurPage = request.getParameter("curPage");
		int curPage = Integer.parseInt(scurPage);
		
		String author = request.getParameter("author");
		
		String spw = request.getParameter("pw");
		int pw = Integer.parseInt(spw);
		
		String title = request.getParameter("title");
		
		String content = request.getParameter("content");
		
		BoardDTO dto = new BoardDTO(num, author, title, content, pw, null, -1, -1, -1, -1);
		
		String criteria = request.getParameter("criteria");  // 검색결과
		if(criteria == null) {   
			criteria = "title";   //목록용
		}
		
		String keyword = request.getParameter("keyword");  //검색결과
		if(keyword == null) {
			keyword = "";  		//목록용	
		}
		
		BoardDAO dao = new BoardDAO();
		dao.update(dto);
		
		StringBuffer sb = new StringBuffer();
		sb.append("/board/read.do?num=");
		sb.append(num);
		sb.append("&curPage=");
		sb.append(curPage);
		sb.append("&criteria=");
		sb.append(criteria);
		sb.append("&keyword=");
		sb.append(keyword);
		//return에 들어가는 코드가 많아지면 StringBuffer를 이용하면 된다.
		return new CommandAction(true, sb.toString());
		// return new CommandAction(true, "/board/read.do?num="+num+"&criteria="+criteria+"&keyword"+keyword);
	}

}
