package com.example.ex01.contoller.shop;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.ex01.model.shop.dto.CartDTO;
import com.example.ex01.service.shop.CartService;
import com.example.ex01.service.shop.CartServiceImpl;

@Controller
@RequestMapping("/shop/cart/*")
public class CartController {
	
	private static final Logger logger = LoggerFactory.getLogger(CartController.class);
	
	@Inject
	CartServiceImpl cartService;
	
	// 장바구니 목록
	@RequestMapping("list.do")
	public ModelAndView list(HttpSession session, ModelAndView mav) {
		// 장바구니 정보를 저장하기 위한 객체 생성
		Map<String, Object> map = new HashMap<String, Object>();
		// 개인별 장바구니 조회를 위한 세션에 있는 userid 값 추출
		String userid = (String)session.getAttribute("userid");
		
		if(userid != null) { // 로그인 상태이면 
			// id 에 해당하는 멤버 회원의 장바구니 목록 조회
			List<CartDTO> list = cartService.listCart(userid);
			
			// 장바구니 총 금액
			int sumMoney = cartService.sumMoney(userid);
//			logger.info("장바구니 총 합계 : " + sumMoney);
			
			// 배송비 2500, 주문값 30000 이상이면 무료 배송
			int fee = (sumMoney >= 30000) ? 0 : 2500;
			logger.info("배송 비 : " + fee);
			
			// 장바구니 에 대한 정보 저장해서 전송
			map.put("fee", fee);
			map.put("sum", sumMoney+fee);
			map.put("list", list);
			map.put("count", list.size());
			
			mav.addObject("map", map);
			mav.setViewName("/shop/cart_list");
			
		} else { // 로그인 상태가 아니면 장바구니 기능 자체를 사용할 수 없다.
			/*
			 * mav.addObject("key","값");
			 * mav.setViewName("/member/login");
			 * return mav;
			 */
			return new ModelAndView("/member/login", "", null);
		}
		
		return mav;
	}
}
