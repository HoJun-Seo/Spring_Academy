package com.example.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.dto.MemberDTO;
import com.example.service.MemberService;

@Repository
public class MemberDAOImpl implements MemberDAO{
	
	@Inject
	SqlSession sqlSession;
	
	@Override
	public List<MemberDTO> list() {
		return sqlSession.selectList("mysqlMember.list");
	}

	@Override
	public void insert(MemberDTO dto) {
		sqlSession.insert("mysqlMember.insert", dto);
	}

	@Override
	public MemberDTO detail(String userid) {
		return sqlSession.selectOne("mysqlMember.detail", userid);
	}

	@Override
	public void delete(String userid) {
		sqlSession.delete("mysqlMember.delete", userid);
	}

	@Override
	public void update(MemberDTO dto) {
		sqlSession.update("mysqlMember.update", dto);
	}

	@Override
	public boolean check_passwd(String userid, String passwd) {
		boolean result = false;
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("userid", userid);
		map.put("passwd", passwd);
		
		int count = sqlSession.selectOne("mysqlMember.check_passwd", map);
		
		if(count == 1) {
			result = true;
		}
		
		return result;
	}
}
