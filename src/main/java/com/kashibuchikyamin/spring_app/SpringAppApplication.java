package com.kashibuchikyamin.spring_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Bootアプリケーションのエントリーポイントとなるクラスです。
 * アプリケーションの起動処理を担当します。
 */
@SpringBootApplication
public class SpringAppApplication {

	/**
	 * アプリケーションを起動します。
	 *
	 * @param args コマンドライン引数
	 */
	public static void main(String[] args) {
		SpringApplication.run(SpringAppApplication.class, args);
	}

}