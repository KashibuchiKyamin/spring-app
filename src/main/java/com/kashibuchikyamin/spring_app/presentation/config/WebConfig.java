package com.kashibuchikyamin.spring_app.presentation.config;

import com.kashibuchikyamin.spring_app.presentation.advice.ControllerLoggingAdvice;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * ControllerLoggingAdviceをInterceptorとして登録するSpring MVC設定クラス
 * この設定により、全てのコントローラー実行時に開始・終了ログが出力される
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    private final ControllerLoggingAdvice controllerLoggingAdvice;

    /**
     * コンストラクタ。ControllerLoggingAdviceはDIされます。
     * @param controllerLoggingAdvice 開始・終了ログ出力Advice
     */
    public WebConfig(ControllerLoggingAdvice controllerLoggingAdvice) {
        this.controllerLoggingAdvice = controllerLoggingAdvice;
    }

    /**
     * Interceptorの登録。
     * @param registry InterceptorRegistry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(controllerLoggingAdvice);
    }
}