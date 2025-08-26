package com.kashibuchikyamin.spring_app.presentation.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Ajaxリクエスト時の例外発生時に統一されたエラーレスポンスを返すAdvice
 * presentation.controllerパッケージ配下のRestController/Controllerが対象
 */
@RestControllerAdvice(basePackages = "com.kashibuchikyamin.spring_app.presentation.controller")
public class GlobalAjaxExceptionHandler {
	/** SLF4Jロガー。エラー時のログ出力に使用 */
	private static final Logger logger = LoggerFactory.getLogger(GlobalAjaxExceptionHandler.class);

	/**
	 * 予期しない例外発生時のハンドリング。
	 * @param ex 発生した例外
	 * @return 統一フォーマットのエラーレスポンス
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<AjaxErrorResponse> handleException(Exception ex) {
		logger.error("Ajaxリクエスト処理中に例外が発生しました", ex);
		AjaxErrorResponse error = new AjaxErrorResponse(
				HttpStatus.INTERNAL_SERVER_ERROR.value(),
				"サーバ内部で予期しないエラーが発生しました。",
				ex.getClass().getSimpleName());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
	}
}