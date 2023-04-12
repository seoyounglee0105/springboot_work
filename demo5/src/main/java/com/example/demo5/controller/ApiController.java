package com.example.demo5.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo5.dto.User;

@RestController
@RequestMapping("/api")
public class ApiController {

	// 주소 : http://localhost:8080/api/user
	@PostMapping("/user")
	public ResponseEntity<User> user(@RequestBody User user) {
		// Spring Boot에서 요청 시 데이터 기본 파싱 전략 : key-value 구조
		// dto 방식 <- Object mapper가 알아서 매핑해서 자동 파싱 처리해줌
		// 유효성 검사
		// 예전 방식 : 방어적 코드
		if (user.getAge() < 1 || user.getAge() > 100) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(user);
		}
		
		// 서비스를 만듦 (로직) -> DAO로 던짐 -> DB insert 처리
//		return ResponseEntity.status(HttpStatus.OK).body(user);
		
		User user2 = User.builder()
					.email(user.getEmail())
					.age(user.getAge())
					.phoneNumber(user.getPhoneNumber())
					.build();
				
		return ResponseEntity.ok(user2);
	}
	
	
	// AOP 기반인 Validation 라이브러리 활용해서 유효성 검사하기
	// GET/DELETE 방식일 때 사용 방법과 POST/PUT 방식일 때 사용 방법이 약간 다름 (바디 유무에 따라)
	// 반드시 유효성 검사를 하겠다는 의미인 @Valid 선언을 해주어야 함
	
	@PostMapping("/user2")
	public ResponseEntity<User> user2(@Valid @RequestBody User user) {
		// 관점 지향 패러다임 추가
		// AOP 기반의 Valid 라이브러리를 활용하면 공통적으로 들어가야 하는 부분의 코드를 분리시킬 수 있음
		
		return ResponseEntity.ok(user);
	}
	
	
	// Validation 심화 과정
	// BindingResult 클래스를 배워 보자.
	
	// BindingResult는 @Valid에 대한 결과 값을 가지고 있음
	@PostMapping("/user3")
	public ResponseEntity<?> user3(@Valid @RequestBody User user,
			BindingResult bindingResult) {
		
		// 에러가 있다면
		if (bindingResult.hasErrors()) {
			// 응답 HTTP 메시지 body에 보낼 문자열
			StringBuilder sb = new StringBuilder();
			
			// 모든 에러를 담은 리스트 (스트림 연산 활용)
			// forEach()는 .stream()을 생략해도 정상 작동함
			bindingResult.getAllErrors().forEach(error -> {
				// 에러가 발생한 필드 확인
				System.out.println(error.getCode());
				
				// 에러 발생 시 메세지 확인
				System.out.println(error.getDefaultMessage());
				
				// 에러가 발생한 객체명 확인
				System.out.println(error.getObjectName());
				
				sb.append("field : " + error.getCode()); // 에러가 발생한 필드
				sb.append("\n");
				sb.append("message : " + error.getDefaultMessage()); // 에러 시 메세지
				sb.append("\n");
			});
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sb.toString());
		}
		
		// 에러가 없다면
		return ResponseEntity.ok(user);
	}
	
}
