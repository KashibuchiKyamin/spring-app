package com.kashibuchikyamin.spring_app.presentation.controller.top.response;

import java.util.List;

/**
 * トップページ「案件一覧」Ajaxレスポンスを表すレコードです。
 * <p>
 * {@link com.kashibuchikyamin.spring_app.presentation.controller.top.TopPageController#getOrderList()} で返却されるJSONの構造に対応します。
 * </p>
 * <pre>
 * 例：
 * {
 *   "total": 15,
 *   "data": [
 *     {
 *       "title": "都立花巻中学校2025年度卒業アルバム",
 *       "customer": "都立花巻中学校",
 *       "orderId": "ORD20250000001"
 *     },
 *     ...
 *   ]
 * }
 * </pre>
 *
 * @param total 案件の合計件数
 * @param data 案件概要リスト
 */
public record OrderListResponse(
		int total,
		List<OrderListResponse.OrderSummary> data) {

	/**
	 * 案件概要を表すレコードです。
	 * <p>
	 * top.json の data 配列の各要素に対応します。
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