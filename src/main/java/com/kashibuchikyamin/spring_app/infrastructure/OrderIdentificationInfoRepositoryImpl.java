package com.kashibuchikyamin.spring_app.infrastructure;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.kashibuchikyamin.spring_app.domain.model.OrderIdentificationInfo;
import com.kashibuchikyamin.spring_app.domain.repository.OrderIdentificationInfoRepository;
import com.kashibuchikyamin.spring_app.infrastructure.datasource.entity.single.OrderEntity;
import com.kashibuchikyamin.spring_app.infrastructure.datasource.mapper.single.OrderMapper;

/**
 * 注文識別情報リポジトリ実装
 */
@Repository
public class OrderIdentificationInfoRepositoryImpl implements OrderIdentificationInfoRepository {

	final OrderMapper orderMapper;

	public OrderIdentificationInfoRepositoryImpl(OrderMapper orderMapper) {
		this.orderMapper = orderMapper;
	}

	@Override
	public OrderIdentificationInfo getOrderList() {

		int count = orderMapper.getAllCount();
		List<OrderEntity> records = orderMapper.findAllLimit10();

		// OrderEntityのリストをOrderIdentificationInfo.OrderSummaryのリストに変換
		List<OrderIdentificationInfo.OrderSummary> data = OrderEntity.toOrderSummaryList(records);
		return new OrderIdentificationInfo(count, data);
	}

}