package com.example.eurekaclient.configs;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties("config")
public class SystemConfig {
    /**
     * redis服务器列表。
     */
    private List<String> redisServer;

    public List<String> getRedisServer() {
        return redisServer;
    }

    public void setRedisServer(List<String> redisServer) {
        this.redisServer = redisServer;
    }
}
