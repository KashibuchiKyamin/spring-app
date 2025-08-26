package com.kashibuchikyamin.spring_app.presentation.controller.top.response;

import java.util.List;

import com.kashibuchikyamin.spring_app.domain.model.top.OrderListData;

/**
 * トップページ「案件一覧」Ajaxレスポンス用レコード
 * @param total 案件の合計件数
 * @param data 案件概要リスト
 */
public record OrderListResponse(
		int total,
		List<OrderListData.OrderSummary> data) {

	/**
	 * ドメインモデルの OrderListData からレスポンス用の OrderListResponse を生成
	 * @param orderListData ドメインモデルの案件一覧データ
	 * @return レスポンス用の案件一覧データ
	 */
	public static OrderListResponse from(OrderListData orderListData) {
		return new OrderListResponse(orderListData.total(), orderListData.data());
	}
}