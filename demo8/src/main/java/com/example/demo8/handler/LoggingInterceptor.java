package com.example.demo8.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/*
 * 
 * 인터셉터 만들기
 * 1. HandlerInterceptor 구현 처리
 * 2. 세 가지 메서드 기억하기
 *
 */

@Component
public class LoggingInterceptor implements HandlerInterceptor {

	// 컨트롤러 전에
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		System.out.println("----------------------");
		System.out.println("Request URI : " + request.getRequestURI());
		System.out.println("Request Method : " + request.getMethod());
		
		// true면 컨트롤러로 보냄
		// false면 컨트롤러로 보내지 않음
		return true;
	}
	
	// 컨트롤러 후에
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
//		System.out.println("postHandle 호출");
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
//		System.out.println("afterCompletion 호출");
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
	
}
