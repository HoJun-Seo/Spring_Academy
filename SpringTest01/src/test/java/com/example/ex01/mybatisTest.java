package com.example.ex01;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class mybatisTest {

	// 객체 주입(의존성 객체 주입)
	@Inject
	private SqlSessionFactory sqlFactory;
	
	@Test
	public void testlFactory() {
		System.out.println("\nSqlSessionFactory 객체 :\n "+sqlFactory);
	}
	
	@Test
	public void testSession() {
		try ( SqlSession session = sqlFactory.openSession()){
			System.out.println("\nSqlSession 객체 :\n "+session);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
