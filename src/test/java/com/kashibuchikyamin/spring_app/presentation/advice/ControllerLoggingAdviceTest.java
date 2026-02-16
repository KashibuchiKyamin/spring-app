package com.kashibuchikyamin.spring_app.presentation.advice;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import java.lang.reflect.Method;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;
import org.springframework.web.method.HandlerMethod;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@ExtendWith(OutputCaptureExtension.class)
@DisplayName("ControllerLoggingAdvice")
class ControllerLoggingAdviceTest {

	@Nested
	@DisplayName("preHandle")
	class PreHandle {
		@Test
		@DisplayName("handlerMethodの場合は開始ログを出力しtrueを返す")
		void logsStartAndReturnsTrueWhenHandlerMethod(CapturedOutput output) throws Exception {
			ControllerLoggingAdvice advice = new ControllerLoggingAdvice();
			HttpServletRequest request = mock(HttpServletRequest.class);
			HttpServletResponse response = mock(HttpServletResponse.class);
			HandlerMethod handlerMethod = createHandlerMethod();

			boolean actual = advice.preHandle(request, response, handlerMethod);

			assertThat(actual).isTrue();
			assertThat(output.getOut()).contains("[START] SampleController.sample");
		}

		@Test
		@DisplayName("handlerMethod以外でも例外なく処理継続する")
		void returnsTrueWhenHandlerIsNotHandlerMethod(CapturedOutput output) {
			ControllerLoggingAdvice advice = new ControllerLoggingAdvice();
			HttpServletRequest request = mock(HttpServletRequest.class);
			HttpServletResponse response = mock(HttpServletResponse.class);

			boolean actual = advice.preHandle(request, response, new Object());

			assertThat(actual).isTrue();
			assertThat(output.getOut()).doesNotContain("[START]");
		}
	}

	@Nested
	@DisplayName("postHandle")
	class PostHandle {
		@Test
		@DisplayName("handlerMethodの場合は終了ログを出力する")
		void logsEndWhenHandlerMethod(CapturedOutput output) throws Exception {
			ControllerLoggingAdvice advice = new ControllerLoggingAdvice();
			HttpServletRequest request = mock(HttpServletRequest.class);
			HttpServletResponse response = mock(HttpServletResponse.class);
			HandlerMethod handlerMethod = createHandlerMethod();

			advice.postHandle(request, response, handlerMethod, null);

			assertThat(output.getOut()).contains("[END] SampleController.sample");
		}
	}

	private static HandlerMethod createHandlerMethod() throws NoSuchMethodException {
		SampleController target = new SampleController();
		Method method = SampleController.class.getDeclaredMethod("sample");
		return new HandlerMethod(target, method);
	}

	static class SampleController {
		public void sample() {
		}
	}
}
