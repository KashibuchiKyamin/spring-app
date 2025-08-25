package com.kashibuchikyamin.spring_app.infrastructure.datasource.repositoryimpl.top;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.kashibuchikyamin.spring_app.domain.repository.top.TopPageRepository;
import com.kashibuchikyamin.spring_app.infrastructure.datasource.entity.OrderEntity;
import com.kashibuchikyamin.spring_app.infrastructure.datasource.mapper.OrderMapper;
import com.kashibuchikyamin.spring_app.presentation.controller.top.response.OrderListResponse;

@Repository
public class TopPageRepositoryImpl implements TopPageRepository {

	final OrderMapper orderMapper;

	public TopPageRepositoryImpl(OrderMapper orderMapper) {
		this.orderMapper = orderMapper;
	}

	@Override
	public OrderListResponse getOrderList() {

		int count = orderMapper.getAllCount();
		List<OrderEntity> records = orderMapper.findAllLimit10();

		// OrderEntityのリストをOrderListResponse.OrderSummaryのリストに変換
		List<OrderListResponse.OrderSummary> data = OrderEntity.toOrderSummaryList(records);
		return new OrderListResponse(count, data);
	}

}
