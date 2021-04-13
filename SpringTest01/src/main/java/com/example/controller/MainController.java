package com.example.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.dto.PointDTO;

// 스프링에서 관리하는 Controller임을 의미
@Controller
public class MainController {	
	
	// URL 맵핑
	@RequestMapping("/")
	public String main(Model model) {
		System.out.println("요청 승인:");
		
		// request.setAttribute("","");
		model.addAttribute("name","홍길동");
		model.addAttribute("message","스프링 시작페이지에 방문을 환영합니다.");
		
		// 포워딩 : 접두사: "/WEB-INF/views/"+"main"+ ".jsp"
		return "main";
	}
	
	// 폼(view페이지) 데이터 전달 방법
	// @requestParam : 개별 변수 전달
	@RequestMapping("gugu.do")
	public String gugu() {
		return "test/gugu";
	}
	
	@RequestMapping("gugu_result.do")
	public String gugu_result(
						@RequestParam(defaultValue = "3") int dan, 
						Model model) {
		
		System.out.println("dan:"+dan);
		
		String result = "";
		for (int i=1; i<=9; i++) {
			result += dan + "*"+i+"="+(dan*i)+"<br>";
		}
		
		model.addAttribute("result",result);
		return "test/gugu_result";
	}
	
	// 폼(view) 데이터 전달 방법 : @ModelAttribute(모델 클래스로 한꺼번에 전달)
	@RequestMapping("point.do")
	public String point() {
		return "test/point";
	}
	
	@RequestMapping("point_result.do")
	public String point_result(@ModelAttribute PointDTO dto, Model model) {
		// 폼에 넘어오는 매개변수와 멤버 변수가 일치해야 자동 매핑된다.
		
		return "test/point_result";
	}
}
