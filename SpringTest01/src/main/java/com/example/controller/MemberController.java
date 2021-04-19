package com.example.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		model.addAttribute("list", list);
		return "member/mysql_list";
	}
	
	// 회원 정보 등록
	@RequestMapping("mysql_write.do")
	public String write() {
		return "member/mysql_write";
	}
	
	@RequestMapping("insert.do")
	public String insert(@ModelAttribute MemberDTO dto) {
		dao.insert(dto);
		return "redirect:/member/mysql_list.do";
	}
	
	// 회원 정보삭제
	@RequestMapping("mysql_delete.do")
	public String delete(@RequestParam String userid, String passwd, Model model) {
		boolean result = dao.check_passwd(userid, passwd);
		if(result) {
			dao.delete(userid);
			return "redirect:/member/list.do";
		} else {
			model.addAttribute("message", "비밀번호가 일치하지 않습니다.");
			model.addAttribute("dto", dao.detail(userid));
			
			return "member/detail";
		}
	}
}
