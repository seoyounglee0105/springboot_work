package com.example.demo6.controller;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo6.dto.User;

@Validated
@RestController
@RequestMapping("/api")
public class ApiController {

	@GetMapping("/user")
	public User get(@NotEmpty @Size(min = 1, max = 10) @RequestParam String name, @NotNull @Min(1) @RequestParam Integer age) {
		User user = new User();
		user.setName(name);
		user.setAge(age);
		return user;
	}
	
	// 구분 --> HTTP 메시지 body에 데이터를 전달하는 방식
	// 1. JSON 형식으로 넣어서 서버로 전달 (application/json)
	//    => @RequestBody 선언 필요
	// 2. form 태그 활용해서 key=value 구조로 전달 (Query String 방식으로 만들어짐) (application/...)
	//    => @RequestBody 선언 불필요
	@PostMapping("/user")
	public User post(@Valid @RequestBody User user) {
		System.out.println(user);
		return user;
	}
	
	// 두 번째 연습
	// MIME TYPE : x-www-form-...
	@GetMapping("/user2")
	public User get2(@Validated User reqUser) {
		
		return reqUser;
	}
	
}
