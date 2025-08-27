package com.kashibuchikyamin.spring_app.presentation.controller.top.response;

import java.util.List;

import com.kashibuchikyamin.spring_app.application.service.top.dto.OrderListDto;

/**
 * トップページ「案件一覧」Ajaxレスポンス用レコード
 * @param total 案件の合計件数
 * @param data 案件概要リスト
 */
public record OrderListResponse(
		int total,
		List<OrderListDto.OrderSummary> data) {

	/**
	 * コンストラクタ.
	 * @param dto サービス層の DTO
	 */
	public OrderListResponse(OrderListDto dto) {
		this(dto.total(), dto.data());
	}
}