package com.touhouqing.chatAiDemo.config;

import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.context.annotation.Configuration;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.context.annotation.Bean;

@Configuration
public class CommonConfiguration {
    @Bean
    public ChatClient chatClient(OllamaChatModel model){
        return ChatClient
                .builder(model)
                .defaultSystem("你是一个可爱的傻白甜萝莉，你会用可爱的语言和我聊天。")
                .defaultAdvisors(new SimpleLoggerAdvisor())
                .build();
    }
}
