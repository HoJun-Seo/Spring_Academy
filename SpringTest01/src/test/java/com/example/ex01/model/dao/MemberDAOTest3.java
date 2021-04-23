package com.example.ex01.model.dao;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.ex01.model.dto.MemberDTO;
import com.example.ex01.service.member.MemberService;

import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})

public class MemberDAOTest3 {
	@Inject
	MemberService dao;
	
	@Test
	public void testList() {
		List<MemberDTO> list = dao.list();
		
		log.info("회원 목록 : "+list);
	}

	//@Test
	public void testInsert() {
		MemberDTO dto = new MemberDTO();
		dto.setUserid("user04");
		dto.setPasswd("1234");
		dto.setName("사용자03");
		dto.setEmail("user03@gmail.com");
		
		dao.insert(dto);
			
	}

	//@Test
	public void testDetail() {
//		dto = dao.detail("user03");
		log.info("회원 정보 : "+dao.detail("user03"));
//		log.info("회원 정보날짜 : "+fd.format(dto.getJoin_date()));		
	}

	//@Test
	public void testDelete() {
		dao.delete("user02");
	}

	//@Test
	public void testUpdate() {
		MemberDTO dto = new MemberDTO();
		dto.setUserid("user02");
		dto.setPasswd("12345");
		dto.setName("사용자002");
		dto.setEmail("suer002@gmail.com");
		
		dao.update(dto);
	}

	//@Test
	public void testCheck_passwd() {
		log.info("아이디 및 비번 체크1 : "+ dao.check_passwd("user02", "12345"));
		log.info("아이디 및 비번 체크2 : "+ dao.check_passwd("user02", "1234"));
		log.info("아이디 및 비번 체크3: "+ dao.check_passwd("user01", "12345"));
		log.info("아이디 및 비번 체크4 : "+ dao.check_passwd("user01", "1234"));
	}

}
