package com.example.demo10.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo10.dto.User;


// login.html 파일에는 누구나 접근할 수 있는 페이지로 만들기
// mypage/myInfo.html 파일에는 인증된 사용자만 접근하게 만들기
// mypage/cart.html 파일에는 인증된 사용자만 접근하게 만들기

@Controller
public class UserController {
	
	@GetMapping("/loginPage")
	public String loginPage() {
		
		return "login.html"; // 내부에서 이동
	}
	
	// 인증된 사용자만 들어올 수 있게 막기
	// AuthInterceptor를 동작시키려면 URI 매핑 설계를 /auth/**로 해야 함
	
	@GetMapping("/auth/infoPage")
	public String infoPage(HttpServletRequest request) {
				
		System.out.println("여기 코드 실행하려면 로그인 필요");
		// 상대 위치로 들어왔으면 : 현재 그 시점에서 맞게 설계
		// 상대 경로 or 절대 경로 결정
		return "/info.html";
	}
	
	@PostMapping("/loginProc") // 필요하면 정의해서 사용
	public String loginProc(HttpServletRequest request, HttpServletResponse response, User user) {
		
		// 세션 저장 후 myInfo 페이지 이동 처리
		request.getSession().setAttribute("user", user);
		System.out.println(user);
		
		// redirect : 사용자(브라우저)로 돌아 갔다 옴
		//            == 새로운 request, response 객체가 만들어짐
		// response.sendRedirect("/auth/infoPage");
		// 위와 동일한 효과
		return "redirect:/auth/infoPage";
	}
}
