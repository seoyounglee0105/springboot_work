package com.example.demo10.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
	
	@Autowired
	private AuthInterceptor authInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 동작시킬 때 모든 페이지를 가로채면 무조건 리다이렉트돼서 오류가 남
		// 명시하는 요청 설계 주소에서만 동작해야 함
		
		// 규칙 : 주소 요청이 /auth/**이 붙으면 AuthInterceptor가 동작하도록 구현 처리
		registry.addInterceptor(authInterceptor).addPathPatterns("/auth/**");
		
	}
	
}
