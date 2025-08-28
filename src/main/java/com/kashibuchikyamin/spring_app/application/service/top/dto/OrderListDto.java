package com.kashibuchikyamin.spring_app.application.service.top.dto;

import java.util.List;

import com.kashibuchikyamin.spring_app.domain.model.OrderIdentificationInfo;

/**
 * トップページ「注文一覧」Ajaxレスポンス用レコード
 * @param total 注文の合計件数
 * @param data 注文概要リスト
 */
public record OrderListDto(
		int total,
		List<OrderListDto.OrderSummary> data) {

	/**
	 * 注文概要を表すレコード
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

	/**
	 * コンストラクタ.
	 * ドメインモデルの OrderIdentificationInfo からインスタンスを生成
	 * @param data
	 */
	public OrderListDto(OrderIdentificationInfo data) {
		this(data.total(), data.data().stream()
				.map(d -> new OrderSummary(d.title(), d.customer(), d.orderId()))
				.toList());
	}

}