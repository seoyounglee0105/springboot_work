package com.example.demo2.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class) // JsonProperty는 각 변수 단위 적용, 이거는 클래스 단위 (JSON 시 스네이크 표기법으로 전환)
public class CarDto {
	private String carName;
	private String carNumber;
}
