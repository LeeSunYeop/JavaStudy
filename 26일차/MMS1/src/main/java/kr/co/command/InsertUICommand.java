package kr.co.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.domain.CommandAction;

public class InsertUICommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 클라이언트가 보내준 데이터 획득 및 가공
		// 2. DAO객체 생성 및 해당 메서드 호출
		// 3. 데이터 바인딩
		// 4. 포워딩
		
		//request.getRequestDispatcher("jsp/insert.jsp").forward(request, response);
		return new CommandAction(false, "jsp/insert.jsp");
	}

}
