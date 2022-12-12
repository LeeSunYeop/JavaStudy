package kr.co.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class YourServlet2
 */
@WebServlet("/ys2")
public class YourServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		System.out.println("DB에 접속해서 전달받은 id가 있는지 확인");
		System.out.println("해당 id의 비번이 전달받은 값과 일치하는지 확인");
		System.out.println("일치하면 dto 객체 반환, 그렇지 않으면 null 반환");
		
		request.setAttribute("id", id);
		request.setAttribute("pw", pw);
		
		System.out.println("메인 페이지로 이동");
		
		response.sendRedirect("jsp/main.jsp");
	}

}
