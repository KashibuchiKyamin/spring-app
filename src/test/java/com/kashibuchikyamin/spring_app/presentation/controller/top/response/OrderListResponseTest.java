package com.kashibuchikyamin.spring_app.presentation.controller.top.response;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.kashibuchikyamin.spring_app.application.service.top.dto.OrderListDto;

@DisplayName("OrderListResponse")
class OrderListResponseTest {

	@Nested
	@DisplayName("コンストラクタ")
	class Constructor {
		@Test
		@DisplayName("DTOから値を設定する")
		void setsValuesFromDto() {
			OrderListDto dto = new OrderListDto(
					4,
					List.of(new OrderListDto.OrderSummary("案件A", "顧客A", "OID-001")));

			OrderListResponse actual = new OrderListResponse(dto);

			assertThat(actual.total()).isEqualTo(4);
			assertThat(actual.data()).isEqualTo(dto.data());
		}
	}
}
