package com.example.demo6.dto;

import lombok.Data;

@Data
public class CustomError {

	private String parameter;
	private String field;
	private String message;
	
}
