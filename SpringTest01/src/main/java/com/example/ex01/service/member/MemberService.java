package com.example.ex01.service.member;

import java.util.List;

import com.example.ex01.model.member.dto.MemberDTO;


public interface MemberService {
	
	public List<MemberDTO> list();
	public void insert(MemberDTO dto);
	public MemberDTO detail(String userid);
	public void delete(String userid);
	public void update(MemberDTO dto);
	public boolean check_passwd(String userid, String passwd);
	
}

