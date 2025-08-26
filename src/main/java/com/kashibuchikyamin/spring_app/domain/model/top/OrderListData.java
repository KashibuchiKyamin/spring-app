package com.kashibuchikyamin.spring_app.domain.model.top;

import java.util.List;

/**
 * 案件一覧用データを保持するレコード
 * @param total 案件の合計件数
 * @param data 案件概要リスト
 */
public record OrderListData(
		int total,
		List<OrderListData.OrderSummary> data) {

	/**
	 * 案件概要を表すレコード
	 * <p>
	 * top.json の data 配列の各要素に対応
	 * </p>
	 * @param title 案件タイトル
	 * @param customer 顧客名
	 * @param orderId 案件ID
	 */
	public static record OrderSummary(
			String title,
			String customer,
			String orderId) {
	}
}