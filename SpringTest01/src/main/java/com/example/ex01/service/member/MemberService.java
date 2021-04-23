package com.example.ex01.service.member;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.example.ex01.model.dto.MemberDTO;


@Service
public interface MemberService {
	
	public List<MemberDTO> list();
	public void insert(MemberDTO dto);
	public MemberDTO detail(String userid);
	public void delete(String userid);
	public void update(MemberDTO dto);
	public boolean check_passwd(String userid, String passwd);
	
	// 로그인 성공 여부에 따라 session 값 생성
	public String loginCheck(MemberDTO dto, HttpSession session);
	public void logout(HttpSession session);
	
}

