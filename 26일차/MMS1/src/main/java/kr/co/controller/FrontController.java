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
import kr.co.command.DeleteCommand;
import kr.co.command.InsertCommand;
import kr.co.command.InsertUICommand;
import kr.co.command.ListCommand;
import kr.co.command.LoginCommand;
import kr.co.command.LoginUICommand;
import kr.co.command.LogoutCommand;
import kr.co.command.ReadCommand;
import kr.co.command.UpdateCommand;
import kr.co.command.UpdateUICommand;
import kr.co.domain.CommandAction;


/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		Map<String, Command> menus = new HashMap<String, Command>();
		menus.put("/insertui.do", new InsertUICommand());  // 파일 위치를 kr.co.command 패키지에다 하기
		menus.put("/insert.do", new InsertCommand());  // 파일 위치를 kr.co.command 패키지에다 하기
		menus.put("/list.do", new ListCommand());  // 파일 위치를 kr.co.command 패키지에다 하기
		// if문을 사용하면 한도끝도 없기 때문에 Map을 사용함
		menus.put("/read.do", new ReadCommand());		
		
		menus.put("/loginui.do", new LoginUICommand());
		menus.put("/login.do", new LoginCommand());
		menus.put("logout.do", new LogoutCommand());
		
		menus.put("/updateui.do", new UpdateUICommand());
		menus.put("/update.do", new UpdateCommand());
		menus.put("/delete.do", new DeleteCommand());
		
		
		String uri = request.getRequestURI();
		String ctxp = request.getContextPath();
		String what = uri.substring(ctxp.length());
		
		Command menu = menus.get(what);
		
		if(menu != null){
			CommandAction action = menu.execute(request, response);
			
			if (action.isRedirect()) {
				response.sendRedirect(action.getWhere());
			} else {
				request.getRequestDispatcher(action.getWhere()).forward(request, response);
			}
		} else {
			System.out.println("지원하지 않는 서비스입니다.");
		}
		
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
