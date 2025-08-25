package com.kashibuchikyamin.spring_app.domain.repository.top;

import com.kashibuchikyamin.spring_app.domain.model.top.OrderListData;

public interface TopPageRepository {

	/**
	* 案件一覧を取得します。
	* @return 案件一覧
	*/
	OrderListData getOrderList();

}
