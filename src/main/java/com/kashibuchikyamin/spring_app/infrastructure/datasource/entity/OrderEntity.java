package com.kashibuchikyamin.spring_app.infrastructure.datasource.entity;

/**
 * 案件（注文）テーブルのエンティティ。
 * MyBatisのマッピング用レコード。
 * @param orderId 案件ID
 * @param title 案件タイトル
 * @param customer 顧客名
 * @param salesRepId 担当営業ID
 * @param createdAt 作成日時
 * @param updatedAt 更新日時
 */
public record OrderEntity(
    String orderId,
    String title,
    String customer,
    String salesRepId,
    java.time.LocalDateTime createdAt,
    java.time.LocalDateTime updatedAt
) {}
