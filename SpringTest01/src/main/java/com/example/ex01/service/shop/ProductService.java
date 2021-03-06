package com.example.ex01.service.shop;

import java.util.List;

import com.example.ex01.model.shop.dto.ProductDTO;

public interface ProductService {
	List<ProductDTO> listProduct();
	ProductDTO detailProduct(int product_id);
	
	void updateProduct(ProductDTO dto);
	void insertProduct(ProductDTO dto);
	void deleteProduct(int product_id);
	String fileInfo(int  product_id);
}
