package com.example.eurekaclient.common;

import com.alibaba.fastjson.JSON;
import com.example.eurekaclient.configs.SystemConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * redis连接客户端。
 */
@Component
public class RedisClient {
    @Autowired
    private SystemConfig systemConfig;

    private JedisCluster defaultClient = null;

    private static final String GET = "get";
    private static final String SET = "set";
    private static final String DEL = "del";
    private static final String SET_EXPIRE = "serex";
    /**
     * 将对象序列化成json字符串,存入缓存。
     *
     * @param key
     * @param value
     * @return
     */
    public String setObjectJson(String key, Object value) {
        String jsonStr = JSON.toJSONString(value);
        return this.set(key, jsonStr);
    }

    /**
     * 将对象序列化成json字符串,存入缓存,并设置过期时间。
     *
     * @param key
     * @param value
     * @param second 过期秒数。
     * @return
     */
    public String setObject(String key, Object value, int second) {
        String jsonStr = JSON.toJSONString(value);
        return set(key, jsonStr, second);
    }

    /**
     * 获取指定key和class的valueObject。
     *
     * @param key
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T getObject(String key, Class<T> clazz) {
        String jsonStr = get(key);
        try {
            if (!StringUtil.isNullOrEmpty(jsonStr)) {
                T result = JSON.parseObject(jsonStr, clazz);
                return result;
            }
        } catch (Exception ex) {
        }
        return null;
    }

    /**
     * 缓存字符串,不过期。
     *
     * @param key
     * @param value
     * @return
     */
    public String set(String key, String value) {
        return execute(SET, new String[]{key, value});
    }

    /**
     * 获取指定key和class的valueList。
     *
     * @param key
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> List<T> getList(String key, Class<T> clazz) {
        String jsonStr = get(key);
        try {
            if (!StringUtil.isNullOrEmpty(jsonStr)) {
                List<T> result = JSON.parseArray(jsonStr, clazz);
                return result;
            }
        } catch (Exception ex) {
        }
        return null;
    }

    /**
     * 缓存字符串,指定过期时间。
     *
     * @param key
     * @param value
     * @param second
     * @return
     */
    public String set(String key, String value, int second) {
        return execute(SET_EXPIRE, new String[]{key, String.valueOf(second), value});
    }

    /**
     * 获取一个字符串。
     *
     * @param key
     * @return
     */
    public String get(String key) {
        return execute(GET, new String[]{key});
    }

    /**
     * 删除key。
     *
     * @param key
     * @return 0-失败,大于0-成功。
     */
    public int delete(String key) {
        return StringUtil.getIntValue(execute(DEL, new String[]{key}));
    }

    /**
     * 操作字符串
     *
     * @param method 方法
     * @param args   参数
     * @return
     */
    private String execute(String method, String[] args) {
        try {
            if (SET.equals(method)) {
                return getDefaultClient().set(args[0], args[1]);
            } else if (GET.equals(method)) {
                return getDefaultClient().get(args[0]);
            } else if (SET_EXPIRE.equals(method)) {
                return getDefaultClient().setex(args[0], Integer.parseInt(args[1]), args[2]);
            } else if (DEL.equals(method)) {
                return StringUtil.getString(getDefaultClient().del(args[0]));
            }
        } catch (Exception e) {
        }
        return "";
    }

    private synchronized JedisCluster getDefaultClient() {
        if (defaultClient == null) {
            defaultClient = initJedisCluster(systemConfig.getRedisServer());
        }
        return defaultClient;
    }

    private JedisCluster initJedisCluster(List<String> hostAndPorts) {
        // 推荐使用只加入一个即可完成
        Set<HostAndPort> set = new HashSet<>();
        for (String item : hostAndPorts) {
            String[] array = item.split(":");
            set.add(new HostAndPort(array[0], StringUtil.getIntValue(array[1])));
        }
        return new JedisCluster(set);
    }
}