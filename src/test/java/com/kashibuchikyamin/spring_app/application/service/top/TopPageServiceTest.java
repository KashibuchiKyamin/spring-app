package com.kashibuchikyamin.spring_app.application.service.top;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.kashibuchikyamin.spring_app.application.service.top.dto.OrderListDto;
import com.kashibuchikyamin.spring_app.domain.model.OrderIdentificationInfo;
import com.kashibuchikyamin.spring_app.domain.repository.OrderIdentificationInfoRepository;

@DisplayName("TopPageService")
class TopPageServiceTest {

	@Nested
	@DisplayName("getOrderList")
	class GetOrderList {
		@Test
		@DisplayName("リポジトリ結果をDTOへ変換して返す")
		void returnsConvertedDto() {
			OrderIdentificationInfoRepository repository = mock(OrderIdentificationInfoRepository.class);
			OrderIdentificationInfo orderList = new OrderIdentificationInfo(
					1,
					List.of(new OrderIdentificationInfo.OrderSummary("案件A", "顧客A", "OID-001")));
			when(repository.getOrderList()).thenReturn(orderList);

			TopPageService service = new TopPageService(repository);

			OrderListDto actual = service.getOrderList();

			assertThat(actual.total()).isEqualTo(1);
			assertThat(actual.data()).hasSize(1);
			assertThat(actual.data().getFirst().title()).isEqualTo("案件A");
			assertThat(actual.data().getFirst().customer()).isEqualTo("顧客A");
			assertThat(actual.data().getFirst().orderId()).isEqualTo("OID-001");
			verify(repository, times(1)).getOrderList();
		}
	}
}
