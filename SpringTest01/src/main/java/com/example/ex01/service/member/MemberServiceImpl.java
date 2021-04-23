package com.example.ex01.service.member;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.ex01.model.member.dao.MemberDAO;
import com.example.ex01.model.member.dto.MemberDTO;

;

// 서비스 클래스는 @Service어노테이션이 반드시 있어야 스프링이 서브로 관리됨.
@Service
public class MemberServiceImpl implements MemberService {

	@Inject
	MemberDAO memberDao;
	// MemberDAO memberDao = new MemberDAOImpl();
	
	
	@Override
	public List<MemberDTO> list() {
		return memberDao.list();
	}

	@Override
	public void insert(MemberDTO dto) {
		memberDao.insert(dto);
	}

	@Override
	public MemberDTO detail(String userid) {
		return memberDao.detail(userid);
	}

	@Override
	public void delete(String userid) {
		memberDao.delete(userid);
	}

	@Override
	public void update(MemberDTO dto) {
		memberDao.update(dto);
	}

	@Override
	public boolean check_passwd(String userid, String passwd) {
		return memberDao.check_passwd(userid, passwd);
	}

}
