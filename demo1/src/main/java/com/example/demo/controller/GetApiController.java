package com.example.demo.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserRequest;

// @Controller <- 화면 응답 (HTML (jsp))
@RestController // <- JSON 방식으로 응답 처리 <-- 이걸 붙여줘야 요청 응답 처리 가능한 객체로 변함
@RequestMapping("/api")
public class GetApiController {

	// 주소 설계 - GET 방식
	// http://localhost:8080/api/hello <- path variable 방식

	@GetMapping("/hello")
	public String getHello() {
		return "say hello";
	}

	// key=value 구조의 데이터 파싱 처리
	
	// 쿼리 파라미터 방식으로 데이터를 파싱해서 처리하자
	// http://localhost:8080/api/queryParam1?name=홍아
	@GetMapping("/queryParam1") // 매개변수랑 쿼리파라미터 key명이랑 같게
	public String queryParam1(@RequestParam String name) {
		System.out.println("name : " + name);
		return "name : " + name;
	}

	// http://localhost:8080/api/queryParam2?name=홍아&age=10
	// http://localhost:8080/api/queryParam2?name=홍아
	// 쿼리 스트링 방식으로 주소 설계를 했다면, 요청 시에 정확히 맞춰 주어야 함
	// 아니면 오류 발생 
	// (하지만 선택적 요소로 만드는 옵션이 있음)
	// @RequestParam(required = false, defaultValue = "0") : 필수 요소 아님, 대신 기본값을 지정해주어야 함
	// -> 기본값 : required = true :: 요청 시 값이 들어오지 않으면 기본적으로 오류가 발생함
	@GetMapping("/queryParam2")
	public String queryParam2(@RequestParam String name, 
			@RequestParam(required = false, defaultValue = "0") int age) {
		System.out.println("name : " + name);
		System.out.println("age : " + age);
		return "name, age : " + name;
	}
	
	// Map 사용 방식 구조의 데이터 파싱 처리
	
	// http://localhost:8080/api/queryParam3?name=홍아&age=10&groupId=com.tenco
	// key-value 쌍이 많을 때 편리함
	// key-value를 마음대로 추가하면서 사용할 수도 있음
	// (지정되어 있지 않기 때문임)
	@GetMapping("/queryParam3")
	public String queryParam3(@RequestParam Map<String, String> data) {
		
		StringBuilder sb = new StringBuilder();
		
		data.entrySet().forEach(entry -> {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
			sb.append(entry.getKey() + "=" + entry.getValue());
		});
		
		return "파싱 map 방식의 이해 : " + sb.toString() ;
	}
	
	// Map 활용 메서드 만들어보기
	@GetMapping("/queryParam3b")
	public String queryParam3b(@RequestParam Map<String, Integer> data) {
		
		StringBuilder sb = new StringBuilder();
		
		data.entrySet().forEach(e -> {
			sb.append(e.getKey() + " = " + e.getValue() + "\n");
		});
		
		return sb.toString();
	}
	
	// DTO 객체를 만들어서 데이터 파싱 처리
	
	// 주소 : GET 방식
	// http://localhost:8080/api/queryParam4?name=홍아&age=10&email=a@naver.com
	// 메세지 컨버터(중 하나인 잭슨)가 동작해서 자동으로 파싱 처리를 해주어서 int도 알아서 처리되고 편함
	// DTO 방식으로 할 때에는 매개변수에 @RequestParam 붙이지 말기
	// DTO에 해당 속성 값이 없으면 그 값에 대해서는 파싱을 하지 않음 (setter 메서드를 사용하기 때문)
	@GetMapping("/queryParam4")
	public String queryParam4(UserRequest userDto) {
		System.out.println("dto 방식 동작 처리");
		System.out.println(userDto.getName());
		System.out.println(userDto.getAge());
		System.out.println(userDto.getEmail());
		return userDto.toString();
	}
	
	// pathVariable 방식에 사용
	// http://localhost:8080/api/path-variable/10
	@GetMapping("/path-variable/{userId}")
	public String pathVariable1(@PathVariable int userId) {
		System.out.println("userId : " + userId);
		return "userId " + userId;
	}
	
	// 변수명을 똑같이 사용하지 못할 때 옵션 값을 지정할 수 있ㄷ
	@GetMapping("/path-variable2/{name}") // mName의 진짜 이름을 name이라고 간주 (메서드 내에서만 mName이라고 사용)
	public String pathVariable2(@PathVariable(name = "name") String mName) {
		String name = "내부에서 name 변수명이 있지요";
		return "name " + mName;
	}
	
	// http://localhost:8080/api/users/3/orders/10
	@GetMapping("/users/{userId}/orders/{orderId}") // 값을 붙여서 쓸 수도 있지만 직관성이 떨어져서 이렇게
	public String getOrder(@PathVariable int userId,
			@PathVariable int orderId) {
		
		return "userId : " + userId + ", orderId : " + orderId;
	}
	
	// http://localhost:8080/api/name/흥아
	// DTO 매핑은 @PathVariable 선언 없이 사용하기
	// DTO 안에 매핑할 변수와 키 값이 같아야 함
	@GetMapping("/name/{name}")
	public UserRequest getUser(UserRequest dto) {
		
		UserRequest userRequest = new UserRequest();
		userRequest.setName(dto.getName());
		
		return userRequest;
	}
	
}