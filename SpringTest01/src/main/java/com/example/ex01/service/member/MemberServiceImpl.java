package com.example.ex01.service.member;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.ex01.contoller.shop.ProductController;
import com.example.ex01.model.dao.MemberDAO;
import com.example.ex01.model.dto.MemberDTO;

;

// 서비스 클래스는 @Service어노테이션이 반드시 있어야 스프링이 서브로 관리됨.
@Service
public class MemberServiceImpl implements MemberService {

	private static  final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
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

	@Override
	public String loginCheck(MemberDTO dto, HttpSession session) {
		
		// 조건 검색이 맞으면 이름 넘겨 받고, 실패하면 null
		String name = memberDao.loginCheck(dto);
		if(name != null) {
			// 로그인이 성공이면 세션값 생성
			session.setAttribute("userid", dto.getUserid());
			session.setAttribute("name", name);
			
			/*
			 * logger.info("session : " + session.getAttribute("userid"));
			 * logger.info("session : " + session.getAttribute("name"));
			 */
		}
		return name;
	}

	@Override
	public void logout(HttpSession session) {
		// 세션 초기화
		// session.invalidate();
		
		session.removeAttribute("userid");
		session.removeAttribute("name");
		
		logger.info("로그아웃 했을 경우 userid 값 : " + session.getAttribute("userid"));
		logger.info("로그아웃 했을 경우 userid 값 : " + session.getAttribute("name"));
		
	}

}
