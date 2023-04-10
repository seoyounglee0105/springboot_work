package com.example.demo3.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo3.dto.User;

@RestController
@RequestMapping("/api")
public class ApiController {
	
	// http://localhost:80/api/hello : 기존
	// http://localhost/api/hello : 포트번호 80은 생략 가능	
	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}
	
	// MIME TYPE : text/plain으로 응답 처리
	// http://localhost/api/text
	// 응답 결과 -> 응답 : text/plain
	@GetMapping("/text")
	public String text() {
		return "text";
	}
	
	// json 형식으로 응답 처리
	// 엔드포인트 : 로컬호스트 다음 주소
	// ... /api/json
	@PostMapping("/json")
	public User json(@RequestBody User user) {
		System.out.println(user.toString());
		// 응답 타입이 Object type이고, @RestController가 설정되어 있으면 자동으로 json 형식으로 응답 처리됨
		return user;
	}
	
	// ResponseEntity 중요 !
	@PutMapping("/put")
	public ResponseEntity<User> put(@RequestBody User user) {
		System.out.println(user.toString());
		// HTTP 메세지 코드를 200으로 세팅한 것
		// HTTP 메세지 바디의 데이터를 user object로 그대로 반환
		return ResponseEntity.status(HttpStatus.CREATED).body(user); // 상태 코드를 마음대로 변경할 수 있음
	}
	
	/*
	 * 백엔드 개발자 위치
	 * 클라이언트 (모바일) --> 요청 (HTTP 통신)
	 * 데이터로 반환 처리 (JSON 형식)
	 * 매번 새로운 요청마다 다른 형식으로 리턴을 해주면 API를 계속 개발해야 함
	 * 일괄적인 형식을 만들어서 던져주면 API 개발이 편해짐 (표준)
	 * ResponseEntity 
	 */
	
	@PutMapping("/put2")
	public ResponseEntity<String> put2(@RequestBody User user) {
		
		// 비즈니스 로직
		// 정상적인 값이 들어왔는지 확인 (문법 체크), 인증된 사용자인지 확인
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.TEXT_PLAIN);
		
		// HttpStatus.CREATED (201) : 생성, 수정
		return new ResponseEntity<>(user.toString(), headers, HttpStatus.CREATED);
	}
	
	@PostMapping("/post1")
	public ResponseEntity<String> post1(@RequestBody User user) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.TEXT_PLAIN);
		return new ResponseEntity<>(user.toString(), headers, HttpStatus.OK);
	}
	
}
