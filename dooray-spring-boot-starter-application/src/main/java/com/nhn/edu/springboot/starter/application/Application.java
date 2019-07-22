package com.nhn.edu.springboot.starter.application;

import com.nhnent.dooray.client.DoorayHook;
import com.nhnent.dooray.client.DoorayHookSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    /**
     * TODO (9) @Autowired 로 DoorayHookSender 의존성을 주입합니다.
     * TODO (9) @AutowiredにDoorayHookSender依存性を注入します。
     */
    @Autowired
    private DoorayHookSender doorayHookSender;


    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    /**
     * TODO (10) ApplicationReady 일때!, DoorayHookSender 로 Hook 을 발송하는 빈을 선언해 주세요.
     * TODO (10) ApplicationReady時！、DoorayHookSenderでHookを送信する空を宣言してください。
     */
    @Bean
    public ApplicationListener<ApplicationReadyEvent> applicationListener() {
        return (event) -> {
            doorayHookSender.send(new DoorayHook("JB",
                                                 "https://translate.nhnent.com/icon/botimage.jpg",
                                                 "jungbin.kim - 감사합니다",
                                                 null)
            );
        };
    }
}
