package com.kashibuchikyamin.spring_app.domain.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("OrderBindingInfo")
class OrderBindingInfoTest {

	@Nested
	@DisplayName("コンストラクタ")
	class Constructor {
		@Test
		@DisplayName("渡した値を保持する")
		void keepsInputValues() {
			OrderBindingInfo actual = new OrderBindingInfo("製本1", "無線綴じ");

			assertThat(actual.label()).isEqualTo("製本1");
			assertThat(actual.description()).isEqualTo("無線綴じ");
		}
	}
}