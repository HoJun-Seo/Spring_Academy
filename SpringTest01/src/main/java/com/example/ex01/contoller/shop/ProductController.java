package com.example.ex01.contoller.shop;

import java.io.File;
import java.util.UUID;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.ex01.model.shop.dto.ProductDTO;
import com.example.ex01.service.shop.ProductService;
import com.example.ex01.service.shop.ProductServiceImpl;


// 공통된 URL 맵핑
@RequestMapping("/shop/product/*")
@Controller
public class ProductController {
	
	private static  final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	// 서비스 기능 요청
	@Inject
	ProductServiceImpl productService;

	// 상품 전체 조회
	@RequestMapping("list.do")
	public ModelAndView list(ModelAndView mav) {
		logger.info(  	productService.listProduct().toString()   );
		
		mav.setViewName("/shop/product_list");
		mav.addObject("list",productService.listProduct());
		return mav;
	}
	
	// 상품 정보 상세 조회
	//Pathvariable방식으로 인자를 전달 받음
    @RequestMapping("/detail/{product_id}")
    public ModelAndView detail(@PathVariable("product_id") int product_id, ModelAndView mav) {
        logger.info(productService.detailProduct(product_id).toString());

        mav.setViewName("/shop/product_detail");
        mav.addObject("dto", productService.detailProduct(product_id));
        return mav;
    }
    
    // 상품 정보 등록(입력)
    @RequestMapping("write.do")
    public String write() {
    	return "/shop/product_write";
    }
    
    @RequestMapping("insert.do")
    public String insert(ProductDTO dto) {
    	// 상품 등록 처리
    	return "redirect:/shop/product/list.do";
    }
    
    // 상품 편집
    @RequestMapping("/edit/{product_id}")
    public ModelAndView edit(@PathVariable("product_id") int product_id, ModelAndView mav) {
    	mav.setViewName("/shop/product_edit");
    	mav.addObject("dto", productService.detailProduct(product_id));
    	
    	return mav;
    }
    
    @RequestMapping("update.do")
    public String update(ProductDTO dto) {
    	//null값 입력을 막기위한 처리
		//String filename ="-"; 업데이트할 경우에 있는 기존에 있는 값을 사용하므로 의미가 없음.
		String filename ="-";
		
		// 첨부파일 존재하면 처리하는 부분
		if (!dto.getProduct_file1().isEmpty()) {
			
			// ---------------------------- //
			// 수정전 첨부파일 삭제			//
			// ---------------------------- //
			
			// 첨부파일 이름 (한글일 경우 깨어지눈 문제가 발생 할 수 있으므로 메서드통해 읽어옴.)
			String oldfilename = productService.fileInfo(dto.getProduct_id());
			
			// 파일이름이 null아니고 "-"아니면 처리
			if (oldfilename != null && !filename.equals("-")) {
				
				// 개발자 폴더(C:\\myjava\\springStudy\\spring01) -> eclipse에서 images폴더 새로 고침하고 웹에서 새로고침 해야 볼 수 있음.
				String path = "C:\\myjava\\springStudy\\spring01\\src\\main\\webapp\\WEB-INF\\views\\images\\";
				// 또는
				// String path = "C:/myjava/springStudy/spring01/src/main/webapp/WEB-INF/views/images/";
				
				// 배포 폴더(C:\myjava\springStudy\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\spring01) 
				// -> 새로고침 없이 바로 볼 수 있음. (단 개발자 폴더에는 이미지가 없음. "~/views/images/")
				
				// 현재 배포 폴더에는 이미지
				//String path = "C:\myjava\springStudy\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\spring02\\src\\main\\webapp\\WEB-INF\\views\\images\\";
				// 배포 폴더
				
				File f = new File(path+oldfilename);
				// 파일이 존재하면 삭제
				if (f.exists()) {
					f.delete();
				}
			}			
			
			// ---------------------------- //
			// 수정후 새로운 첨부파일 등록  //
			// ---------------------------- //
			
			// 파일이름 중복성 제거
			UUID uuid = UUID.randomUUID();
			filename = uuid.toString() +"_"+dto.getProduct_file1().getOriginalFilename();
			
			// 개발자 폴더(C:\\myjava\\springStudy\\spring01) -> eclipse에서 images폴더 새로 고침하고 웹에서 새로고침 해야 볼 수 있음.
			String path = "C:\\myjava\\springStudy\\spring01\\src\\main\\webapp\\WEB-INF\\views\\images\\";
			// 또는
			// String path = "C:/myjava/springStudy/spring01/src/main/webapp/WEB-INF/views/images/";
			try {
				// 폴더가 없으면 생성
				new File(path).mkdir();
				
				//MultipartFile 의 transferTo() 라는 메소드를 사용해서 원하는 위치에 저장
				dto.getProduct_file1().transferTo(new File(path+filename));
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			dto.setProduct_url(filename);
		} else {
			// 첨부파일 없으면 기존 정보 그대로 사용
			ProductDTO dto2 = productService.detailProduct(dto.getProduct_id());
			dto.setProduct_url(dto2.getProduct_url());
			
		}
		
		productService.updateProduct(dto);	
		
		return "redirect:/shop/product/list.do";
    }
    
    // 상품 삭제
    @RequestMapping("delete.do")
    public String delete(@RequestParam int product_id) {
    	// 삭제 작업 처리
    	return "redirect:/shop/product/list.do";
    }
	
	
}
