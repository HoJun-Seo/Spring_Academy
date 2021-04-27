package com.example.ex01.model.shop.dto;

import lombok.Data;

@Data
public class CartDTO {
	private int cart_id;
    private String userid;
    private String user_name;
    private int product_id;
    private String product_name;
    private int price;
    private int money;
    private int amount;
}
