package com.green.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@Controller
public class blogController {

	@GetMapping({"/", "blog"})
	public String blogPage(Model model, @RequestParam(required = false, defaultValue = "0") String menu) {
		int postCount = 0;
		int rowCount = 0;
		int colCount = 0;
		String menuName = "";
		int pageCount = 1;
		
		// 파이썬 (12)
		if ("1".equals(menu)) {
			menuName = "Python";
			postCount = 12;
			
			// 행 개수
			rowCount = (int) Math.ceil(postCount / 4.0);
			System.out.println("행 개수 : " + rowCount);
			
			// 페이지 개수
			if (rowCount > 4) {
				pageCount = (int) Math.ceil(rowCount / 4.0);
			}
			
			// 마지막 행의 열 개수
			colCount = postCount % 4; // 0 ~ 3
			System.out.println("마지막 열 개수 : " + colCount);
			
		// 자바 (2)
		} else if ("2".equals(menu)) {
			menuName = "Java";
			postCount = 2;
			
			// 행 개수
			rowCount = (int) Math.ceil(postCount / 4.0);
			System.out.println("행 개수 : " + rowCount);
			
			// 페이지 개수
			if (rowCount > 4) {
				pageCount = (int) Math.ceil(rowCount / 4.0);
			}
			
			// 마지막 행의 열 개수
			colCount = postCount % 4; // 0 ~ 3
			System.out.println("마지막 열 개수 : " + colCount);
			
		// los (8)
		} else if ("3".equals(menu)) {
			menuName = "los";
			postCount = 8;
			
			// 행 개수
			rowCount = (int) Math.ceil(postCount / 4.0);
			System.out.println("행 개수 : " + rowCount);
			
			// 페이지 개수
			if (rowCount > 4) {
				pageCount = (int) Math.ceil(rowCount / 4.0);
			}
			
			// 마지막 행의 열 개수
			colCount = postCount % 4; // 0 ~ 3
			System.out.println("마지막 열 개수 : " + colCount);
			
		// 소프트웨어 (26)
		} else if ("4".equals(menu)) {
			menuName = "소프트웨어 자료";
			postCount = 26;
			
			// 행 개수
			rowCount = (int) Math.ceil(postCount / 4.0);
			System.out.println("행 개수 : " + rowCount);
			
			// 페이지 개수
			if (rowCount > 4) {
				pageCount = (int) Math.ceil(rowCount / 4.0);
			}
			
			// 마지막 행의 열 개수
			colCount = postCount % 4; // 0 ~ 3
			System.out.println("마지막 열 개수 : " + colCount);
			
		// 자료구조 (8)
		} else if ("5".equals(menu)) {
			menuName = "자료구조";
			postCount = 8;
			
			// 행 개수
			rowCount = (int) Math.ceil(postCount / 4.0);
			System.out.println("행 개수 : " + rowCount);
			
			// 페이지 개수
			if (rowCount > 4) {
				pageCount = (int) Math.ceil(rowCount / 4.0);
			}
			
			// 마지막 행의 열 개수
			colCount = postCount % 4; // 0 ~ 3
			System.out.println("마지막 열 개수 : " + colCount);
			
		// 리눅스 (8)
		} else if ("6".equals(menu)) {
			menuName = "리눅스";
			postCount = 8;
			
			// 행 개수
			rowCount = (int) Math.ceil(postCount / 4.0);
			System.out.println("행 개수 : " + rowCount);
			
			// 페이지 개수
			if (rowCount > 4) {
				pageCount = (int) Math.ceil(rowCount / 4.0);
			}
			
			// 마지막 행의 열 개수
			colCount = postCount % 4; // 0 ~ 3
			System.out.println("마지막 열 개수 : " + colCount);
			
		// Git (4)
		} else if ("7".equals(menu)) {
			menuName = "Git";
			postCount = 4;
			
			// 행 개수
			rowCount = (int) Math.ceil(postCount / 4.0);
			System.out.println("행 개수 : " + rowCount);
			
			// 페이지 개수
			if (rowCount > 4) {
				pageCount = (int) Math.ceil(rowCount / 4.0);
			}
			
			// 마지막 행의 열 개수
			colCount = postCount % 4; // 0 ~ 3
			System.out.println("마지막 열 개수 : " + colCount);
			
		// 자기계발 (3)
		} else if ("8".equals(menu)) {
			menuName = "자기계발";
			postCount = 3;
			
			// 행 개수
			rowCount = (int) Math.ceil(postCount / 4.0);
			System.out.println("행 개수 : " + rowCount);
			
			// 페이지 개수
			if (rowCount > 4) {
				pageCount = (int) Math.ceil(rowCount / 4.0);
			}
			
			// 마지막 행의 열 개수
			colCount = postCount % 4; // 0 ~ 3
			System.out.println("마지막 열 개수 : " + colCount);
		
		// 경영전략 (20)
		} else if ("9".equals(menu)) {
			menuName = "경영전략";
			postCount = 20;
			
			// 행 개수
			rowCount = (int) Math.ceil(postCount / 4.0);
			System.out.println("행 개수 : " + rowCount);
			
			// 페이지 개수
			if (rowCount > 4) {
				pageCount = (int) Math.ceil(rowCount / 4.0);
			}
			
			// 마지막 행의 열 개수
			colCount = postCount % 4; // 0 ~ 3
			System.out.println("마지막 열 개수 : " + colCount);
			
		// 리더쉽 (7)
		} else if ("10".equals(menu)) {
			menuName = "리더쉽";
			postCount = 7;
			
			// 행 개수
			rowCount = (int) Math.ceil(postCount / 4.0);
			System.out.println("행 개수 : " + rowCount);
			
			// 페이지 개수
			if (rowCount > 4) {
				pageCount = (int) Math.ceil(rowCount / 4.0);
			}
			
			// 마지막 행의 열 개수
			colCount = postCount % 4; // 0 ~ 3
			System.out.println("마지막 열 개수 : " + colCount);
			
		// 전체보기
		} else if ("0".equals(menu)) {
			menuName = "전체보기";
			postCount = 98;
			
			// 행 개수
			rowCount = (int) Math.ceil(postCount / 4.0);
			System.out.println("행 개수 : " + rowCount);
			
			// 페이지 개수
			if (rowCount > 4) {
				pageCount = (int) Math.ceil(rowCount / 4.0);
			}
			
			// 마지막 행의 열 개수
			colCount = postCount % 4; // 0 ~ 3
			System.out.println("마지막 열 개수 : " + colCount);
			
		}
			
		model.addAttribute("menu", menu);
		model.addAttribute("menuName", menuName);
		model.addAttribute("postCount", postCount);
		model.addAttribute("rowCount", rowCount);
		model.addAttribute("colCount", colCount);
		model.addAttribute("pageCount", pageCount);
		
		return "blog";
	}
	
}
