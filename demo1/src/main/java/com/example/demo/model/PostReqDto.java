package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor // 기본 생성자
@AllArgsConstructor // 모든 멤버변수가 포함 생성자 (몇 개만 포함하려면 직접 생성하기)
public class PostReqDto {
	
	private String name;
	private String email;
	private int age;
	private int hobby;			  // Json에서는 "phone_number"로 보내도 phoneNumber로 인식하게 함
	@JsonProperty("phone_number") // 대신 이거 설정하면 "phoneNumber"로 보내면 인식 못함
	private int phoneNumber;
	
}
