package com.kashibuchikyamin.spring_app.application.service.top;

import org.springframework.stereotype.Service;

import com.kashibuchikyamin.spring_app.domain.repository.top.TopPageRepository;
import com.kashibuchikyamin.spring_app.presentation.controller.top.response.OrderListResponse;

@Service
public class TopPageService {

	/** トップページリポジトリ */
	private final TopPageRepository topPageRepository;
	
	public TopPageService(TopPageRepository topPageRepository) {
		this.topPageRepository = topPageRepository;
	}

	/**
	 * 案件一覧を取得します。
	 * @return 案件一覧
	 */
	public OrderListResponse getOrderList() {
		return topPageRepository.getOrderList();
	}
}
