package com.example.ex01.service.shop;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.ex01.model.shop.dao.CartDAO;
import com.example.ex01.model.shop.dao.CartDAOImpl;
import com.example.ex01.model.shop.dto.CartDTO;

@Service
public class CartServiceImpl implements CartService{

	@Inject
	CartDAOImpl cartDao;
	
	@Override
	public List<CartDTO> cartMoney() {
		// TODO Auto-generated method stub
		return cartDao.cartMoney();
	}

	@Override
	public void insert(CartDTO dto) {
		cartDao.insert(dto);
	}

	@Override
	public List<CartDTO> listCart(String userid) {
		return cartDao.listCart(userid);
	}

	@Override
	public void delete(int cart_id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(String userid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int sumMoney(String userid) {
		return cartDao.sumMoney(userid);
	}

	@Override
	public int coutCart(String userid, int product_id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void modifyCart(CartDTO dto) {
		// TODO Auto-generated method stub
		
	}

}
