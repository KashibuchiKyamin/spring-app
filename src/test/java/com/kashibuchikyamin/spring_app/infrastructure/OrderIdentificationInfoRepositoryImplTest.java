package com.kashibuchikyamin.spring_app.infrastructure;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import com.kashibuchikyamin.spring_app.domain.model.OrderIdentificationInfo;
import com.kashibuchikyamin.spring_app.infrastructure.datasource.entity.single.OrderEntity;
import com.kashibuchikyamin.spring_app.infrastructure.datasource.mapper.single.OrderMapper;

@DisplayName("OrderIdentificationInfoRepositoryImpl")
class OrderIdentificationInfoRepositoryImplTest {

	@Nested
	@DisplayName("getOrderList")
	class GetOrderList {
		@Test
		@DisplayName("mapper結果をドメインへ変換し呼び出し順を守る")
		void convertsMapperResultAndKeepsCallOrder() {
			OrderMapper orderMapper = mock(OrderMapper.class);
			LocalDateTime now = LocalDateTime.of(2026, 1, 1, 10, 0, 0);
			when(orderMapper.getAllCount()).thenReturn(2);
			when(orderMapper.findAllLimit10()).thenReturn(List.of(
					new OrderEntity("OID-001", "案件A", "顧客A", "S001", now, now),
					new OrderEntity("OID-002", "案件B", "顧客B", "S002", now, now)));

			OrderIdentificationInfoRepositoryImpl repository = new OrderIdentificationInfoRepositoryImpl(orderMapper);

			OrderIdentificationInfo actual = repository.getOrderList();

			assertThat(actual.total()).isEqualTo(2);
			assertThat(actual.data())
					.extracting(OrderIdentificationInfo.OrderSummary::title, OrderIdentificationInfo.OrderSummary::customer,
							OrderIdentificationInfo.OrderSummary::orderId)
					.containsExactly(
							org.assertj.core.groups.Tuple.tuple("案件A", "顧客A", "OID-001"),
							org.assertj.core.groups.Tuple.tuple("案件B", "顧客B", "OID-002"));

			InOrder inOrder = inOrder(orderMapper);
			inOrder.verify(orderMapper).getAllCount();
			inOrder.verify(orderMapper).findAllLimit10();
		}
	}
}
