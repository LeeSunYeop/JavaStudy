package kr.co.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.domain.CommandAction;

public class LogoutCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate(); //브라우저에서 제거되는 섹션메서드
		}
		
		//response.sendRedirect("/list.do"); //list.jsp로 가면 아무것도 없기 때문에 do로 가야한다
		return new CommandAction(true, "/member/list.do");
	}

}
