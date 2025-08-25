package com.kashibuchikyamin.spring_app.infrastructure.datasource.repositoryimpl.top;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.kashibuchikyamin.spring_app.domain.model.top.OrderListData;
import com.kashibuchikyamin.spring_app.domain.repository.top.TopPageRepository;
import com.kashibuchikyamin.spring_app.infrastructure.datasource.entity.OrderEntity;
import com.kashibuchikyamin.spring_app.infrastructure.datasource.mapper.OrderMapper;

@Repository
public class TopPageRepositoryImpl implements TopPageRepository {

	final OrderMapper orderMapper;

	public TopPageRepositoryImpl(OrderMapper orderMapper) {
		this.orderMapper = orderMapper;
	}

	@Override
	public OrderListData getOrderList() {

		int count = orderMapper.getAllCount();
		List<OrderEntity> records = orderMapper.findAllLimit10();

		// OrderEntityのリストをOrderListResponse.OrderSummaryのリストに変換
		List<OrderListData.OrderSummary> data = OrderEntity.toOrderSummaryList(records);
		return new OrderListData(count, data);
	}

}
