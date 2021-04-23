package com.example.ex01.service.admin;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.ex01.model.admin.dao.AdminDAO;
import com.example.ex01.model.admin.dto.AdminDTO;

@Service
public class AdminServiceImpl implements AdminService{

	@Inject
	AdminDAO adminDAO;
	
	@Override
	public String loginCheck(AdminDTO dto) {
		return adminDAO.loginCheck(dto);
	}

}
