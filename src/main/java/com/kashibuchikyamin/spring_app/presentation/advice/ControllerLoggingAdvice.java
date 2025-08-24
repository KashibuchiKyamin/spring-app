package com.kashibuchikyamin.spring_app.presentation.advice;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * presentation.controllerパッケージ配下のControllerのみ開始・終了ログを出力するAdvice。
 * <p>
 * basePackages属性で対象パッケージを指定。
 * 各コントローラメソッドの実行前（preHandle）と実行後（postHandle）で、
 * コントローラ名とメソッド名をINFOレベルでログ出力します。
 * </p>
 */
@ControllerAdvice(basePackages = "com.kashibuchikyamin.spring_app.presentation.controller")
public class ControllerLoggingAdvice implements HandlerInterceptor {
	/** SLF4Jロガー。ログ出力に使用 */
	private static final Logger logger = LoggerFactory.getLogger(ControllerLoggingAdvice.class);

	/**
	 * コントローラメソッドの開始時に呼ばれ、開始ログを出力します。
	 * @param request HTTPリクエスト
	 * @param response HTTPレスポンス
	 * @param handler ハンドラ（コントローラメソッド）
	 * @return 常にtrue（処理継続）
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		if (handler instanceof HandlerMethod method) {
			logger.info("[START] {}.{}", method.getBeanType().getSimpleName(), method.getMethod().getName());
		}
		return true;
	}

	/**
	 * コントローラメソッドの終了時に呼ばれ、終了ログを出力します。
	 * @param request HTTPリクエスト
	 * @param response HTTPレスポンス
	 * @param handler ハンドラ（コントローラメソッド）
	 * @param modelAndView ModelAndView（未使用）
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) {
		if (handler instanceof HandlerMethod method) {
			logger.info("[END] {}.{}", method.getBeanType().getSimpleName(), method.getMethod().getName());
		}
	}
}