package kr.co.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.domain.MemberDTO;
import kr.co.repository.MemberDAO;

public class ListCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// 1. 유저가 보내 준 데이터 획득 및 가공
		// 2. DAO 객체 생성 및 메서드 호출
		MemberDAO dao = new MemberDAO();
		List<MemberDTO> list = dao.list();
		
		// 3. binding
		request.setAttribute("list", list);
		
		// 4. forwarding
		request.getRequestDispatcher("jsp/list.jsp")
		.forward(request, response);
	}

}
