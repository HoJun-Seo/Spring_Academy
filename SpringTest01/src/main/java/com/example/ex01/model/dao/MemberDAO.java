package com.example.ex01.model.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.example.ex01.model.dto.MemberDTO;

public interface MemberDAO {
	
	public List<MemberDTO> list();
	public void insert(MemberDTO dto);
	public MemberDTO detail(String userid);
	public void delete(String userid);
	public void update(MemberDTO dto);
	public boolean check_passwd(String userid, String passwd);
	public String loginCheck(MemberDTO dto);
	public void logout(HttpSession session);
}
