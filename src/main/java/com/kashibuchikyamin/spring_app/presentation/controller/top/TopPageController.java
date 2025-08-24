package com.kashibuchikyamin.spring_app.presentation.controller.top;

import java.io.IOException;
import java.nio.file.Files;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * トップページ表示および注文リストのAjaxリクエストを処理するコントローラーです。
 */
@Controller
@RequestMapping("/top")
public class TopPageController {
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
	 * top.jsonの内容をJSONとして返却します。
	 * @return 注文リストデータ(JSON)
	 */
	@GetMapping(value = "/orderList", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> getOrderList() throws IOException {
		// resources/ajaxResponse/top.json を読み込んで返却
		ClassPathResource resource = new ClassPathResource("ajaxResponse/top.json");
		String json = Files.readString(resource.getFile().toPath());
		return ResponseEntity.ok(json);
	}
}