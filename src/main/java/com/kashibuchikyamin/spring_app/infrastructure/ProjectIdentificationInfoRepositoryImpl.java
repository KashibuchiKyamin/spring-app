package com.kashibuchikyamin.spring_app.infrastructure;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.kashibuchikyamin.spring_app.domain.model.ProjectIdentificationInfo;
import com.kashibuchikyamin.spring_app.domain.repository.ProjectIdentificationInfoRepository;
import com.kashibuchikyamin.spring_app.infrastructure.datasource.entity.single.OrderEntity;
import com.kashibuchikyamin.spring_app.infrastructure.datasource.mapper.single.OrderMapper;

/**
 * 案件識別情報リポジトリ実装
 */
@Repository
public class ProjectIdentificationInfoRepositoryImpl implements ProjectIdentificationInfoRepository {

	final OrderMapper orderMapper;

	public ProjectIdentificationInfoRepositoryImpl(OrderMapper orderMapper) {
		this.orderMapper = orderMapper;
	}

	@Override
	public ProjectIdentificationInfo getOrderList() {

		int count = orderMapper.getAllCount();
		List<OrderEntity> records = orderMapper.findAllLimit10();

		// OrderEntityのリストをOrderListResponse.OrderSummaryのリストに変換
		List<ProjectIdentificationInfo.OrderSummary> data = OrderEntity.toOrderSummaryList(records);
		return new ProjectIdentificationInfo(count, data);
	}

}