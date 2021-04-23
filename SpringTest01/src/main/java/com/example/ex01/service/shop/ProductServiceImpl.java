package com.example.ex01.service.shop;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.ex01.contoller.shop.ProductController;
import com.example.ex01.model.shop.dao.ProductDAO;
import com.example.ex01.model.shop.dto.ProductDTO;


@Service
public class ProductServiceImpl implements ProductService {

	private static  final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);
	
	@Inject
	ProductDAO productDao;
	
	@Override
	public List<ProductDTO> listProduct() {
		return productDao.listProduct();
	}

	@Override
	public ProductDTO detailProduct(int product_id) {
		return productDao.detailProduct(product_id);
	}

	@Override
	public void updateProduct(ProductDTO dto) {
		productDao.updateProduct(dto);
	}

	@Override
	public void insertProduct(ProductDTO dto) {
		productDao.insertProduct(dto);
	}

	@Override
	public void deleteProduct(int product_id) {
		productDao.deleteProduct(product_id);
	}

	@Override
	public String fileInfo(int product_id) {
		return productDao.fileInfo(product_id);
	}

}
