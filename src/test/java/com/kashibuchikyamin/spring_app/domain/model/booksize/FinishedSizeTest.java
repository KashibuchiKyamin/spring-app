package com.kashibuchikyamin.spring_app.domain.model.booksize;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

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
						org.junit.jupiter.params.provider.Arguments.of(type, type.side2Mm, type.side1Mm)));
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
						org.junit.jupiter.params.provider.Arguments.of(type, type.side1Mm + 1, type.side2Mm - 1),
						org.junit.jupiter.params.provider.Arguments.of(type, type.side1Mm - 1, type.side2Mm + 1)));
	}

	@ParameterizedTest
	@MethodSource("validCases")
	void 判型ちょうどで縦横網羅のパターン(FinishedSizeType type, int height, int width) {
		assertDoesNotThrow(() -> new FinishedSize(type, height, width));
	}

	@ParameterizedTest
	@MethodSource("sumOverCases")
	void 縦横合計を超えるパターン(FinishedSizeType type, int height, int width) {
		assertThrows(IllegalArgumentException.class, () -> new FinishedSize(type, height, width));
	}

	@ParameterizedTest
	@MethodSource("oneSideOverCases")
	void 合計内だが1辺が超えるパターン(FinishedSizeType type, int height, int width) {
		assertThrows(IllegalArgumentException.class, () -> new FinishedSize(type, height, width));
	}
}