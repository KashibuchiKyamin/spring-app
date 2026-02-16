package com.kashibuchikyamin.spring_app;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.boot.builder.SpringApplicationBuilder;

@DisplayName("ServletInitializer")
class ServletInitializerTest {

	@Nested
	@DisplayName("configure")
	class Configure {
		@Test
		@DisplayName("SpringAppApplicationをsourceに設定する")
		void setsSpringAppApplicationAsSource() {
			TestableServletInitializer servletInitializer = new TestableServletInitializer();
			SpringApplicationBuilder application = new SpringApplicationBuilder();

			SpringApplicationBuilder actual = servletInitializer.callConfigure(application);

			assertThat(actual).isSameAs(application);
			assertThat(actual.build().getAllSources()).contains(SpringAppApplication.class);
		}
	}

	private static class TestableServletInitializer extends ServletInitializer {
		SpringApplicationBuilder callConfigure(SpringApplicationBuilder application) {
			return super.configure(application);
		}
	}
}