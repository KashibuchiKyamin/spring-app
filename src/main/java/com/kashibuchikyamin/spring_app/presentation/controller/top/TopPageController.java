package com.kashibuchikyamin.spring_app.presentation.controller.top;

import java.io.IOException;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kashibuchikyamin.spring_app.application.service.top.TopPageService;
import com.kashibuchikyamin.spring_app.presentation.controller.top.response.OrderListResponse;

/**
 * トップページ表示および案件一覧のAjaxリクエストを処理するコントローラー
 * 案件一覧取得API（/top/orderList）は、resources/ajaxResponse/top.jsonの内容をOrderListResponseとして返却
 */
@Controller
@RequestMapping("/top")
public class TopPageController {
	/** JacksonのObjectMapper。JSON変換に利用 */
	private final TopPageService topPageService;

	/**
	 * コンストラクタ。
	 * @param topPageService トップページサービス
	 */
	public TopPageController(TopPageService topPageService) {
		this.topPageService = topPageService;
	}

	/**
	 * トップページ（top.html）を表示します。
	 * @param model モデル
	 * @return テンプレート名
	 */
	@GetMapping
	public String showTopPage(Model model) {
		// 必要に応じてモデルに属性を追加
		return "top";
	}

	/**
	 * 画面項目「案件一覧」のAjaxリクエストを処理します。
	 * <p>
	 * resources/ajaxResponse/top.jsonを読み込み、OrderListResponseとして返却します。
	 * </p>
	 * @return 案件一覧データ（JSON）
	 * @throws IOException ファイル読み込み・JSON変換失敗時
	 */
	@GetMapping(value = "/orderList", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<OrderListResponse> getOrderList() throws IOException {

		OrderListResponse orderListResponse = OrderListResponse.from(topPageService.getOrderList());

		return ResponseEntity.ok(orderListResponse);
	}
}