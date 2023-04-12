package com.example.demo4.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo4.dto.User;

				//IoC 관리 대상이 됨 -> Spring container에 들어감
@RestController // -> 해당 클래스는 싱글톤 패턴으로, 'BEAN' 객체가 됨
@RequestMapping("/api")
public class RestApiController {

	@GetMapping("/get/{id}")
	public void get(@PathVariable Long id) {
		System.out.println("method : get");
		System.out.println("id : " + id);
	}
	
	@PostMapping("/post")
	public ResponseEntity<User> post(@RequestBody User user) {
		System.out.println("method : post");
		System.out.println("user : " + user.toString());
		
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}
	
	
	
}
