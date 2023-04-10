package com.example.demo2.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

public class UserController {

	@GetMapping("/info")
	public void info() {
		System.out.println("여기는 method get 방식입니다.");
	}
	
	@PostMapping("/info")
	public void info2() {
		System.out.println("여기는 method post 방식입니다.");
	}
	
	@PutMapping("/info")
	public void info3() {
		System.out.println("여기는 method put 방식입니다.");
	}
	
	@DeleteMapping("/info")
	public void info4() {
		System.out.println("여기는 method delete 방식입니다.");
	}
}
