package com.example.demo10.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

// AuthInterceptor는 request 요청이 
// 앞에 /auth/** 로 요청한 주소에서만 동작하도록 설계할 예정
@Component
public class AuthInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		// 세션 여부 확인
		HttpSession session = request.getSession();
		Object user = session.getAttribute("user");
		
		System.out.println("Request URI : " + request.getRequestURI()); // 요청 URI
		System.out.println("Request Method : " + request.getMethod()); // REST API Method
		
		if (user == null) {
			// System.out.println("미인증 사용자");
			response.sendRedirect("/loginPage");
			return false;
		}
		// true면 컨트롤러로 보냄
		// false면 컨트롤러로 보내지 않음
		return true;
	}
	
}
