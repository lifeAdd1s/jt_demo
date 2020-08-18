package cn.tedu.gyf;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.*;
import redis.clients.jedis.params.SetParams;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Date 2020/8/12 14:39
 * @Author GuoYunFeng
 * @Email guoyunfeng520@outllok.com
 */
@SpringBootTest
public class RedisTest {

    private Jedis connection(){
        return new Jedis("192.168.126.129",6379);
    }


    @Test
    public void test01(){
        Jedis jedis=connection();

        jedis.set("boos","马云");
        System.out.println(jedis.get("boos"));
    }

    @Test
    public void test02(){
        Jedis jedis=connection();
        jedis.flushAll();
        jedis.setnx("a","b");
        jedis.setnx("a","c");
        System.out.println(jedis.get("a"));
    }

    @Test
    public void test03(){
        Jedis jedis=connection();
        SetParams setParams=new SetParams();
        jedis.set("server","aliyun",setParams.nx().px(60000));
        System.out.println(jedis.get("server"));
    }

    @Test
    public void shardsTest(){
        List<JedisShardInfo> shardInfoList=new ArrayList<>();

        shardInfoList.add(new JedisShardInfo("192.168.126.129",6379));
        shardInfoList.add(new JedisShardInfo("192.168.126.129",6380));
        shardInfoList.add(new JedisShardInfo("192.168.126.129",6381));


        ShardedJedis shardedJedis=new ShardedJedis(shardInfoList);
        shardedJedis.set("LOL","LGD");
        System.out.println(shardedJedis.get("LOL"));
    }

    @Test
    public void clusterTest(){
        Set<HostAndPort> node=new HashSet<>();
        node.add(new HostAndPort("192.168.126.129",7000));
        node.add(new HostAndPort("192.168.126.129",7001));
        node.add(new HostAndPort("192.168.126.129",7002));
        node.add(new HostAndPort("192.168.126.129",7003));
        node.add(new HostAndPort("192.168.126.129",7004));
        node.add(new HostAndPort("192.168.126.129",7005));

        JedisCluster jedisCluster=new JedisCluster(node);
        jedisCluster.set("haha","gyf");
        System.out.println(jedisCluster.get("haha"));
    }

}
