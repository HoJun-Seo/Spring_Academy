package com.example.webapp;


import java.util.Iterator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

// 스프링에서 관리하는 Controller 임을 의미
@Controller
public class MainController {
	
	//url 매핑하는 어노테이션
	@RequestMapping("/")
	public String main(Model model) {
		// "/" 요청하면 main() 메소드를 수행
		
		System.out.println("요청 승인");
		
		// request.setAttribute("","");
		model.addAttribute("name", "홍길동");
		model.addAttribute("message", "스프링 시작 페이지에 방문을 환영합니다.");
		
		// 포워딩 : 접두사 : "/WEB-INF/views/" + main + ".jsp" => /WEB-INF/views/main.jsp
		return "main";
	}
	
	// 폼(view 페이지) 데이터 전달 방법
	// @requestParam : 개별 변수 전달
	@RequestMapping("gugu.do")
	public String gugu() {
		return "test/gugu";
	}
	
	@RequestMapping("gugu_result.do")
	public String gugu_result(@RequestParam(defaultValue = "3") int dan, 
			Model model) {
		System.out.println("dan : " + dan);
		
		String result="";
		for(int i = 1; i <= 9; i++) {
			result += dan + "*" + i + "=" + (dan*i) + "<br>";
		}
		model.addAttribute("result", result);
		return "test/gugu_result";
	}
}
