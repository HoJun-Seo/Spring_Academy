package com.example.controller.upload;

import java.io.File;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UploadController {
	private static final Logger logger = LoggerFactory.getLogger(UploadController.class);
	
	// 파일 업로드 경로 설정
	String uploadPath = "/upload_test";
	
	@RequestMapping(value="/upload/uploadForm", method=RequestMethod.GET)
	public void uploadForm() {
		logger.info("return 값 없으면 url 내용을 가지고 upload/uploadForm.jsp 로 포워딩 됨");
		// return "upload/uploadForm";
	}
	
	@RequestMapping(value="/upload/uploadForm", method=RequestMethod.POST)
	public ModelAndView uploadForm(MultipartFile file, ModelAndView mav) throws Exception{
		logger.info("Post 방식을 url 요청 하였음");
		
		logger.info("파일 이름 : " + file.getOriginalFilename());
		logger.info("파일 크기 : " + file.getSize());
		logger.info("컨텐츠 타입 : " + file.getContentType());
		
		String saveName = file.getOriginalFilename();
		
		// 파일 이름 중복되지 않게 처리
		saveName = uploadFile(saveName, file.getBytes());
		
		mav.setViewName("upload/uploadResult");
		mav.addObject("saveName", saveName);
		return mav;
	}

	public String uploadFile(String saveName, byte[] fileData) {
		
		// 파일 이름 중복 처리되지 않게 처리
		UUID uid = UUID.randomUUID();
		saveName = uid.toString() + "_" + saveName;
		
		return saveName;
	}
}
