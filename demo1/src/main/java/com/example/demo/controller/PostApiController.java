package com.example.demo.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.PostReqDto;

// 웹 컴포넌트
@RestController
@RequestMapping("/api2")
public class PostApiController {
	
	// 클라이언트에서 어떤 값을 보낼지 이미 알고 있음
	// method : POST
	// 시작줄 : http://localhost:8080/api2/post1
	// 클라이언트에서는 json 형식으로 보낼 예정
	@PostMapping("/post1")
	public void post1(@RequestBody Map<String, Object> reqData) {
		reqData.entrySet().forEach(e -> {
			System.out.println("key : " + e.getKey());
			System.out.println("value : " + e.getValue());
		});
	}
	
	// DTO 방식으로 처리 + JSON 형식으로 응답 처리
	@PostMapping("/post2")
	public PostReqDto post2(@RequestBody PostReqDto reqDto) {
		return reqDto;
	}
	
	
	
}                                                                                                                                                                            
