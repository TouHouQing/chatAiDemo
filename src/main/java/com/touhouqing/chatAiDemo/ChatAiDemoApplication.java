package com.touhouqing.chatAiDemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.touhouqing.chatAiDemo.mapper")
@SpringBootApplication
public class ChatAiDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChatAiDemoApplication.class, args);
    }

}
