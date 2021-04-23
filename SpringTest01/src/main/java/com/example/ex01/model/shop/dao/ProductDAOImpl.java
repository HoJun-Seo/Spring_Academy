package com.example.ex01.model.shop.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.example.ex01.contoller.shop.ProductController;
import com.example.ex01.model.shop.dto.ProductDTO;

// DAO에서 mybatis라이브러리 연결하여 db처리를 담당

@Repository
public class ProductDAOImpl implements ProductDAO {

	private static  final Logger logger = LoggerFactory.getLogger(ProductDAOImpl.class);
	
	
	@Inject  // or @Autowired
	SqlSession SqlSession;

	@Override
	public List<ProductDTO> listProduct() {
		return SqlSession.selectList("product.list_product");
	}

	@Override
	public ProductDTO detailProduct(int product_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateProduct(ProductDTO dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertProduct(ProductDTO dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteProduct(int product_id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String fileInfo(int product_id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	}
