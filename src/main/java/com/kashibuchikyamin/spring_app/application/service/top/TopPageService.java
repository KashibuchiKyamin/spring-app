package com.kashibuchikyamin.spring_app.application.service.top;

import org.springframework.stereotype.Service;

import com.kashibuchikyamin.spring_app.application.service.top.dto.OrderListDto;
import com.kashibuchikyamin.spring_app.domain.model.ProjectIdentificationInfo;
import com.kashibuchikyamin.spring_app.domain.repository.ProjectIdentificationInfoRepository;

@Service
public class TopPageService {

	/** トップページリポジトリ */
	private final ProjectIdentificationInfoRepository projectIdentificationInfoRepository;

	public TopPageService(ProjectIdentificationInfoRepository projectIdentificationInfoRepository) {
		this.projectIdentificationInfoRepository = projectIdentificationInfoRepository;
	}

	/**
	 * 案件一覧を取得します。
	 * @return 案件一覧
	 */
	public OrderListDto getOrderList() {
		ProjectIdentificationInfo orderList = projectIdentificationInfoRepository.getOrderList();

		return new OrderListDto(orderList);
	}
}
