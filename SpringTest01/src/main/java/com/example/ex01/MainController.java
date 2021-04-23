package com.example.ex01;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.ex01.model.dto.PointDTO;
import com.example.ex01.model.dto.ProductDTO;

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
	
	// 폼(view)데이터 전달 방법 : @ModelAttribute(모델 클래스로 한꺼번에 전달)
	@RequestMapping("point.do")
	public String point() {
		return "test/point";
	}
	@RequestMapping("point_result.do")
	public String point_result(@ModelAttribute PointDTO dto, Model model	) {
		// 폼에 넘오는 매개변수와 멤버변수가 일치해야 자동맵핑됨.
		
		// 넘어온 인자값 계산 처리
		dto.setTotal(dto.getKor()+dto.getMat()+dto.getEng());
		dto.setAvg(dto.getTotal()/3.0);
		
		// 자료 저장
		model.addAttribute("dto",dto);
		// 값을 가지고 페이지 이동 (포워딩)
		return "test/point_result";
	}
	
	@RequestMapping("move.do")
	public String  move() throws UnsupportedEncodingException {
		// sendRedirect() 유사
		// Model에 자료를 넣어 보낼수 없음.
		//return "redirect:/redirect_result.do?name=kim&age=20";
		
		String name = "홍길동";
		String charSet = "utf-8";
		String encode_name = URLEncoder.encode(name,  charSet);
		//return "redirect:/redirect_result.do?name="+encode_name+"&age=20";
		return "redirect:/redirect_result.do?name="+URLEncoder.encode("홍길동","utf-8")+"&age=20";
	}
	
	@RequestMapping("redirect_result.do")
	public String redirect_result( String name, int age, Model model) {
		
		model.addAttribute("name",name);
		model.addAttribute("age",age);
		return "test/redirect_result";
	}
	
	// ModelAndView 전달방식 : 값은 하나만 전달 가능(객체 또는 개별데이터)
	// ModelAndView(url, key, value)
	@RequestMapping("modelAndview.do")
	public ModelAndView modelAndview() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("product", new ProductDTO("연필", 1000));
		
		// 자료전달 형식 : 캡키.클래스객체이름.클래스멤버변수
		return new ModelAndView("test/modelAndview","map", map);
		
	}
	
	@RequestMapping("ajax.do")
	public String ajax() {
		return "test/ajax";
	}
	
	// url의 역할 데이터(JSON) 전달 형식은 변환
	@RequestMapping("ajax_background.do")
	public  @ResponseBody ProductDTO    ajax_background() {
		
		ProductDTO dto = new ProductDTO("냉장고", 500000);
		
		// JSON형식의 자료 전송 : url형식이 아님.
		return dto;
	}
	
	@RequestMapping("login.do")
	public String login() {
		return "test/login";
	}
	@RequestMapping("login_result.do")
	public String login_result(String id, String pwd, Model model) {
		String result = "";
		System.out.println("OK...");
		System.out.println("id:"+id);
		System.out.println("pwd:"+pwd);
		
		if (id.equals("kim") && pwd.equals("1234")) {
			result = "kim" + "님 환영합니다.";
		} else {
			result = "아이디 또는 비밀번호가 일치 하지 않습니다.";
		}
		
		model.addAttribute("result", result);
		return "test/login_result";
	}
	
}
















