package com.kashibuchikyamin.spring_app.domain.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("OrderDeliveryInfo")
class OrderDeliveryInfoTest {

	@Nested
	@DisplayName("コンストラクタ")
	class Constructor {
		@Test
		@DisplayName("渡した値を保持する")
		void keepsInputValues() {
			OrderDeliveryInfo actual = new OrderDeliveryInfo("配送1", "宅配便", "500部", "東京本社");

			assertThat(actual.label()).isEqualTo("配送1");
			assertThat(actual.method()).isEqualTo("宅配便");
			assertThat(actual.quantity()).isEqualTo("500部");
			assertThat(actual.destination()).isEqualTo("東京本社");
		}
	}
}
