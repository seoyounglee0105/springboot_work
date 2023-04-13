package com.example.demo9.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	@Autowired
	private AuthInterceptor authInterceptor;
	
	@Autowired 
	private CartInterceptor cartInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 동작시킬 때 모든 페이지를 가로채면 무조건 리다이렉트돼서 오류가 남
		// 명시하는 요청 설계 주소에서만 동작해야 함
		// http://localhost:8080/hello <-- 인터셉터 동작 X
		// http://localhost:8080/mypage/myinfo <-- 인터셉터 동작 O
		registry.addInterceptor(authInterceptor)
		.addPathPatterns("/mypage/**"); // mypage 아래에서 요청하는 주소들은 모두 가로채라.
		
		registry.addInterceptor(cartInterceptor)
		.addPathPatterns("/mypage/**");
	}
	
}
