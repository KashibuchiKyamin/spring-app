package com.kashibuchikyamin.spring_app.domain.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("OrderPrintInfo")
class OrderPrintInfoTest {

	@Nested
	@DisplayName("コンストラクタ")
	class Constructor {
		@Test
		@DisplayName("渡した値を保持する")
		void keepsInputValues() {
			OrderPrintInfo actual = new OrderPrintInfo("印刷1", "本文", "A4", "4C/4C", "通し1", "DIC-123");

			assertThat(actual.label()).isEqualTo("印刷1");
			assertThat(actual.type()).isEqualTo("本文");
			assertThat(actual.size()).isEqualTo("A4");
			assertThat(actual.color()).isEqualTo("4C/4C");
			assertThat(actual.serial()).isEqualTo("通し1");
			assertThat(actual.specialColor()).isEqualTo("DIC-123");
		}
	}
}
