package com.example.demo6.handler;

import java.net.BindException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo6.dto.CustomError;

// (비교 : @ControllerAdvice : 페이지 리턴 오류 시 작동)
// Rest API와 관련된 예외 시 작동
@RestControllerAdvice // IoC의 대상이 됨 -> bean 객체
public class GlobalControllerAdvice {
	
	// 모든 예외를 여기서 응답 처리하고 싶다면 (최상위 예외 클래스 : Exception)
	@ExceptionHandler(value = Exception.class) // 어떤 예외가 발생했을 때 처리할지
	public ResponseEntity<?> exception(Exception e) { // 위에서 지정한 예외 타입을 반드시 매개변수로
		
		System.out.println("==============");
		System.out.println(e.getClass());
		System.out.println(e.getMessage());
		System.out.println("==============");
		                                      // 500
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
	}
	
	// 특정 예외를 잡아서 다르게 응답 처리하고 싶다면
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<?> methodArgumentNotValidException(MethodArgumentNotValidException e) { 
		
		StringBuilder sb = new StringBuilder();
	
//		e.getAllErrors().forEach(error -> {
//			String[] errCodes = error.getCodes()[1].toString().split("\\.");
//			System.out.println("유효성 검사 : " + errCodes[0]);
//			System.out.println("잘못된 파라미터 : " + errCodes[1]);
//			System.out.println(error.getDefaultMessage());
//			System.out.println("------------------------------------");
//			
//			sb.append("유효성 검사 : " + errCodes[0]);
//			sb.append("\n");
//			sb.append("잘못된 파라미터 : " + errCodes[1]);
//			sb.append("\n");
//			sb.append(error.getDefaultMessage());
//			sb.append("\n");
//			sb.append("----------------------------------------------\n");
//		});

		List<CustomError> errorList = new ArrayList<>();
		
		e.getAllErrors().forEach(error -> {
			String field = error.getCode();
			String message = error.getDefaultMessage();
			
			CustomError customError = new CustomError();
			customError.setField(field);
			customError.setMessage(message);
			errorList.add(customError);
		});
		
		// 디버깅을 해보고
		// 어떤 필드가 잘못되었는지, 메세지가 무엇인지
		// String 값으로 재정의해서 응답처리해주세요.
		
		System.out.println("잘못된 값을 나에게 전달했어");
		                                      // 400
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorList);
	}
	
	// 특정 예외를 잡아서 다르게 응답 처리하고 싶다면
	@ExceptionHandler(value = HttpMessageNotReadableException.class)
	public ResponseEntity<?> httpMessageNotReadableException(HttpMessageNotReadableException e) { 
		
		System.out.println("제이슨 문법이 잘못됐어");
		                                      // 400
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	}
	
	// 특정 예외를 잡아서 다르게 응답 처리하고 싶다면
	@ExceptionHandler(value = BindException.class)
	public ResponseEntity<?> bindException(BindException e) { 
		
		System.out.println("GET 방식으로 값을 던질 때 잘못 보냈어");
		                                      // 400
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	}
	
}
