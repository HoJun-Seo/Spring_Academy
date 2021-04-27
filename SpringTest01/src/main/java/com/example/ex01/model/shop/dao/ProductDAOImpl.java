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
	SqlSession sqlSession;

	@Override
	public List<ProductDTO> listProduct() {
		return sqlSession.selectList("product.list_product");
	}

	@Override
	public ProductDTO detailProduct(int product_id) {
		return sqlSession.selectOne("product.detail_product", product_id);
	}

	@Override
	public void updateProduct(ProductDTO dto) {
		sqlSession.update("product.updateProduct", dto);
	}

	@Override
	public void insertProduct(ProductDTO dto) {
		sqlSession.insert("product.insertProduct", dto);
	}

	@Override
	public void deleteProduct(int product_id) {
		sqlSession.delete("product.deleteProduct", product_id);
	}

	@Override
	public String fileInfo(int product_id) {
		return sqlSession.selectOne("product.fileinfo", product_id);
	}	
}
