package com.kashibuchikyamin.spring_app.presentation.advice;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

@DisplayName("GlobalAjaxExceptionHandler")
class GlobalAjaxExceptionHandlerTest {

	@Nested
	@DisplayName("handleException")
	class HandleException {
		@Test
		@DisplayName("500の統一エラーレスポンスを返す")
		void returnsUnifiedInternalServerErrorResponse() {
			GlobalAjaxExceptionHandler handler = new GlobalAjaxExceptionHandler();
			RuntimeException ex = new RuntimeException("boom");

			var response = handler.handleException(ex);

			assertThat(response.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
			assertThat(response.getBody()).isNotNull();
			assertThat(response.getBody().status()).isEqualTo(500);
			assertThat(response.getBody().message()).isEqualTo("サーバ内部で予期しないエラーが発生しました。");
			assertThat(response.getBody().errorCode()).isEqualTo("RuntimeException");
		}
	}
}
