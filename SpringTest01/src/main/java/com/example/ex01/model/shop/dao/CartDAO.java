package com.example.ex01.model.shop.dao;

import java.util.List;

import com.example.ex01.model.shop.dto.CartDTO;

public interface CartDAO {
	
	// 상품별 금액
    List<CartDTO> cartMoney();

    // 장바구니 추가
    void insert(CartDTO dto);

    // 개별 장바구니 목록
    List<CartDTO> listCart(String userid);

    // 개별 장바구니 삭제
    void delete(int cart_id);

    // 장바구니 비우기
    void deleteAll(String userid);

//    void update(int cart_id);

    // 장바구니 금액 합산
    int sumMoney(String userid);

    // 장바구니 상품 개수
    int coutCart(String userid, int product_id);

    //void updateCart(CartDTO dto);

    // 장바구니 수정
    void modifyCart(CartDTO dto);
}
