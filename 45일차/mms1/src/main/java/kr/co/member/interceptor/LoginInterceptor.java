package kr.co.member.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		//HttpSession session = request.getSession();
		//session.invalidate();  
		// 로그인되어 있는상태에서 로그인을 시도한다면..이렇게 짠다.
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		HttpSession session = request.getSession(); 
		// 로그인일때 getSession(); 이거나 getSession(true); 를 해줘야한다.
		
		Map<String, Object> map = modelAndView.getModel();
		
		Object login = map.get("login");
		
		if(login != null) {
			session.setAttribute("login", login);
			response.sendRedirect("/"); //list로 간다
		}
	}		

}
