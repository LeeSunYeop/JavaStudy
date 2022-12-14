package kr.co.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.domain.CommandAction;

public class LoginUICommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// 1. user가 보내준 데이터 획득 및 가공
		// 2. dao 객체 생성 및 해당 메서드 호출
		// 3. data 바인딩
		// 4. 포워딩...loginui.do, jsp/login.jsp
		//request.getRequestDispatcher("/jsp/login.jsp")
		//.forward(request, response);
		
		return new CommandAction(false, "/jsp/login.jsp");
	}

}
