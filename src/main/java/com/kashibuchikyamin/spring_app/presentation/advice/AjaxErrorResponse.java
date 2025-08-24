package com.kashibuchikyamin.spring_app.presentation.advice;

/**
 * Ajaxリクエスト時のエラーレスポンス用レコード。
 * @param status HTTPステータスコード
 * @param message エラーメッセージ
 * @param errorCode 例外クラス名等のエラーコード
 */
public record AjaxErrorResponse(
    int status,
    String message,
    String errorCode
) {}
