package com.cms.cache;

import com.cms.base.BaseJunit4Test;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created by mao on 2017/8/8.
 */
public class RedisTest extends BaseJunit4Test {
    @Autowired
    private JedisPool JedisPool;
    @Test
    public void basicTest(){
        Jedis jedis = JedisPool.getResource();
        //存值
        jedis.set("user.name", "aaa");
        jedis.set("user.pass", "123");

        //取值
        String name = jedis.get("user.name");
        String pass = jedis.get("user.pass");
        //断言
        Assert.assertEquals("aaa", name);
        //Assert.assertEquals("1234", pass);//错误
        Assert.assertEquals("123", pass);

        jedis.del("user.name");
        Boolean result = jedis.exists("user.name");
        Assert.assertEquals(false, result);

        result = jedis.exists("user.pass");
        Assert.assertEquals(true, result);

        jedis.close();
    }
}
