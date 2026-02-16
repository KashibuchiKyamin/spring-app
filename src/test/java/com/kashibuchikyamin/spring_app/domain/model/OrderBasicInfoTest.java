package com.kashibuchikyamin.spring_app.domain.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.kashibuchikyamin.spring_app.domain.model.booksize.FinishedSize;
import com.kashibuchikyamin.spring_app.domain.model.booksize.FinishedSizeType;

@DisplayName("OrderBasicInfo")
class OrderBasicInfoTest {

	@Nested
	@DisplayName("コンストラクタ")
	class Constructor {
		@Test
		@DisplayName("渡した値を保持する")
		void keepsInputValues() {
			FinishedSize finishedSize = new FinishedSize(FinishedSizeType.A4, 200, 200);
			List<String> pages = List.of("本文16P");
			List<String> print = List.of("4C/4C");
			List<String> process = List.of("PP加工");
			List<String> binding = List.of("無線綴じ");
			List<String> quantity = List.of("1000部");

			OrderBasicInfo actual = new OrderBasicInfo(
					"春カタログ",
					"山田商事",
					finishedSize,
					pages,
					print,
					process,
					binding,
					quantity);

			assertThat(actual.orderName()).isEqualTo("春カタログ");
			assertThat(actual.customerName()).isEqualTo("山田商事");
			assertThat(actual.finishedSize()).isEqualTo(finishedSize);
			assertThat(actual.pages()).isEqualTo(pages);
			assertThat(actual.print()).isEqualTo(print);
			assertThat(actual.process()).isEqualTo(process);
			assertThat(actual.binding()).isEqualTo(binding);
			assertThat(actual.quantity()).isEqualTo(quantity);
		}
	}
}