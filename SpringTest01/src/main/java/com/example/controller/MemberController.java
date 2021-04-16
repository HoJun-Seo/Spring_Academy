package com.example.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.dao.MemberDAO;
import com.example.dto.MemberDTO;

@RequestMapping("/member/*")
@Controller
public class MemberController {
	
	@Inject // 객체 주입(의존성 주입)
	MemberDAO dao;
	
	@RequestMapping("mysql_list.do")
	public String mysql_list(Model model) {
		List<MemberDTO> list = dao.list();
		model.addAttribute(list);
		return "member/mysql_list";
	}
}
