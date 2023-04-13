package com.example.demo8.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*
 * 
 * 1. WebMvcConfigurer 구현 처리
 * 2. addInterceptors 구현
 *
 */

@Configuration // 1개 이상의 객체를 bean으로 등록해야 할 때 (WebMvcConfig, LoggingInterceptor)
public class WebMvcConfig implements WebMvcConfigurer {
	
	// DI를 사용하는 코드로 변경해보자.
	@Autowired // DI 자동 적용 (IoC 컨테이너에 있으면 가져옴)
	private LoggingInterceptor loggingInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 우리가 만든 인터셉터 구현 클래스를 등록함
		registry.addInterceptor(loggingInterceptor);
	}
	
}
