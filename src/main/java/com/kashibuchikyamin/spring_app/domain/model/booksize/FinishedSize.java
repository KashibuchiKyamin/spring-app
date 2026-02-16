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
		int shorterSide = Math.min(type.side1Mm, type.side2Mm);
		int longerSide = Math.max(type.side1Mm, type.side2Mm);
		int inputShorterSide = Math.min(heightMm, widthMm);
		int inputLongerSide = Math.max(heightMm, widthMm);

		if (sum > typeSum) {
			throw new IllegalArgumentException(
					String.format("指定寸法の合計が判型(%s)の合計値を超えています: 入力=%d+%d=%d, 判型=%d+%d=%d", type.name(), heightMm, widthMm,
						sum, type.side1Mm, type.side2Mm, typeSum));
		}

		if (inputShorterSide > shorterSide || inputLongerSide > longerSide) {
			throw new IllegalArgumentException(
					String.format("指定寸法が判型(%s)内に収まりません: 入力=%d×%d, 判型=%d×%d", type.name(), heightMm, widthMm,
						type.side1Mm, type.side2Mm));
		}
	}
}