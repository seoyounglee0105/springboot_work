package com.example.demo7.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // View를 처리하는 Controller <- IoC의 대상
public class UserController {
	
	// http://localhost:8080/
	// http://localhost:8080/user
	@GetMapping({"/", "user"}) // 여러 방식으로 매핑 가능
	public String userPage(Model model) {
		
		// tomcat의 루트 폴더 : webapp
		// 원래 경로 : /WEB-INF/view/user.jsp
		
		// application.yml에 설정한 것들
		// prefix : /WEB-INF/view/
		// subfix : .jsp
		// viewResolver가 동작해서 페이지를 찾고 리턴함
		model.addAttribute("principal", "헬로우");
		return "user"; // 파일명만 입력하면 완성됨
	}
	
}
