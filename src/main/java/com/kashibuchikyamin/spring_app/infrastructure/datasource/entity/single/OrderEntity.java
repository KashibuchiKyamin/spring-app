package com.kashibuchikyamin.spring_app.infrastructure.datasource.entity.single;

import java.util.List;

import com.kashibuchikyamin.spring_app.domain.model.ProjectIdentificationInfo.OrderSummary;

/**
 * 案件（注文）テーブルのエンティティ用レコード
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
		java.time.LocalDateTime updatedAt) {

	/**
	 * OrderEntityのリストをOrderSummaryのリストに変換します。
	 * @param records 変換元のOrderEntityリスト
	 * @return 変換後のOrderSummaryリスト
	 */
	public static List<OrderSummary> toOrderSummaryList(List<OrderEntity> records) {
		if (records == null) {
			return List.of();
		}
		// OrderEntityのリストをOrderSummaryのリストに変換
		List<OrderSummary> list = records.stream()
				.map(e -> new OrderSummary(e.title(), e.customer(), e.orderId()))
				.toList();
		return list;
	}
}