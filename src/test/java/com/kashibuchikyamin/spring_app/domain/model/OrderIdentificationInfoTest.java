package com.kashibuchikyamin.spring_app.domain.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("OrderIdentificationInfo")
class OrderIdentificationInfoTest {

	@Nested
	@DisplayName("外側レコード")
	class OuterRecord {
		@Test
		@DisplayName("コンストラクタで渡した値を保持する")
		void keepsInputValues() {
			List<OrderIdentificationInfo.OrderSummary> data = List
					.of(new OrderIdentificationInfo.OrderSummary("案件A", "顧客A", "OID-001"));

			OrderIdentificationInfo actual = new OrderIdentificationInfo(1, data);

			assertThat(actual.total()).isEqualTo(1);
			assertThat(actual.data()).isEqualTo(data);
		}
	}

	@Nested
	@DisplayName("OrderSummary")
	class OrderSummaryRecord {
		@Test
		@DisplayName("コンストラクタで渡した値を保持する")
		void keepsInputValues() {
			OrderIdentificationInfo.OrderSummary actual = new OrderIdentificationInfo.OrderSummary("案件A", "顧客A", "OID-001");

			assertThat(actual.title()).isEqualTo("案件A");
			assertThat(actual.customer()).isEqualTo("顧客A");
			assertThat(actual.orderId()).isEqualTo("OID-001");
		}
	}
}
