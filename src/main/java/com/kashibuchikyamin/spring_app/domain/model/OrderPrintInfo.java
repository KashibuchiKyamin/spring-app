package com.kashibuchikyamin.spring_app.domain.model;

/**
 * 印刷情報を表すレコード。
 */
public record OrderPrintInfo(
    /** ラベル（印刷1/印刷2など） */
    String label,
    /** 用途（表紙/本文など） */
    String type,
    /** サイズ */
    String size,
    /** 色数 */
    String color,
    /** 通し番号 */
    String serial,
    /** 特色 */
    String specialColor
) {}
