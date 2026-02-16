package com.kashibuchikyamin.spring_app.application.service.top.dto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.kashibuchikyamin.spring_app.domain.model.OrderIdentificationInfo;

@DisplayName("OrderListDto")
class OrderListDtoTest {

	@Nested
	@DisplayName("コンストラクタ")
	class Constructor {
		@Test
		@DisplayName("ドメインモデルからDTOへ正しく変換する")
		void convertsFromDomainModel() {
			OrderIdentificationInfo source = new OrderIdentificationInfo(
					2,
					List.of(
							new OrderIdentificationInfo.OrderSummary("案件A", "顧客A", "OID-001"),
							new OrderIdentificationInfo.OrderSummary("案件B", "顧客B", "OID-002")));

			OrderListDto actual = new OrderListDto(source);

			assertThat(actual.total()).isEqualTo(2);
			assertThat(actual.data())
					.extracting(OrderListDto.OrderSummary::title, OrderListDto.OrderSummary::customer,
							OrderListDto.OrderSummary::orderId)
					.containsExactly(
							org.assertj.core.groups.Tuple.tuple("案件A", "顧客A", "OID-001"),
							org.assertj.core.groups.Tuple.tuple("案件B", "顧客B", "OID-002"));
		}
	}
}