package com.example.demo9.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AuthInterceptor implements HandlerInterceptor {

	// myInfo 이동 시 세션 여부 확인 (controller 들어가기 전에 가로채기)
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		// 사용자가 로그인을 하면 세션 메모리 영역에 user key=value 구조로 저장 처리할 예정
		Object user = session.getAttribute("user");
		System.out.println("preHandle 동작 확인");
		if (user == null) {
			response.sendRedirect("/login-page");
			return false;
		} 
		
		return true;
	}
	
}
