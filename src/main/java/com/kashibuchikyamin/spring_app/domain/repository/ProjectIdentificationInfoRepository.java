package com.kashibuchikyamin.spring_app.domain.repository;

import com.kashibuchikyamin.spring_app.domain.model.ProjectIdentificationInfo;

/**
 * 案件識別情報リポジトリインターフェース
 */
public interface ProjectIdentificationInfoRepository {

	/**
	* 案件識別情報を取得します。
	* @return 案件識別情報
	*/
	ProjectIdentificationInfo getOrderList();

}