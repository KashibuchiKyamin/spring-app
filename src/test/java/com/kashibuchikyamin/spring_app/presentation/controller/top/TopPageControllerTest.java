package com.kashibuchikyamin.spring_app.presentation.controller.top;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.ui.ConcurrentModel;

import com.kashibuchikyamin.spring_app.application.service.top.TopPageService;
import com.kashibuchikyamin.spring_app.application.service.top.dto.OrderListDto;
import com.kashibuchikyamin.spring_app.presentation.controller.top.response.OrderListResponse;

@DisplayName("TopPageController")
class TopPageControllerTest {

	@Nested
	@DisplayName("showTopPage")
	class ShowTopPage {
		@Test
		@DisplayName("テンプレート名 top を返す")
		void returnsTopTemplateName() {
			TopPageService topPageService = mock(TopPageService.class);
			TopPageController controller = new TopPageController(topPageService);

			String actual = controller.showTopPage(new ConcurrentModel());

			assertThat(actual).isEqualTo("top");
		}
	}

	@Nested
	@DisplayName("getOrderList")
	class GetOrderList {
		@Test
		@DisplayName("サービス結果を200で返す")
		void returnsOkWithResponseBody() throws IOException {
			TopPageService topPageService = mock(TopPageService.class);
			when(topPageService.getOrderList())
					.thenReturn(new OrderListDto(
							3,
							List.of(new OrderListDto.OrderSummary("案件A", "顧客A", "OID-001"))));
			TopPageController controller = new TopPageController(topPageService);

			var response = controller.getOrderList();

			assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
			OrderListResponse body = response.getBody();
			assertThat(body).isNotNull();
			assertThat(body.total()).isEqualTo(3);
			assertThat(body.data()).hasSize(1);
			assertThat(body.data().getFirst().title()).isEqualTo("案件A");
			verify(topPageService, times(1)).getOrderList();
		}
	}
}
