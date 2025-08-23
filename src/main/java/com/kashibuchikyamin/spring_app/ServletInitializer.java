package com.kashibuchikyamin.spring_app;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * サーブレットコンテナ上でSpring Bootアプリケーションを初期化・構成するクラスです。
 * 主にWARデプロイ時に使用されます。
 */
public class ServletInitializer extends SpringBootServletInitializer {

	/**
	 * Spring Bootアプリケーションの設定を行います。
	 *
	 * @param application SpringApplicationBuilderインスタンス
	 * @return 設定済みのSpringApplicationBuilderインスタンス
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringAppApplication.class);
	}

}