package com.example.ex01.contoller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.ex01.model.member.dto.MemberDTO;
import com.example.ex01.service.member.MemberService;



// 공통된 경로을 설정 할 경우 
@RequestMapping("/member/*")
@Controller
public class memberController {
	
	@Inject
	MemberService memberService;
	
	@RequestMapping("list.do")
	public String member_list(Model model) {
		
		List<MemberDTO> list = memberService.list();
		
		model.addAttribute("items",list);
		return "member/list";
	}
	//  회원 정보 등록
	@RequestMapping("write.do")
	public String write() {
		// 입력폼으로 이동(포워딩)
		return "member/write";
	}
	
//	@GetMapping
//	@PostMapping
	@RequestMapping("insert.do")
	public String insert(@ModelAttribute MemberDTO dto) {
		// dto멤버변수와 매개변수 이름이 같아야 자동으로 맵핑됨
		memberService.insert(dto);
		return "redirect:/member/list.do";
	}
	
	// 회원정보 조회
	@RequestMapping("view.do")
	public String view(@RequestParam String userid, Model model) {
		// 회원 정보 조회 db
		model.addAttribute("dto",memberService.detail(userid));
		return "member/detail";
	}
	// 회원정보 수정
	@RequestMapping("update.do")
	public String update(@ModelAttribute MemberDTO dto, Model model) {
		
		boolean result = memberService.check_passwd(dto.getUserid(), dto.getPasswd());
		if (result) {
			memberService.update(dto);
			return "redirect:/member/list.do";
		}else {
			// 가입일자 지지워 지지 않도록 유지
			MemberDTO dto2 = memberService.detail(dto.getUserid());
			
			dto.setJoin_date(dto2.getJoin_date());
			model.addAttribute("dto",dto);
			model.addAttribute("message", "비밀번호가 일치하지 않습니다.");
			 
			return "member/detail";
		}
		
	}
	// 회원 정보 삭제
	@RequestMapping("delete.do")
	public String delete(@RequestParam String userid, String passwd, Model model) {
		
		boolean result = memberService.check_passwd(userid, passwd);
		
		if (result) {
			memberService.delete(userid);
			return "redirect:/member/list.do";
		} else {
			model.addAttribute("message","비밀번호가 일치하지 않습니다.");
			model.addAttribute("dto",memberService.detail(userid));
			
			return "member/detail";
		}
	}
	
	
	
}
