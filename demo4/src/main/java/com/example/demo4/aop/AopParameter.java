package com.example.demo4.aop;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect // AOP 클래스로 설정
@Component // IoC의 관리 대상으로 지정 (싱글톤으로 BEAN 객체가 됨)
public class AopParameter {
	
	// 포인트 컷
								// execution 표현식
	// 매개변수로 role 설정  * 패키지명.controller ~
	                       // * : 모든 접근 제어 지시자를 사용하겠다
						   // controller 아래에 있는 모든 것들을 지켜보겠다
	@Pointcut("execution(* com.example.demo4.controller..*.*(..))")
	private void cut() {
		
	}
	
	// controller 패키지 내의 BEAN 객체들을 지켜보고 있다가,
	// controller가 실행되면 before 메서드를 먼저 실행한 후에
	// controller 메서드를 실행함
	
	// cut() 메서드가 실행되는 지점 이전에 before() 메서드를 실행
	@Before("cut()")  // before() 메서드를 먼저 실행한 후에 cut() 메서드 실행
	public void before(JoinPoint joinPoint) {
		
		// controller -> /api/get 호출하기 전에 수행되는 녀석
		// 어떤 메서드(get, post, put, delete)가 수행되었는지 알아보는 방법
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		Method method = methodSignature.getMethod();
		
		System.out.println("사용된 method 확인");
		System.out.println("method : " + method.getName());
		
		// 매개변수 확인
		Object[] args = joinPoint.getArgs();
		for (Object obj : args) {
			// 매개변수 타입
			System.out.println("type : " + obj.getClass().getSimpleName()); // 리플렉션 기법 (getClass
			// 매개변수 값
			System.out.println("value : " + obj);
		}
		
		// before 메서드 수행 시점 확인용
		System.out.println("before 수행 완료 ----");
	}
	
	// value : cut() 메서드를 돌릴 때  // returning : 리턴 타입
	@AfterReturning(value = "cut()", returning = "obj")
	public void afterReturn(JoinPoint joinPoint, Object obj) {
		System.out.println("==============");
		System.out.println("return obj");
		System.out.println("obj " + obj);
	}
	
}
