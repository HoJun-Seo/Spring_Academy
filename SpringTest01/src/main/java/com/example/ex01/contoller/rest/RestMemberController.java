package com.example.ex01.contoller.rest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.ex01.model.dto.MemberDTO;
import com.example.ex01.service.member.MemberService;

@RequestMapping("/rest/member")
@RestController
public class RestMemberController {
	private static final Logger logger = LoggerFactory.getLogger(RestMemberController.class);
	
	@Inject
	MemberService memberService;
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<MemberDTO>> list(){
		logger.info("member list 메소드 호출");
		
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		list = memberService.list();
		for(int i = 0; i < 5; i++) {
			MemberDTO dto = new MemberDTO();
			dto = list.get(i);
			logger.info("회원 정보 : " + (i+1) + "번째 : " + dto.toString());
			
			list.add(dto);
		}
		logger.info("member list : " + list);
		
		return new ResponseEntity<List<MemberDTO>>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value = "{num}", method = RequestMethod.GET)
	public ResponseEntity<MemberDTO> findMember(@PathVariable("num") String userid){
		MemberDTO dto = new MemberDTO();
		dto = memberService.detail(userid);
		
		logger.info("아이디 : " + dto.getUserid());
		logger.info("비밀번호 : " + dto.getPasswd());
		logger.info("닉네임 : " + dto.getName());
		logger.info("이메일 : " + dto.getEmail());
		logger.info("가입일 : " + dto.getJoin_date());
		
		return new ResponseEntity<MemberDTO>(dto, HttpStatus.OK);
	}
	
	@RequestMapping(value = "{num}", method = RequestMethod.POST)
	public ResponseEntity<String> addMember(@PathVariable("num") String userid,@RequestBody MemberDTO dto){
		
		ResponseEntity<String> resEntity = null;
		try {
			logger.info("json 형식의 데이터가 넘어왔음");
			logger.info("PathVariable : " + userid);
			logger.info(dto.toString());
			resEntity = new ResponseEntity<String>("ADD_SUCCEEDED", HttpStatus.OK);
			
		}catch (Exception e) {
			e.printStackTrace();
			resEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return resEntity;
	}
}
