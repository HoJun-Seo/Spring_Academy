package com.example.ex01.contoller.shop;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.ex01.service.shop.ProductService;


// 공통된 URL 맵핑
@RequestMapping("/shop/product/*")
@Controller
public class ProductController {
	
	private static  final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	// 서비스 기능 요청
	@Inject
	ProductService productService;

	@RequestMapping("list.do")
	public ModelAndView list(ModelAndView mav) {
		logger.info(  	productService.listProduct().toString()   );
		
		mav.setViewName("/shop/product_list");
		mav.addObject("list",productService.listProduct());
		return mav;
	}
	
	
}
