package com.example.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.dao.MemberDAO;
import com.example.dao.MemberDAOImpl;
import com.example.dto.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService{

	@Inject
	MemberDAO memberDAO;
	
	@Override
	public List<MemberDTO> list() {
		return memberDAO.list();
	}

	@Override
	public void insert(MemberDTO dto) {
		memberDAO.insert(dto);
	}

	@Override
	public MemberDTO detail(String userid) {
		return memberDAO.detail(userid);
	}

	@Override
	public void delete(String userid) {
		memberDAO.delete(userid);
	}

	@Override
	public void update(MemberDTO dto) {
		memberDAO.update(dto);
	}

	@Override
	public boolean check_passwd(String userid, String passwd) {
		return memberDAO.check_passwd(userid, passwd);
	}
	
	
}
