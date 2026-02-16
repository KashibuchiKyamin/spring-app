package com.kashibuchikyamin.spring_app.presentation.advice;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("AjaxErrorResponse")
class AjaxErrorResponseTest {

	@Nested
	@DisplayName("コンストラクタ")
	class Constructor {
		@Test
		@DisplayName("渡した値を保持する")
		void keepsInputValues() {
			AjaxErrorResponse actual = new AjaxErrorResponse(500, "エラー", "RuntimeException");

			assertThat(actual.status()).isEqualTo(500);
			assertThat(actual.message()).isEqualTo("エラー");
			assertThat(actual.errorCode()).isEqualTo("RuntimeException");
		}
	}
}
