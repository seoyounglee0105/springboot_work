package com.example.demo9.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo9.dto.User;

@Controller
public class UserController {
	
	// 1. 로그인 페이지를 직접 URL로 요청해서 응답받을 수 있음 (기본)
	// 2. 로그인 페이지를 controller를 타서 응답 처리해보자.
	@GetMapping("/login-page")
	public String login() {
		
		return "login.html";
	}
	
	@PostMapping("/login-proc")      // 필요하면 정의해서 사용
	public String loginProc(HttpServletRequest request, HttpServletResponse response, User user) {
		
		// 세션 저장 후 myInfo 페이지 이동 처리
		HttpSession session = request.getSession();
		System.out.println("user : " + user);
		session.setAttribute("user", user);
//		response.sendRedirect("/mypage/myinfo");
		// 위와 동일한 효과
		return "redirect:/mypage/myinfo.html";
	}
	
	// http://localhost:8080/mypage/myinfo
	// myInfo 설계
	@GetMapping("/mypage/myinfo")
	public String myInfo() {
		// 인증이 필요한 페이지로 만들기로 함
		return "mypage/myinfo.html";
	}
	
	@GetMapping("/mypage/cart")
	public String cart() {
		return "mypage/cart.html";
	}
	
}
