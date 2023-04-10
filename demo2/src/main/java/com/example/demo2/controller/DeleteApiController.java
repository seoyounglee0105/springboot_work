package com.example.demo2.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api2")
public class DeleteApiController {
	
	// 주소 : http://localhost:8080/api2/delete/100?account=우리은행
	@DeleteMapping("/delete/{userId}")
	public void delete(@PathVariable String userId,
					   @RequestParam String account) {
		System.out.println("userId : " + userId);
		System.out.println("account : " + account);
	}
	
	// 주소 : http://localhost:8080/api2/delete2/young?account=우리은행
	@DeleteMapping("/delete2/{userName}")
	public void delete(@PathVariable String userName,
					   @RequestParam Map<String, String> data) {
		System.out.println("userName : " + userName);
		data.entrySet().forEach(e -> {
			System.out.println(e.getKey() + " : " + e.getValue());
		});
	}
	
}
