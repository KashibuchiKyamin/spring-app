package com.kashibuchikyamin.spring_app.domain.model;

/**
 * 加工情報を表すレコード。
 */
public record OrderProcessInfo(
    /** ラベル（加工1など） */
    String label,
    /** 加工内容 */
    String description
) {}
