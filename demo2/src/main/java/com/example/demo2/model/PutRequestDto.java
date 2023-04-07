package com.example.demo2.model;

import java.util.List;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class) // JsonProperty보다 광범위하게 적용 (JSON 시 스네이크 표기법으로 전환)
public class PutRequestDto {
	private String name;
	private String age;
	
	private List<CarDto> carList;
}
