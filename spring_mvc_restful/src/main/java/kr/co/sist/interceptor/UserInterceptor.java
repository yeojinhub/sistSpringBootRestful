package kr.co.sist.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class UserInterceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		boolean flag = false;
		
		System.out.println("preHandle 요청 URL : "+ request.getRequestURI());
		
		String id = (String)request.getSession().getAttribute("user_id");
		System.out.println("session 값 : "+ id);
		
		flag = (id != null);
		//세션이 없는지 확인
		if( !flag ) {
//			response.sendRedirect("http://localhost/admin/login/login_form");
			response.sendRedirect("/user/login/login_form");
		} //end if
		
		return flag;
	} //preHandle
	
} //class
