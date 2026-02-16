package com.kashibuchikyamin.spring_app.domain.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("OrderProcessInfo")
class OrderProcessInfoTest {

	@Nested
	@DisplayName("コンストラクタ")
	class Constructor {
		@Test
		@DisplayName("渡した値を保持する")
		void keepsInputValues() {
			OrderProcessInfo actual = new OrderProcessInfo("加工1", "PP加工");

			assertThat(actual.label()).isEqualTo("加工1");
			assertThat(actual.description()).isEqualTo("PP加工");
		}
	}
}
