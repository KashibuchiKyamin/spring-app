package com.kashibuchikyamin.spring_app.domain.model.booksize;

/**
 * 仕上がり寸法を表すレコード。
 * <p>
 * 判型（BookSizeType）と、縦横のミリ寸法を持つ。<br>
 * インスタンス生成時、
 * ・縦横の合計値が判型の合計値を超える場合NG
 * ・縦横合計値が超過しなくても、どちらか一方が判型の最大値を超える場合NG
 * 下限は考慮しない。
 * </p>
 */
public record FinishedSize(
	FinishedSizeType type,
	int heightMm,
	int widthMm) {
	/**
	 * コンストラクタ。寸法チェックを行う。
	 * @param type 判型
	 * @param heightMm 縦（mm）
	 * @param widthMm 横（mm）
	 * @throws IllegalArgumentException 判型の合計寸法を超える場合、またはどちらか一方が最大値を超える場合
	 */
	public FinishedSize {
		int sum = heightMm + widthMm;
		int typeSum = type.side1Mm + type.side2Mm;

		if (sum > typeSum) {
			throw new IllegalArgumentException(
					String.format("指定寸法の合計が判型(%s)の合計値を超えています: 入力=%d+%d=%d, 判型=%d+%d=%d", type.name(), heightMm, widthMm,
						sum, type.side1Mm, type.side2Mm, typeSum));
		}

		if (heightMm > type.side1Mm || heightMm > type.side2Mm) {
			throw new IllegalArgumentException(
					String.format("縦寸法が判型(%s)の最大値を超えています: 入力=%d, 判型=%d", type.name(), heightMm, type.side1Mm));
		}

		if (widthMm > type.side1Mm || widthMm > type.side2Mm) {
			throw new IllegalArgumentException(
					String.format("横寸法が判型(%s)の最大値を超えています: 入力=%d, 判型=%d", type.name(), widthMm, type.side2Mm));
		}
	}
}