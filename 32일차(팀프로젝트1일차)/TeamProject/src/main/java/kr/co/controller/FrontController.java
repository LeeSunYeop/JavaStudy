package kr.co.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.command.Command;
import kr.co.command.Member_LoginCommand;
import kr.co.command.Member_LoginUICommand;
import kr.co.command.Member_LogoutCommand;
import kr.co.command.Member_DeleteCommand;
import kr.co.command.Member_InsertCommand;
import kr.co.command.Member_InsertUICommand;
import kr.co.command.Member_ListCommand;
import kr.co.command.Member_ReadCommand;
import kr.co.command.Member_UpdateCommand;
import kr.co.command.Member_UpdateUICommand;
import kr.co.command.NotServiceCommand;
import kr.co.domain.CommandAction;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map<String, Command> menus = new HashMap<String, Command>();
		
		menus.put("/member/list.do", new Member_ListCommand());
		menus.put("/member/insertui.do", new Member_InsertUICommand());
		menus.put("/member/insert.do", new Member_InsertCommand());
		menus.put("/member/read.do", new Member_ReadCommand());
		menus.put("/member/updateui.do", new Member_UpdateUICommand());
		menus.put("/member/update.do", new Member_UpdateCommand());
		menus.put("/member/delete.do", new Member_DeleteCommand());
		
		menus.put("/member/loginui.do", new Member_LoginUICommand());
		menus.put("/member/login.do", new Member_LoginCommand());
		menus.put("/member/logout.do", new Member_LogoutCommand());
		
		String uri = request.getRequestURI();
		String ctxp = request.getContextPath();
		String what = uri.substring(ctxp.length());
		
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
