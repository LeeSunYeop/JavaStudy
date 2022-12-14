package kr.co.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.command.Board_DeleteCommand;
import kr.co.command.Board_InsertCommand;
import kr.co.command.Board_InsertUICommand;
import kr.co.command.Board_ListCommand;
import kr.co.command.Board_ReadCommand;
import kr.co.command.Board_ReplyCommand;
import kr.co.command.Board_ReplyUICommand;
import kr.co.command.Board_SearchCommand;
import kr.co.command.Board_UpdateCommand;
import kr.co.command.Board_UpdateUICommand;
import kr.co.command.Command;
import kr.co.command.NotServiceCommand;
import kr.co.domain.CommandAction;
import kr.co.repository.ServiceMenuDAO;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ServiceMenuDAO dao = new ServiceMenuDAO();
		Map<String, Command> menus = dao.callMenu();
		
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
