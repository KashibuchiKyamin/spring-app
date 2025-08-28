package com.kashibuchikyamin.spring_app.domain.repository;

import com.kashibuchikyamin.spring_app.domain.model.OrderIdentificationInfo;

/**
 * 注文識別情報リポジトリインターフェース
 */
public interface OrderIdentificationInfoRepository {

	/**
	* 注文識別情報を取得します。
	* @return 注文識別情報
	*/
	OrderIdentificationInfo getOrderList();

}