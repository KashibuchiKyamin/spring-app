package com.kashibuchikyamin.spring_app;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.kashibuchikyamin.spring_app.infrastructure.datasource.mapper.single.OrderMapper;

@SpringBootTest
@ActiveProfiles("unittest")
@org.springframework.test.context.TestPropertySource(properties = "spring.sql.init.mode=never")
@DisplayName("SpringAppApplication")
class SpringAppApplicationTests {

	@MockBean
	private OrderMapper orderMapper;

	@Nested
	@DisplayName("アプリケーション起動")
	class ContextLoad {
		@Test
		@DisplayName("Springコンテキストが起動する")
		void contextLoads() {
		}
	}

}
