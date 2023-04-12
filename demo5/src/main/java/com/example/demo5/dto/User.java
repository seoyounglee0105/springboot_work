package com.example.demo5.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder // 빌더패턴 자동 생성
public class User {

	private String name;
	@Min(10)
	private int age;
	// message 지정
	@Email(message = "이메일 형식이 틀렸습니다.")
	private String email;
	private String phoneNumber;
	
}
