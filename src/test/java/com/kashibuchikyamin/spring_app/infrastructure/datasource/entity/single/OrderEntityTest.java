package com.kashibuchikyamin.spring_app.infrastructure.datasource.entity.single;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.kashibuchikyamin.spring_app.domain.model.OrderIdentificationInfo.OrderSummary;

@DisplayName("OrderEntity")
class OrderEntityTest {

	@Nested
	@DisplayName("toOrderSummaryList")
	class ToOrderSummaryList {
		@Test
		@DisplayName("nullを渡した場合は空リストを返す")
		void returnsEmptyListWhenInputIsNull() {
			List<OrderSummary> actual = OrderEntity.toOrderSummaryList(null);

			assertThat(actual).isEmpty();
		}

		@Test
		@DisplayName("エンティティ一覧をOrderSummaryへ変換する")
		void convertsEntitiesToOrderSummary() {
			LocalDateTime now = LocalDateTime.of(2026, 1, 1, 10, 0, 0);
			List<OrderEntity> source = List.of(
					new OrderEntity("OID-001", "案件A", "顧客A", "S001", now, now),
					new OrderEntity("OID-002", "案件B", "顧客B", "S002", now, now));

			List<OrderSummary> actual = OrderEntity.toOrderSummaryList(source);

			assertThat(actual)
					.extracting(OrderSummary::title, OrderSummary::customer, OrderSummary::orderId)
					.containsExactly(
							org.assertj.core.groups.Tuple.tuple("案件A", "顧客A", "OID-001"),
							org.assertj.core.groups.Tuple.tuple("案件B", "顧客B", "OID-002"));
		}
	}
}