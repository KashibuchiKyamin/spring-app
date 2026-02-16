package com.kashibuchikyamin.spring_app.domain.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("OrderPaperInfo")
class OrderPaperInfoTest {

	@Nested
	@DisplayName("コンストラクタ")
	class Constructor {
		@Test
		@DisplayName("渡した値を保持する")
		void keepsInputValues() {
			OrderPaperInfo actual = new OrderPaperInfo("用紙1", "表紙", "コート110kg", "2包");

			assertThat(actual.label()).isEqualTo("用紙1");
			assertThat(actual.type()).isEqualTo("表紙");
			assertThat(actual.spec()).isEqualTo("コート110kg");
			assertThat(actual.bundle()).isEqualTo("2包");
		}
	}
}