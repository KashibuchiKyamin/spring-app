package com.kashibuchikyamin.spring_app.domain.model;

/**
 * 配送情報を表すレコード。
 */
public record OrderDeliveryInfo(
    /** ラベル（配送1など） */
    String label,
    /** 配送方法 */
    String method,
    /** 部数 */
    String quantity,
    /** 納品先 */
    String destination
) {}
