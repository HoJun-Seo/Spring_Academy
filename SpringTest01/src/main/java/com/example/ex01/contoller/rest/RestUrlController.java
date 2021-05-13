package com.example.ex01.contoller.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/rest/*")
public class RestUrlController {
	
	// 디버깅 콘솔 출력시 logger 객체 활용 할 것 : 속도 개선 (System.out.println:배제할 것)
	private static  final Logger logger = LoggerFactory.getLogger(RestUrlController.class);
	
	@RequestMapping("json.do")
	public  String json() {
		return "/restjson/jsontest";
	}
	
	@RequestMapping("member/write.do")
	public String write() {
		return "/restjson/jsontest02";
	}
}
