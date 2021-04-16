package com.example.test;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

public class mybatisTest {
	
	@Inject
	private SqlSessionFactory sqlFactory;
	
	@Test
	public void testFactory() {
		System.out.println("\nSqlSession 객체:\n "+ sqlFactory);
	}
	
	@Test(expected = NullPointerException.class)
	public void testSession() {
		SqlSession session = sqlFactory.openSession();
//		System.out.println("\nSqlSession 객체:\n "+ session);
		/*
		 * try() { System.out.println("\nSqlSession 객체:\n "+ session); } catch
		 * (Exception e) { e.printStackTrace(); }
		 */
	}
}

