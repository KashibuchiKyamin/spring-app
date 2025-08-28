package com.kashibuchikyamin.spring_app.domain.model;

/**
 * 用紙情報を表すレコード。
 */
public record OrderPaperInfo(
    /** ラベル（用紙1/用紙2など） */
    String label,
    /** 用途（表紙/本文など） */
    String type,
    /** 用紙仕様 */
    String spec,
    /** 包数 */
    String bundle
) {}
