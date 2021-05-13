package com.example.ex01.contoller.rest;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.ex01.model.dto.MemberDTO;
import com.example.ex01.service.member.MemberService;

//@Controller


//  포워딩 방식이 아닌 특정 데이터를 전송하는 방식
@RestController
@RequestMapping("/rest/*")
public class RestFullController {
	// 디버깅 콘솔 출력시 logger 객체 활용 할 것 : 속도 개선 (System.out.println:배제할 것)
	private static  final Logger logger = LoggerFactory.getLogger(RestFullController.class);
	
	@Inject
	MemberService memberService;
	
	
	// 1. 문자열을 브라우저에 전송(전달)
	@RequestMapping("hello")
	public String hello() {
		return "Hello REST!!";
	}
	
	// DTO객체를 브라우저에 전송(전달)
	@RequestMapping("member")
	public MemberDTO member() {
		
		MemberDTO dto = new MemberDTO();
		
		dto.setUserid("kim123");
		dto.setName("홍길동");
		dto.setPasswd("1234");
		dto.setEmail("hong@gmail.com");
		dto.setJoin_date(new Date());
		
		return dto;
	}
	
	// List객체를 브라우저에 전송(전달)
	@RequestMapping("memberlist")
	public List<MemberDTO> member_list(Model model) {
		
		// db에 접속하여 자료를 받아 List객체에 보관
		List<MemberDTO> list = memberService.list();
		
		return list;
	}	
	
	// Map객체를 브라우저에 전송(전달)
	@RequestMapping("memberMap")
	public Map<Integer, MemberDTO> memberMap() {
		
		// map객체 생성
		Map<Integer, MemberDTO> map = new HashMap<Integer, MemberDTO>();
		
		// db에 접속하여 자료를 받아 List객체에 보관
		List<MemberDTO> list = memberService.list();
		for (int i=0; i<list.size(); i++) {
			
			// list구조에 있는 객체을 인덱스 순으로 불러와서 dto객체 보관
			MemberDTO dto = list.get(i);
			
			// dto객체를 map구조에 보관
			map.put(i, dto);
		}
		
		return map;
	}
	
	// @PathVariable 사용하기 : 브라우저에서 요청 URL로 전달된 매개변수를 가져옴
	@RequestMapping(value="pathvar/{num}", method = RequestMethod.GET)
	public int pathvar(@PathVariable("num") int num) throws Exception {
		return num;
	}

	// @RequestBody를 이용해서 JSON데이터를 dto객체로 변환
	@RequestMapping("info")
	public MemberDTO modify(@RequestBody MemberDTO dto) {
		logger.info("dto : "+dto.toString());
		return dto;
	}
	
	
	// ResponseEntity : HTTP 상태 코드를 설정하여 앱(웹)으로 전송할 수 해줌.
	// Map객체를 브라우저에 전송시 HTTP상태 코드 함께 전송(전달)
	@RequestMapping("memberMap2")
	public ResponseEntity<Map<Integer, MemberDTO>>  memberMap2() {
		
		// map객체 생성
		Map<Integer, MemberDTO> map = new HashMap<Integer, MemberDTO>();
		
		// db에 접속하여 자료를 받아 List객체에 보관
		List<MemberDTO> list = memberService.list();
		for (int i=0; i<list.size(); i++) {
			
			// list구조에 있는 객체을 인덱스 순으로 불러와서 dto객체 보관
			MemberDTO dto = list.get(i);
			
			// dto객체를 map구조에 보관
			map.put(i, dto);
		}
		
		return new ResponseEntity<Map<Integer,MemberDTO>>(map, HttpStatus.INTERNAL_SERVER_ERROR);
	}	
	
	// HttpHeaders클래스를 이용해 ResponseEntity로 전송할 데이터의 종류와 한글인코딩을 설정하기
	@RequestMapping("header")
	public ResponseEntity header() {
		
		// HttpHeaders클래스로 객체 생성
		HttpHeaders responseHeaders = new HttpHeaders();
		
		// 전송할 데이터의 종류와 인코딩을 설정
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		
		String message = "<script>";
		message += " alert('새 회원을 등록합니다.'); ";
		message += " location.href='/member/write.do'; ";
		message += "</script>";
		
		return new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
	}
}

/*
 
 화면을 그대로 유지 하면서 필요한 데이터만 전송 받아 빠르게 결과를 표시
 (pc에서 ajax이용하여 data전송하는 방식과 동일)
 
 REST : Representational State Transfer의 약자
 
  => 하나의 URI가 고유한 리소스를 처리하는 공통 방식
 예) /board/112로 요청할 경우 이는 게시글 중 112번째 글을 의미
 
 REST 방식으로 제공되는 API를 REST API or RESTful API라고 한다.
 
 
 REST API 응용
 서버에 데이터를 추가, 수정,삭제 기능을 요청하여 처리 가능
 POST			추가(Create)
 GET				조회(Select)
 PUT				수정(Update)
 DELETE 		삭제(Delete)
 
 /작업명/기본키 + 메서드 + 데이터
  
  * 작업명 : 요청하는 작업의 종류
  * 기본키 : 요청하는 작업에 해당하는 대상의 기본키
  * 메서드 : 요청하는 기능
  * 데이터 :기능 수행에 필요한 JSON 데이터
 
  */
