package com.example.ex01.contoller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
	"file:src/main/webapp/WEB-INF/spring/root-context.xml"
	})
@WebAppConfiguration
@Log4j
public class memberControllerTest {
	
	// @Inject : 의존관계 주입(스프링이 객체를 생성하여 관리) 또는 	@Autowired
	@Inject
	private WebApplicationContext ctx;
	// 가상으로 URL과 파라미터 등을 브라우저에서 사용하는 것처럼 만들어서 Controller를 실행시킴
	private MockMvc mockMvc;
	
	
	// 테스트 전에 매번 실행되는 메서드 : 초기화 작업시 활용
	@Before
	public void setUp() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}

	@Test
	public void testMember_list() throws Exception{
			this.mockMvc.perform(
					get("/member/list.do"))
					.andDo(print())
					.andExpect(status().isOk())
					.andExpect(model().attributeExists("items")   );
	}
	//@Test
	public void testMember_list2() throws Exception{
		log.info(
				mockMvc.perform(MockMvcRequestBuilders.get("/member/list.do"))
				.andReturn()
				.getModelAndView()
				.getModelMap()
				);
		
	}
	//@Test
	public void testMember_insert() throws Exception{
		String resultPage = 
				mockMvc.perform(
						MockMvcRequestBuilders.post("/member/insert.do")
						.param("userid", "testUser03")
						.param("passwd", "1234")
						.param("name", "테스트사용자03")
						.param("email", "testUser03@gmail.com") 
						).andDo(print()).andReturn().getModelAndView().getViewName();
		
		log.info(resultPage);
	}

//	@Test
//	public void testWrite() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testInsert() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testView() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testUpdate() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testDelete() {
//		fail("Not yet implemented");
//	}

}
