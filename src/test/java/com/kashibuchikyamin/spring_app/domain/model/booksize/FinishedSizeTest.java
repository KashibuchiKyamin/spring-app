package com.kashibuchikyamin.spring_app.domain.model.booksize;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("FinishedSize")
class FinishedSizeTest {
	/**
	 * 判型の縦横ちょうどの組み合わせ（正常系）を返す。
	 * <ul>
	 * <li>各BookSizeTypeのside1Mm, side2Mmの両パターン</li>
	 * <li>例：A4なら(210,297)と(297,210)</li>
	 * </ul>
	 */
	static Stream<org.junit.jupiter.params.provider.Arguments> validCases() {
		return Stream.of(FinishedSizeType.values())
				.flatMap(type -> Stream.of(
						org.junit.jupiter.params.provider.Arguments.of(type, type.side1Mm, type.side2Mm),
						org.junit.jupiter.params.provider.Arguments.of(type, type.side2Mm, type.side1Mm),
						org.junit.jupiter.params.provider.Arguments.of(type, type.side1Mm - 1, type.side2Mm),
						org.junit.jupiter.params.provider.Arguments.of(type, type.side1Mm, type.side2Mm - 1)));
	}

	/**
	 * 判型の縦横合計値を超えるパターン（異常系）を返す。
	 * <ul>
	 * <li>各BookSizeTypeのside1Mm+1, side2Mmの組み合わせ</li>
	 * <li>合計値が最大値を超えるため例外が発生</li>
	 * </ul>
	 */
	static Stream<org.junit.jupiter.params.provider.Arguments> sumOverCases() {
		return Stream.of(FinishedSizeType.values())
				.flatMap(type -> Stream.of(
						org.junit.jupiter.params.provider.Arguments.of(type, type.side1Mm + 1, type.side2Mm),
						org.junit.jupiter.params.provider.Arguments.of(type, type.side1Mm, type.side2Mm + 1)));
	}

	/**
	 * 判型の合計値内だが、1辺が最大値を超えるパターン（異常系）を返す。
	 * <ul>
	 * <li>各BookSizeTypeのside1Mm+1, side2Mm-1とside1Mm-1, side2Mm+1の組み合わせ</li>
	 * <li>合計値は範囲内だが、どちらか一方が最大値を超えるため例外が発生</li>
	 * </ul>
	 */
	static Stream<org.junit.jupiter.params.provider.Arguments> oneSideOverCases() {
		return Stream.of(FinishedSizeType.values())
				.flatMap(type -> Stream.of(
						org.junit.jupiter.params.provider.Arguments.of(type, type.side1Mm + 1, type.side2Mm - 2),
						org.junit.jupiter.params.provider.Arguments.of(type, type.side1Mm - 2, type.side2Mm + 1)));
	}

	@Nested
	@DisplayName("生成時バリデーション")
	class ConstructorValidation {
		@ParameterizedTest(name = "{0} の {1}x{2} は生成できる")
		@MethodSource("com.kashibuchikyamin.spring_app.domain.model.booksize.FinishedSizeTest#validCases")
		@DisplayName("判型内に収まる場合は生成できる")
		void createsWhenItFitsInBaseSize(FinishedSizeType type, int height, int width) {
			assertDoesNotThrow(() -> new FinishedSize(type, height, width));
		}

		@ParameterizedTest(name = "{0} の {1}x{2} は合計超過で失敗する")
		@MethodSource("com.kashibuchikyamin.spring_app.domain.model.booksize.FinishedSizeTest#sumOverCases")
		@DisplayName("縦横合計が判型合計を超える場合は失敗する")
		void throwsWhenSumExceedsBaseSize(FinishedSizeType type, int height, int width) {
			assertThrows(IllegalArgumentException.class, () -> new FinishedSize(type, height, width));
		}

		@ParameterizedTest(name = "{0} の {1}x{2} は辺長超過で失敗する")
		@MethodSource("com.kashibuchikyamin.spring_app.domain.model.booksize.FinishedSizeTest#oneSideOverCases")
		@DisplayName("合計内でも一辺が判型を超える場合は失敗する")
		void throwsWhenEitherSideExceedsBaseSize(FinishedSizeType type, int height, int width) {
			assertThrows(IllegalArgumentException.class, () -> new FinishedSize(type, height, width));
		}
	}
}