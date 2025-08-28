package com.kashibuchikyamin.spring_app.domain.model;

/**
 * 製本情報を表すレコード。
 */
public record OrderBindingInfo(
    /** ラベル（製本1など） */
    String label,
    /** 製本内容 */
    String description
) {}
