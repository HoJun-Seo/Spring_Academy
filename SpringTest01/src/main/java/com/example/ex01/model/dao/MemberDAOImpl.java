package com.example.ex01.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.ex01.model.dto.MemberDTO;

@Repository
public class MemberDAOImpl implements MemberDAO {

	@Inject
	SqlSession sql_session;
	
	@Override
	public List<MemberDTO> list() {
		return sql_session.selectList("member.list");
	}

	@Override
	public void insert(MemberDTO dto) {
		sql_session.insert("member.insert",dto);
	}

	@Override
	public MemberDTO detail(String userid) {
		return sql_session.selectOne("member.detail", userid);
	}

	@Override
	public void delete(String userid) {
		sql_session.delete("member.delete", userid);
		
	}

	@Override
	public void update(MemberDTO dto) {
		sql_session.update("member.update",dto);
	}

	@Override
	public boolean check_passwd(String userid, String passwd) {
		boolean result = false;
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("userid", userid);
		map.put("passwd", passwd);
		
		int count = sql_session.selectOne("member.check_passwd", map);
		
		if (count == 1) {
			result = true;
		}
		return result;
	}
	
	// 로그인 처리
	public String loginCheck(MemberDTO dto) {
		return null;
	}

	@Override
	public void logout(HttpSession session) {
		// TODO Auto-generated method stub
		
	}

}
