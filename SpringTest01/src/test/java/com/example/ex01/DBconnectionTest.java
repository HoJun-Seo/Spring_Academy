package com.example.ex01;

import java.sql.Connection;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

// @RunWidth: 테스트시 필요한 클래스 지정
// @ContextConfiguration : 스프링이 실행되면 어떤 설정 정보를 읽어 들여하야 하는지를 명시하는 부분

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/**/root-context.xml")
@Log4j
public class DBconnectionTest {
	
	// 의존성 주입(객체주입: 스프링에서 객체 직접주입: 생성해서 넣어줌)
	@Inject
	private DataSource ds;
	
	// jUnit상에서 해당 메서드가 jUint 단위 테스트의 대상을 의미
	@Test
	public void testConnection() {
		
		try(Connection con = ds.getConnection()) {
			
			System.out.println("\nDB연결 성공!!!\n");
			log.info(con);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
