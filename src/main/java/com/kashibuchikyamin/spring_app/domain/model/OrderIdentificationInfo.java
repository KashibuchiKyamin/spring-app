package com.kashibuchikyamin.spring_app.domain.model;

import java.util.List;

/**
 * 注文識別情報データを保持するレコード
 * @param total 注文の合計件数
 * @param data 注文識別情報リスト
 */
public record OrderIdentificationInfo(
		int total,
		List<OrderIdentificationInfo.OrderSummary> data) {

	/**
	 * 注文識別情報を表すレコード
	 * <p>
	 * top.json の data 配列の各要素に対応
	 * </p>
	 * @param title 注文タイトル
	 * @param customer 顧客名
	 * @param orderId 注文ID
	 */
	public static record OrderSummary(
			String title,
			String customer,
			String orderId) {
	}
}