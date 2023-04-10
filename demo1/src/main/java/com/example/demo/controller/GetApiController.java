package com.example.demo.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserRequest;

@RestController // <- JSON 방식으로 응답 처리
@RequestMapping("/api") // url 매핑
public class GetApiController {

	// 쿼리 파라미터 방식으로 key-value 구조의 데이터 파싱 처리
	// 주소 : http://localhost:8080/api/queryParam1?name=이름
	@GetMapping("/queryParam1") // 매개변수랑 쿼리파라미터 key명이랑 같게
	public String queryParam1(@RequestParam String name) {
		
		return "name : " + name;
	}

	// 쿼리 파라미터 방식으로 주소 설계를 했다면 요청 시에 정확히 맞춰 주어야 함
	// :: 입력되지 않은 요소가 있다면 오류 발생
	// -> 선택적 요소로 설정하는 옵션 존재 (기본값 설정 필요)
	// 주소 : http://localhost:8080/api/queryParam2?name=홍아&age=10	
	@GetMapping("/queryParam2")
	public String queryParam2(@RequestParam String name, 
			@RequestParam(required = false, defaultValue = "0") int age) {
		
		return "name, age : " + name;
	}
	
	// --------------------------------------------------
	
	// Map 구조의 데이터 파싱 처리
	
	// key-value를 자유롭게 추가하면서 사용할 수 있음
	@GetMapping("/queryParam3")
	public String queryParam3(@RequestParam Map<String, String> data) {
		
		StringBuilder sb = new StringBuilder();
		
		data.entrySet().forEach(entry -> {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
			sb.append(entry.getKey() + "=" + entry.getValue());
		});
		
		return sb.toString() ;
	}

	// --------------------------------------------------
	
	// DTO 객체의 데이터 파싱 처리
	
	// 메세지 컨버터(잭슨)가 동작해서 자동으로 파싱 처리를 해주어서 자료형도 알아서 처리됨
	// DTO 방식으로 할 때에는 매개변수에 @RequestParam 붙이지 않기
	// DTO에 해당 속성 값이 없으면 그 값에 대해서는 파싱을 하지 않음 (setter 메서드를 사용하기 때문)
	// 주소 : http://localhost:8080/api/queryParam4?name=홍아&age=10&email=a@naver.com
	@GetMapping("/queryParam4")
	public String queryParam4(UserRequest userDto) {
		System.out.println(userDto.getName());
		System.out.println(userDto.getAge());
		System.out.println(userDto.getEmail());
		return userDto.toString();
	}
	
	// --------------------------------------------------
	
	// pathVariable 방식의 사용
	// 주소 : http://localhost:8080/api/path-variable/10
	@GetMapping("/path-variable/{userId}")
	public String pathVariable1(@PathVariable int userId) {
		return "userId " + userId;
	}
	
	// 변수명을 똑같이 사용할 수 없는 경우, 옵션으로 실제 name을 따로 지정해줄 수 있음
	// 변수명은 'mName'이지만, {name} 자리에서 가져옴 (메서드 내에서만 mName이라고 사용)
	@GetMapping("/path-variable2/{name}")
	public String pathVariable2(@PathVariable(name = "name") String mName) {
		
		return "name " + mName;
	}
	
	// 여러 pathVariable을 연결해서 사용
	// 주소 : http://localhost:8080/api/users/3/orders/10
	@GetMapping("/users/{userId}/orders/{orderId}") // 값을 붙여서 쓸 수도 있지만 직관성이 떨어져서 이렇게
	public String getOrder(@PathVariable int userId,
			@PathVariable int orderId) {
		
		return "userId : " + userId + ", orderId : " + orderId;
	}
	
	// --------------------------------------------------
	
	// DTO 방식으로 할 때에는 매개변수에 @PathVariable 붙이지 않기
	// DTO 안에 매핑할 변수와 키 값이 같아야 함
	// 주소 : http://localhost:8080/api/name/흥아
	@GetMapping("/name/{name}") // dto의 멤버 변수 이름과 같게
	public UserRequest getUser(UserRequest dto) {
		
		UserRequest userRequest = new UserRequest();
		userRequest.setName(dto.getName());
		
		return userRequest;
	}
	
}