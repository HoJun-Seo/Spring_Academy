package com.example.ex01.model.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class MemberDTO {
	private String userid;
	private String passwd;
	private String name;
	private String email;
	private Date join_date;
}
