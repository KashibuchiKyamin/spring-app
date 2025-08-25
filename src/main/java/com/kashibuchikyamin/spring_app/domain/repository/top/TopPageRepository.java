package com.kashibuchikyamin.spring_app.domain.repository.top;

import com.kashibuchikyamin.spring_app.presentation.controller.top.response.OrderListResponse;

public interface TopPageRepository {

	/**
	* 案件一覧を取得します。
	* @return 案件一覧
	*/
	OrderListResponse getOrderList();

}
