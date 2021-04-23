package com.example.ex01.model.shop.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class ProductDTO {
	// 필드명은 DB필드명과 동일하게해야 같은 이름으로 서로 맵핑됨.
	private int product_id;
	private String product_name;
	private int product_price;
//	private Integer product_price;
	private String product_desc;
	private String product_url;
	private MultipartFile product_file1;
}
