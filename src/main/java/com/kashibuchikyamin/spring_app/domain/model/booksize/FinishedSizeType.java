package com.kashibuchikyamin.spring_app.domain.model.booksize;

/**
 * 仕上がり寸法の判型（A0～A10, B0～B10）を表す列挙型。
 * <p>各判型の1辺寸法（mm）はJavadoc参照。</p>
 */
public enum FinishedSizeType {
	/** A0: 841mm × 1189mm */
	A0(841, 1189),
	/** A1: 594mm × 841mm */
	A1(594, 841),
	/** A2: 420mm × 594mm */
	A2(420, 594),
	/** A3: 297mm × 420mm */
	A3(297, 420),
	/** A4: 210mm × 297mm */
	A4(210, 297),
	/** A5: 148mm × 210mm */
	A5(148, 210),
	/** A6: 105mm × 148mm */
	A6(105, 148),
	/** A7: 74mm × 105mm */
	A7(74, 105),
	/** A8: 52mm × 74mm */
	A8(52, 74),
	/** A9: 37mm × 52mm */
	A9(37, 52),
	/** A10: 26mm × 37mm */
	A10(26, 37),
	/** B0: 1030mm × 1456mm */
	B0(1030, 1456),
	/** B1: 728mm × 1030mm */
	B1(728, 1030),
	/** B2: 515mm × 728mm */
	B2(515, 728),
	/** B3: 364mm × 515mm */
	B3(364, 515),
	/** B4: 257mm × 364mm */
	B4(257, 364),
	/** B5: 182mm × 257mm */
	B5(182, 257),
	/** B6: 128mm × 182mm */
	B6(128, 182),
	/** B7: 91mm × 128mm */
	B7(91, 128),
	/** B8: 64mm × 91mm */
	B8(64, 91),
	/** B9: 45mm × 64mm */
	B9(45, 64),
	/** B10: 32mm × 45mm */
	B10(32, 45);

	/** 1辺（mm） */
	public final int side1Mm;
	/** もう1辺（mm） */
	public final int side2Mm;

	FinishedSizeType(int side1Mm, int side2Mm) {
		this.side1Mm = side1Mm;
		this.side2Mm = side2Mm;
	}
}