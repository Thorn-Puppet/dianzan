package com.zan.cache;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

@Component
public class RedisHandler {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 存储缓存
     * @param key
     * @param value
     * @throws Exception
     */
    public void setString(String key,String value) throws Exception{
        stringRedisTemplate.boundValueOps(key).set(value);
    }

    /**
     * 通过通配符查询全部key
     * @param expression
     * @return
     */
    public Set<String> queryKeyByExpression(String expression){
        Set<String> keys = stringRedisTemplate.keys(expression);
        return keys;
    }
}
