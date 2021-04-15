package com.example.dao;

import java.util.List;

import com.example.dto.MemberDTO;

public interface MemberDAO {
	// 회원목록 조회 서비스
		public List<MemberDAO> list();
		// 회원가입 서비스
		public void insert(MemberDTO dto);
		// 회원정보 상세 정보 조회
		public MemberDTO detail(String userid);
		// 회원정보 삭제 
		public void delete(String userid);
		// 회원정보 수정
		public void update(MemberDTO dto);
		// 회원 아이디및 비밀번호 체크
		public boolean check_passwd(String userid, String passwd);
}
