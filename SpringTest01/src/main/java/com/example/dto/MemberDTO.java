package com.example.dto;

import java.util.Date;

import lombok.Data;

@Data
public class MemberDTO {
	private String userid;
	private String passwd;
	private String name;
	private String email;
	private Date join_date;
}
