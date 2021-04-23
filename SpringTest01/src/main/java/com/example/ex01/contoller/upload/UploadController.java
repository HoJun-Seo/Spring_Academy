package com.example.ex01.contoller.upload;

import java.io.File;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UploadController {
	
	private static final Logger logger = LoggerFactory.getLogger(UploadController.class);
	
	// 파일 업로드 경로 설정
	String uploadPath = "/upload_test";
	
	//@GetMapping("/upload/uploadForm")
	@RequestMapping(value = "/upload/uploadForm", method = RequestMethod.GET)
	public void uploadForm() {
		logger.info("return 값 없으면 url내용을 가지고 upload/uploadForm.jsp로 포워딩 됨");
		//return "upload/uploadForm";
	}
	
	@RequestMapping(value = "/upload/uploadForm", method = RequestMethod.POST)
	public ModelAndView uploadForm( MultipartFile file, ModelAndView mav) throws Exception {
		logger.info("Post방식을 url 요청 되었음");
		
		logger.info("파일이름 : "+file.getOriginalFilename());
		logger.info("파일크기 : "+file.getSize());
		logger.info("켄텐츠타입 : "+file.getContentType());
		
		String saveName = file.getOriginalFilename();
		
		
		// 파일 이름 중복 되지 않게 처리하는 메서드 호출
		saveName = uploadFile(saveName, file.getBytes());
		
		mav.setViewName("/upload/uploadResult");
		mav.addObject("saveName", saveName);
		return mav;
	}
	
	//  파일 이름 중복되지 않게 처리하는 메서드 정의
	public String uploadFile(String saveName, byte[] fileData) throws Exception{
		
		// 파일 이름 중복 되지 않게 처리
		UUID uid = UUID.randomUUID();
		saveName = uid.toString()+"_"+saveName;
		
		File target = new File(uploadPath, saveName);
		// 임시 저장된 업로드 파일을 지정된 폴더에 복사, FileCopyUtils.copy(바이트배열, 파일객체); 
		FileCopyUtils.copy(fileData, target);
		
		return saveName;
	}
	
	
}
