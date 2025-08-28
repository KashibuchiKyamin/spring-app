package com.kashibuchikyamin.spring_app.domain.model;

/**
 * 案件基本情報を表すレコード。
 */
public record OrderBasicInfo(
    /** 案件名 */
    String orderName,
    /** 顧客名 */
    String customerName,
    /** サイズ */
    String size,
    /** 頁情報リスト */
    java.util.List<String> pages,
    /** 印刷仕様リスト */
    java.util.List<String> print,
    /** 加工仕様リスト */
    java.util.List<String> process,
    /** 製本仕様リスト */
    java.util.List<String> binding,
    /** 部数リスト */
    java.util.List<String> quantity
) {}
