package com.kashibuchikyamin.spring_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Bootアプリケーションのエントリポイントとなるクラス
 * アプリケーションの起動処理を担当
 */
@SpringBootApplication
public class SpringAppApplication {

	/**
	 * アプリケーションを起動
	 * @param args コマンドライン引数
	 */
	public static void main(String[] args) {
		SpringApplication.run(SpringAppApplication.class, args);
	}

}