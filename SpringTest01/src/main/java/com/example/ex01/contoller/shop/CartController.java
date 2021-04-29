package com.example.ex01.contoller.shop;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.ex01.model.shop.dto.CartDTO;
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
		// 개인별 장바구니 조회를 위한 세션에 있는 userid값 추출
		String userid = (String) session.getAttribute("userid");
			
		if (userid != null) { // 로그인 상태이면
				
			// 1. id에 해당하는 멤버회원의 장바구니 목록 조회
			List<CartDTO> list = cartService.listCart(userid);
			logger.info("아이디: "+userid);
			logger.info("장바구니 목록: "+list.toString());
				
			// 2. 장바구니 총 금액
			int sumMoney = cartService.sumMoney(userid);
			logger.info("장바구니 총합계: "+sumMoney);
				
			// 배송비 : 2500, 30000이상이면 무료배송
			int fee = (sumMoney>= 30000) ? 0 : 2500;
			logger.info("배송비: "+fee);
				
			// 3. 장바구니에 대한 정보 저장해서 전송(포워딩)
			map.put("fee", fee);
			map.put("sumMoney", sumMoney);
			map.put("sum", sumMoney+fee);
			map.put("list", list);
			map.put("count", list.size());
				
			mav.addObject("map",map);
			mav.setViewName("/shop/cart_list");
				
			return mav;
				
		} else { // 로그인 상태가 아님
			/*
			mav.addObject("key","값");
			mav.setViewName("/member/login");
			return mav;
			*/
			return new ModelAndView("/member/login", "",null);
		}
			
	}// list()
		
	@RequestMapping("update.do")
	public String update(int[] amount, int[] cart_id , HttpSession session ) {
		logger.info("장바구니 수정을 요청했습니다.");
			
		String userid = (String) session.getAttribute("userid");
			
		for (int i=0; i<cart_id.length; i++) {
			// 상품개수가 0이면 상품자체를 삭제(입력시 1이상으로 제약조건 만들었으면 이부분생략)
			if (amount[i] == 0) {
				cartService.delete(cart_id[i]);
			} else  {
				// 수량이 1개 이상이면 장바구니에 있는 상품 수량 수정 처리
				CartDTO dto = new CartDTO();
				dto.setUserid(userid);
				dto.setCart_id(cart_id[i]);
				dto.setAmount(amount[i]);
					
				// db에 수정 요청
				cartService.modifyCart(dto);
			}
		}
			
		return "redirect:/shop/cart/list.do";
	}
	@RequestMapping("delete.do")
	public String delete(@RequestParam int  cart_id) {
		logger.info("장바구니 개별상품 삭제을 요청했습니다.");
			
		// 장바구니에 담겨 있는 상품 개별적으로 삭제 요청
		cartService.delete(cart_id);
			
		return "redirect:/shop/cart/list.do";
	}
		
	@RequestMapping("deleteAll.do")
	public String deleteAll(HttpSession session) {
		logger.info("장바구니 전체 비우기 요청했습니다.");
			
		String userid = (String) session.getAttribute("userid");
			
		// 로그인 상태이면 장바구니 비우기 처리
		if (userid != null) {
				
			 // userid에 해당하는 장바구니 cart_id모두 삭제 처리 요청
			cartService.deleteAll(userid);
		}
			
		return "redirect:/shop/cart/list.do";
	}
		
	@RequestMapping("insert.do")
	public String insert(@ModelAttribute CartDTO dto, HttpSession session) {
		logger.info("장바구니 담기를 요청했습니다.");
		
		// 세션 확인(로그인 상태일 경우만 장바구니 담기 허용)
		String user_id = (String)session.getAttribute("userid");
		if(user_id == null) {
			return "redirect:/member/login";
		}
		
		// 로그인 상태일 경우 장바구니 담기 요청
		dto.setUser_name(user_id);
		// 장바구니 담기 기능처리
		cartService.insert(dto);
		
		// 장바구니 리스트 페이지로 이동
		return "";
	}
}
