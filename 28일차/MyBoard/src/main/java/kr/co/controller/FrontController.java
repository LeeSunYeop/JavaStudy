package kr.co.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.command.Board_InsertCommand;
import kr.co.command.Board_InsertUICommand;
import kr.co.command.Board_ListCommand;
import kr.co.command.Command;
import kr.co.command.NotServiceCommand;
import kr.co.domain.CommandAction;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 작성순서 2번
		Map<String, Command> menus = new HashMap<String, Command>();
		
		// 작성순서 4번
		menus.put("/board/list.do", new Board_ListCommand());
		menus.put("/board/insertui.do", new Board_InsertUICommand());
		menus.put("/board/insert.do", new Board_InsertCommand());
		
		// 작성순서 1번
		String uri = request.getRequestURI();
		String ctxp = request.getContextPath();
		String what = uri.substring(ctxp.length());
		
		// 작성순서 3번
		Command menu = menus.get(what);
		
		if (menu == null) {
			
			menu = new NotServiceCommand();

		}
		
		CommandAction action = menu.execute(request, response);
		
		if (action.isRedirect()) {
			response.sendRedirect(action.getWhere());			
		} else {
			request.getRequestDispatcher(action.getWhere()).forward(request, response);
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
