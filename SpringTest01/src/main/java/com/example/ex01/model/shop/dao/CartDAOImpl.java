package com.example.ex01.model.shop.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.ex01.model.shop.dto.CartDTO;

@Repository
public class CartDAOImpl implements CartDAO{

	@Inject
	SqlSession sqlSession;
	
	@Override
	public List<CartDTO> cartMoney() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("cart.listAllCart");
	}

	@Override
	public void insert(CartDTO dto) {
		sqlSession.insert("cart.insertCart", dto);
	}

	@Override
	public List<CartDTO> listCart(String userid) {
		return sqlSession.selectList("cart.listCart");
	}

	// 장바구니 개별 상품 삭제
	@Override
	public void delete(int cart_id) {
		sqlSession.delete("cart.deleteCart", cart_id);
	}

	// 특정 아이디 장바구니 비우기
	@Override
	public void deleteAll(String userid) {
		sqlSession.delete("cart.deleteAllCart", userid);
	}

	/*
	 * @Override public void update(int cart_id) {
	 * 
	 * }
	 */

	@Override
	public int sumMoney(String userid) {
		return sqlSession.selectOne(userid);
	}

	@Override
	public int coutCart(String userid, int product_id) {
		Map<String, Object> map = new HashMap<>();
		map.put("userid", userid);
		map.put("product_id", product_id);
		return sqlSession.selectOne("cart.countCart", map);
	}

	@Override
	public void modifyCart(CartDTO dto) {
		sqlSession.update("cart.modifyCart", dto);
	}

}
