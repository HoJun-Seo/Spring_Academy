package com.example.ex01.contoller.admin;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.ex01.model.admin.dto.AdminDTO;
import com.example.ex01.service.admin.AdminService;
import com.example.ex01.service.shop.ProductService;

@Controller
@RequestMapping("/admin/*")
public class AdminController {

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Inject
	AdminService adminService;
	@Inject
	ProductService productService;
	
	
	// 관리자 로그인 입력화면
	@RequestMapping("login.do")
	public String login() {
		return "admin/login";
	}
	
	
	// 관리자 로그인 체크
	@RequestMapping("login_check.do")
	public ModelAndView login_check(@ModelAttribute AdminDTO dto, ModelAndView mav, HttpSession session) {
		String name = adminService.loginCheck(dto);
		
		logger.info("관리자 name: "+name);
		
		if (name != null) {
			session.setAttribute("admin_userid", dto.getUserid());
			session.setAttribute("admin_name", name);
			
			session.setAttribute("userid", dto.getUserid());
			session.setAttribute("name", name);
			
			mav.setViewName("admin/admin");
			mav.addObject("message", "success");
			
			logger.info("관리자 로그인");
			logger.info("---------");
			logger.info("admin_userid:"+session.getAttribute("admin_userid"));
			logger.info("admin_name:"+session.getAttribute("admin_name"));
			logger.info("userid:"+session.getAttribute("userid"));
			logger.info("name:"+session.getAttribute("name"));
			logger.info("---------");
			
		} else {
			mav.setViewName("admin/login");
			mav.addObject("message","error");
		}
		return mav;
	}
	
	// 관리자 로그아웃
	@RequestMapping("logout.do")
	public String logout(HttpSession session) {
		// session정보 모두 지우기
		// session.invalidate();
		
		session.removeAttribute("admin_userid");
		session.removeAttribute("admin_name");
		
		session.removeAttribute("userid");
		session.removeAttribute("name");
		
		logger.info("관리자 로그아웃");
		logger.info("---------");
		logger.info("admin_userid:"+session.getAttribute("admin_userid"));
		logger.info("admin_name:"+session.getAttribute("admin_name"));
		logger.info("userid:"+session.getAttribute("userid"));
		logger.info("name:"+session.getAttribute("name"));
		logger.info("---------");
		return "redirect:/admin/login.do";
	}
	
}