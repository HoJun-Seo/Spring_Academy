package com.example.test;

import java.sql.Connection;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

// @RunWith : 테스트 시 필요한 클래스 지정
// @ContextConfiguration : 스프링이 실행되면 어떤 설정 정보를 읽어 들여야 하는지 명시하는 부분
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/**/root-context.xml")
@Log4j
public class DBconnectionTest {
	
	// 의존성 주입(객체 주입 : 스프링에서 객체 직접 주입 : 생성해서 넣어줌)
	@Inject
	private DataSource ds;
	
	@Test
	public void testConnection() {
		try (Connection con = ds.getConnection()){
			System.out.println("\nDB 연결 성공!!\n");
			log.info(con);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
