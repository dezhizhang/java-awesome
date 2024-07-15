package com.xiaozhicloud.test;

import com.xiaozhicloud.jedis.utils.JedisConnectionFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

import java.util.Map;

public class JedisTest {
    private Jedis jedis;

    @BeforeEach
    void setUp() {
        // 建立连接
//        jedis = new Jedis("127.0.0.1",6379);
        jedis = JedisConnectionFactory.getJedis();
        // 高置密码
//        jedis.auth("");
        // 选择库
        jedis.select(0);
    }

    @Test
    void testString() {
        String result = jedis.set("name","小明wew");
        System.out.println(result);

        // 获取数据
        String name = jedis.get("name");
        System.out.println(name);
    }

    // 释放连接
    @AfterEach
    void tearDown() {
        if(jedis != null) {
            jedis.close();
        }
    }

//
//    @Test
//    void testString() {
//        String result = jedis.set("name", "hello world");
//        System.out.println(result);
//
//        // 获取数据
//        String name = jedis.get("name");
//        System.out.println("name=" + name);
//    }
//
//    @Test
//    void testHash() {
//        jedis.hset("user:1","name","jack");
//        jedis.hset("user:1","age","22");
//
//        Map<String,String> map = jedis.hgetAll("user:1");
//
//        System.out.println(map);
//
//    }
//

}
