package kr.co.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.domain.CommandAction;

public class Board_ReplyUICommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String sorgNum = request.getParameter("orgNum");
		// orgNum 오리지널넘버(원래글)
		int orgNum = Integer.parseInt(sorgNum);
		
		String scurPage = request.getParameter("curPage");
		int curPage = Integer.parseInt(scurPage);
		
		String criteria = request.getParameter("criteria");
		if(criteria == null) {
			criteria = "title";
		}
		
		String keyword = request.getParameter("keyword");
		if(keyword == null) {
			keyword = "";  			
		}
		
		request.setAttribute("orgNum", orgNum);
		request.setAttribute("curPage", curPage);
		request.setAttribute("criteria", criteria);
		request.setAttribute("keyword", keyword);
		
		return new CommandAction(false, "/jsp/board/reply.jsp");
	}

}
