package cn.tedu.gyf;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;



/**
 * @Date 2020/8/17 11:23
 * @Author GuoYunFeng
 * @Email guoyunfeng520@outllok.com
 */
@SpringBootTest
public class RedisIOCTest {

    @Autowired
    private JedisCluster jedisCluster;

    @Test
    public void clusterTest(){
        jedisCluster.set("haha","gyf");
        System.out.println(jedisCluster.get("haha"));
    }
}
