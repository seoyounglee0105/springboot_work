package com.example.demo6.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

// javax.servlet 패키지의 Filter
@Slf4j
@Component // 1개의 객체만 bean으로 지정
public class GlobalFilter implements Filter { 

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
	
		// 1단계
//		log.error(">> 요청(request)에 대한 앞단 처리");
//		chain.doFilter(request, response); // 이거 해줘야 컨트롤러로 넘어감
//		log.error("<< 응답(response)에 대한 마지막 처리");
		
		// 2단계
		// 로깅 처리 : 요청 URI을 콘솔 창에서 먼저 확인
		HttpServletRequest httpRequest = (HttpServletRequest) request; // ServletRequest에서 HttpServletRequest로 다운 캐스팅
		HttpServletResponse httpResponse = (HttpServletResponse) response; // request에 맞게 response도 다운 캐스팅
		
		log.error("요청 URI : {}", httpRequest.getRequestURI()); // {}에 매핑되어 들어감
		chain.doFilter(httpRequest, httpResponse);
		log.error("응답 상태 : {}", httpResponse.getStatus()); 
	}

}
