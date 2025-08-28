package com.kashibuchikyamin.spring_app.domain.model.booksize;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import static org.junit.jupiter.api.Assertions.*;

class FinishedSizeTypeTest {
    /**
     * すべての仕上がり寸法判型の値が正しく設定されていることをテストします。
     * <ul>
     * <li>縦横とも0以下でないこと</li>
     * <li>Enum名と値が対応していること（例：A4は210×297）</li>
     * </ul>
     */
    @ParameterizedTest
    @EnumSource(FinishedSizeType.class)
    void 判型の寸法値が正しいこと(FinishedSizeType type) {
        assertTrue(type.side1Mm > 0, type.name() + "のside1Mmが0以下です");
        assertTrue(type.side2Mm > 0, type.name() + "のside2Mmが0以下です");
        // 判型名と値の対応（例：A4は210×297）
        switch (type) {
            case A0 -> { assertEquals(841, type.side1Mm); assertEquals(1189, type.side2Mm); }
            case A1 -> { assertEquals(594, type.side1Mm); assertEquals(841, type.side2Mm); }
            case A2 -> { assertEquals(420, type.side1Mm); assertEquals(594, type.side2Mm); }
            case A3 -> { assertEquals(297, type.side1Mm); assertEquals(420, type.side2Mm); }
            case A4 -> { assertEquals(210, type.side1Mm); assertEquals(297, type.side2Mm); }
            case A5 -> { assertEquals(148, type.side1Mm); assertEquals(210, type.side2Mm); }
            case A6 -> { assertEquals(105, type.side1Mm); assertEquals(148, type.side2Mm); }
            case A7 -> { assertEquals(74, type.side1Mm); assertEquals(105, type.side2Mm); }
            case A8 -> { assertEquals(52, type.side1Mm); assertEquals(74, type.side2Mm); }
            case A9 -> { assertEquals(37, type.side1Mm); assertEquals(52, type.side2Mm); }
            case A10 -> { assertEquals(26, type.side1Mm); assertEquals(37, type.side2Mm); }
            case B0 -> { assertEquals(1030, type.side1Mm); assertEquals(1456, type.side2Mm); }
            case B1 -> { assertEquals(728, type.side1Mm); assertEquals(1030, type.side2Mm); }
            case B2 -> { assertEquals(515, type.side1Mm); assertEquals(728, type.side2Mm); }
            case B3 -> { assertEquals(364, type.side1Mm); assertEquals(515, type.side2Mm); }
            case B4 -> { assertEquals(257, type.side1Mm); assertEquals(364, type.side2Mm); }
            case B5 -> { assertEquals(182, type.side1Mm); assertEquals(257, type.side2Mm); }
            case B6 -> { assertEquals(128, type.side1Mm); assertEquals(182, type.side2Mm); }
            case B7 -> { assertEquals(91, type.side1Mm); assertEquals(128, type.side2Mm); }
            case B8 -> { assertEquals(64, type.side1Mm); assertEquals(91, type.side2Mm); }
            case B9 -> { assertEquals(45, type.side1Mm); assertEquals(64, type.side2Mm); }
            case B10 -> { assertEquals(32, type.side1Mm); assertEquals(45, type.side2Mm); }
        }
    }
}
