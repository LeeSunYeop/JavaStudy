package kr.co.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class YourServlet2
 */
@WebServlet("/ys3")
public class YourServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		System.out.println("DB에 접속해서 전달받은 id가 있는지 확인");
		System.out.println("해당 id의 비번이 전달받은 값과 일치하는지 확인");
		System.out.println("일치하면 dto 객체 반환, 그렇지 않으면 null 반환");
		
		// session작업
		//session 객체가 있으면, 있는 것을 반환하세요
		// 만약 없으면, session 객체를 만들어서 넘겨 주세요.
		// 로그인할 때 사용함
		HttpSession session = request.getSession();  // 괄호안에 아무것도 안 적어도 true임.
		//request.getSession(true); 
		session.setMaxInactiveInterval(60); //60초임, 60초가 지나면 브라우저에 id목록이 사라짐
		
		session.setAttribute("id", id);
		
		
		
		// session 객체가 있으면, 있는 것을 반환하세요.
		// 만약 없으면, null을 넘겨주세요.
		// request.getSession(false); // 만약 없으면, session 객체를 만들어서 넘겨 주세요.
		// 로그인 이후 행해지는 작업
		
		
		System.out.println("메인 페이지로 이동");
		
		response.sendRedirect("jsp/main.jsp");
	}

}
