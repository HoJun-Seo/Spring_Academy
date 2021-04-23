package com.example.ex01.model.member.dto;

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
