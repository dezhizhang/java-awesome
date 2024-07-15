package com.xiaozhicloud.jedis.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisConnectionFactory {
  private static  final JedisPool jedisPool;

  static {

      JedisPoolConfig poolConfig =  new JedisPoolConfig();
      // 最大连接数
      poolConfig.setMaxTotal(8);
      // 最多连接数
      poolConfig.setMaxIdle(8);
      // 最小连接
      poolConfig.setMaxIdle(0);
      // 最多等待时长
      poolConfig.setMaxWaitMillis(1000);
      // 创建连接池对像
      jedisPool = new JedisPool(poolConfig,"127.0.0.1",6379,1000);
  }

  // 静态方法对外提供连接池对像
  public static Jedis getJedis() {
      return  jedisPool.getResource();
  }

}
