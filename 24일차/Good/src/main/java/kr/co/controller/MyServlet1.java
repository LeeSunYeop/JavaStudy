package kr.co.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet1
 */
@WebServlet("/ms1")
public class MyServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MyServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=UTF-8");
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		
//		PrintWriter out = response.getWriter();
//		
//		out.print("<!DOCTYPE html>");
//		out.print("<html>");
//		out.print("<body>");
//		
//		out.print(id);
//		out.print("<br>");
//		out.print(name);
//		
//		out.print("</body>");
//		out.print("</html>");
		
		request.setAttribute("id", id);
		request.setAttribute("name", name);
		
		request.getRequestDispatcher("jsp/ms11.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		// text 와 test 차이점
		// "test/html;charset=utf-8" 로 입력하면 브라우저에 입력을 끝내면 다운로드가 되어진다
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		
//		PrintWriter out = response.getWriter();
//		
//		out.print("<!DOCTYPE html>");
//		out.print("<html>");
//		out.print("<body>");
//		
//		out.print(id);
//		out.print("<br>");
//		out.print(pw);
//		out.print("<br>");
//		out.print(name);
//		out.print("<br>");
//		
//		out.print("</body>");
//		out.print("</html>");   
		
		request.setAttribute("id", id);
		request.setAttribute("pw", pw);
		request.setAttribute("name", name);  // ms1.jsp 파일하고 이어져 있음
		
		RequestDispatcher dis = request.getRequestDispatcher("jsp/ms1.jsp");
		dis.forward(request, response);
		
		//request.getRequestDispatcher("jsp/ms1.jsp").forward(request, response);
		
	}

}
