package com.zaki.config;

import com.zaki.handler.MyWebSocketHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfig extends WebMvcConfigurerAdapter implements WebSocketConfigurer {


    @Autowired
    private MyWebSocketHandler handler;

    @Autowired
    private HandShake handShake;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(handler, "/message")
                .addInterceptors(handShake).setAllowedOrigins("*")
                .addHandler(handler, "/message/2")
                .addInterceptors(handShake).setAllowedOrigins("*");
    }
}
