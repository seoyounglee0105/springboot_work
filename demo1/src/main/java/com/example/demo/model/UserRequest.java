package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// DTO
@Getter // <- getter 메서드 다 만들어짐
@Setter // <- setter 메서드 다 만들어짐
@ToString // <- toString 메서드 다 만들어짐
public class UserRequest {
	private String name;
	private int age;
	private String email;
	

	
	
}
