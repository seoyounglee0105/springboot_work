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


@Slf4j // 로깅을 사용할 수 있는 라이브러리
@Component // 1개의 객체만 bean으로 지정
public class GlobalFilter implements Filter { 

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
	
		// 로깅 처리 : 요청 URI을 콘솔 창에서 먼저 확인
		HttpServletRequest httpRequest = (HttpServletRequest) request; // ServletRequest에서 HttpServletRequest로 다운 캐스팅
		HttpServletResponse httpResponse = (HttpServletResponse) response; // request에 맞게 response도 다운 캐스팅
		
		log.info("요청 URI : {}", httpRequest.getRequestURI()); // {}에 매핑되어 들어감
		
		chain.doFilter(httpRequest, httpResponse); // 이거 없으면 컨트롤러로 안 넘어감
		
		log.info("응답 상태 : {}", httpResponse.getStatus()); 
		
	}

}
