package com.kashibuchikyamin.spring_app.application.service.top.dto;

import java.util.List;

import com.kashibuchikyamin.spring_app.domain.model.top.OrderListData;

/**
 * トップページ「案件一覧」Ajaxレスポンス用レコード
 * @param total 案件の合計件数
 * @param data 案件概要リスト
 */
public record OrderListDto(
		int total,
		List<OrderListDto.OrderSummary> data) {

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

	/**
	 * コンストラクタ.
	 * ドメインモデルの OrderListData からインスタンスを生成
	 * @param data
	 */
	public OrderListDto(OrderListData data) {
		this(data.total(), data.data().stream()
				.map(d -> new OrderSummary(d.title(), d.customer(), d.orderId()))
				.toList());
	}

}