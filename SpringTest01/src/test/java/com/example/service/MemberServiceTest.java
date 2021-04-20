package com.example.service;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.dao.MemberDAOImpl;
import com.example.dto.MemberDTO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/**/root-context.xml")
@Log4j
public class MemberServiceTest {

	@Inject
	MemberDAOImpl testMember;
	
	@Test
	public void testList() {
		log.info("회원 목록 : " + testMember.list());
	}

	@Test 
	public void testInsert() {
		MemberDTO dto = new MemberDTO();
		dto.setUserid("user01");
		dto.setPasswd("1234");
		dto.setName("테스트홍길동");
		dto.setEmail("hong100@gmail.com");
		
		testMember.insert(dto);
	}
	
	@Test 
	public void testDetail() {
		log.info("회원 정보보기 : " + testMember.detail("user01"));
	}
	/*
	 * @Test public void testDelete() { fail("Not yet implemented"); }
	 * 
	 * @Test public void testUpdate() { fail("Not yet implemented"); }
	 * 
	 * @Test public void testCheck_passwd() { fail("Not yet implemented"); }
	 */

}
