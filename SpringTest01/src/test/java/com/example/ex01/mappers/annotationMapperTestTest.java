package com.example.ex01.mappers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)			
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
@Log4j
public class annotationMapperTestTest {

	@Inject  // 빈 주입
	private annotationMapperTest timeMapper;
	@Test
	public void testGetTime() {
		// 인터페이스만 만들어 주었는데 내부적으로  적당한 클래스가 생성됨. (AOP개념)
		log.info("-- 클래스이름 --");
		log.info(timeMapper.getClass().getName());
		log.info("-- 날짜 --");
		log.info(timeMapper.getTime());
		System.out.println("--- xml와 인터페이스을 동시이용 --");
		log.info(timeMapper.getTime2());
	}
}
