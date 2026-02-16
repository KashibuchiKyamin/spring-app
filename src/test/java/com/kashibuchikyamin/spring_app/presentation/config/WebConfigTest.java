package com.kashibuchikyamin.spring_app.presentation.config;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import com.kashibuchikyamin.spring_app.presentation.advice.ControllerLoggingAdvice;

@DisplayName("WebConfig")
class WebConfigTest {

	@Nested
	@DisplayName("addInterceptors")
	class AddInterceptors {
		@Test
		@DisplayName("ControllerLoggingAdviceを登録する")
		void registersControllerLoggingAdvice() {
			ControllerLoggingAdvice advice = mock(ControllerLoggingAdvice.class);
			InterceptorRegistry registry = mock(InterceptorRegistry.class);
			InterceptorRegistration registration = mock(InterceptorRegistration.class);
			when(registry.addInterceptor(advice)).thenReturn(registration);

			WebConfig webConfig = new WebConfig(advice);

			webConfig.addInterceptors(registry);

			verify(registry, times(1)).addInterceptor(advice);
		}
	}
}
