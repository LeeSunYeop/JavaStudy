package kr.co.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet2
 */
@WebServlet("/ms2")
public class MyServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 선택한 취미들을 콘솔에 출력하세요.
		response.setContentType("text/html; charset=UTF-8"); // 한글을 브라우저로 보내기위해..
		
		String[] hobbis = request.getParameterValues("hobby");
//		for (int i = 0; i < hobbis.length; i++) {
//			String hobby = hobbis[i];
//			System.out.println(hobby); // 콘솔창에 독서,낮잠이 출력이 된다
//		}
		
//		PrintWriter out = response.getWriter();
//		
//		out.print("<!DOCTYPE html>");
//		out.print("<html>");
//		out.print("<body>");
//		
//		for (int i = 0; i < hobbis.length; i++) {
//			String hobby = hobbis[i];
//			out.print(hobby);
//			out.print("<br>");   // 브라우저에 독서 낮잠 이라고 출력이 된다.
//		}
//		
//		out.print("</html>");
//		out.print("</body>");
		
		request.setAttribute("hobbis", hobbis);
		
		request.getRequestDispatcher("jsp/ms2.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String school = request.getParameter("school");
		
		PrintWriter out = response.getWriter();
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.print("<body>");
		
		out.print(school);     // 브라우저에 나오는 글자를 클릭하면 선택이 되어진다.
		
		out.print("</body>");
		out.print("</html>");
	}

}
