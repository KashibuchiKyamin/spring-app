package com.kashibuchikyamin.spring_app.application.service.top;

import org.springframework.stereotype.Service;

import com.kashibuchikyamin.spring_app.application.service.top.dto.OrderListDto;
import com.kashibuchikyamin.spring_app.domain.model.OrderIdentificationInfo;
import com.kashibuchikyamin.spring_app.domain.repository.OrderIdentificationInfoRepository;

@Service
public class TopPageService {

	/** 注文識別情報リポジトリ */
	private final OrderIdentificationInfoRepository orderIdentificationInfoRepository;

	public TopPageService(OrderIdentificationInfoRepository orderIdentificationInfoRepository) {
		this.orderIdentificationInfoRepository = orderIdentificationInfoRepository;
	}

	/**
	 * 注文一覧を取得します。
	 * @return 注文一覧
	 */
	public OrderListDto getOrderList() {
		OrderIdentificationInfo orderList = orderIdentificationInfoRepository.getOrderList();
		return new OrderListDto(orderList);
	}
}