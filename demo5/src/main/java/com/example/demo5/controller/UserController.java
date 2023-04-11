package com.example.demo5.controller;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo5.dto.User;

@RestController
@Validated // <- GET 방식일 때에는 컨트롤러 상단부에 @Validated를 반드시 지정
public class UserController {
	
	// GET 방식일 때, 파라미터 앞에 어떤 유효성 검사를 할지 지정해주어야 함

	// http://localhost:8080/user?name=홍&age=1
	// GET 방식일 때 Valid 처리
	@GetMapping("/user") // 이름 최소 길이 2                        // not null, 최솟값 1 
	public User user(@Size(min = 2) @RequestParam String name, @NotNull @Min(1) @RequestParam Integer age) {
		User user = new User();
		user.setAge(age);
		user.setName(name);
		return user;
	}
	
	@GetMapping("/user2")
	// object mapper를 통해서 파싱 처리하고 싶다면
	public User user2(@Valid User user) {
		
		return user;
	}
	
}
