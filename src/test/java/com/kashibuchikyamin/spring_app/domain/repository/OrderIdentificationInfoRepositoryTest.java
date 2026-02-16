package com.kashibuchikyamin.spring_app.domain.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.Method;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.kashibuchikyamin.spring_app.domain.model.OrderIdentificationInfo;

@DisplayName("OrderIdentificationInfoRepository")
class OrderIdentificationInfoRepositoryTest {

	@Nested
	@DisplayName("契約")
	class Contract {
		@Test
		@DisplayName("getOrderList を公開し戻り値は OrderIdentificationInfo")
		void exposesGetOrderListMethod() throws Exception {
			Method method = OrderIdentificationInfoRepository.class.getDeclaredMethod("getOrderList");

			assertThat(method.getReturnType()).isEqualTo(OrderIdentificationInfo.class);
			assertThat(method.getParameterCount()).isZero();
		}
	}
}
