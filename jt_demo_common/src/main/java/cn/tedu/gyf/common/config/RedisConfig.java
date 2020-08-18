package cn.tedu.gyf.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import redis.clients.jedis.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Date 2020/8/12 16:12
 * @Author GuoYunFeng
 * @Email guoyunfeng520@outllok.com
 */
@Configuration
@PropertySource("classpath:properties/redis.properties")
public class RedisConfig {

    @Value("${redis.host}")
    private String host;

    @Value("${redis.port}")
    private Integer port;

    @Value("${redis.nodes}")
    private String nodeList;

    @Value("${redis.cluster.host}")
    private String clusterInfo;

    @Bean
    public Jedis getConnection(){
        return new Jedis(this.host,this.port);
    }

    @Bean
    public ShardedJedis getShardJedis(){

        List<JedisShardInfo> jedisShardInfoList=new ArrayList<>();
        String[] nodes=nodeList.split(",");
        if(nodes.length==0)
            throw new RuntimeException("无配置信息");
        for (String node : nodes) {
            String[] nodeInfo=node.split(":");
            if(nodeInfo.length!=2)
                throw new RuntimeException("Redis分片信息配置错误！");
            String host=nodeInfo[0];
            Integer port=Integer.parseInt(nodeInfo[1]);
            jedisShardInfoList.add(new JedisShardInfo(host,port));
        }
        return   new ShardedJedis(jedisShardInfoList);
    }

    @Bean
    public JedisCluster getJedisCluster(){

        String[] clusterNode=clusterInfo.split(",");
        Set<HostAndPort> node = new HashSet<>();

        for (String s : clusterNode) {
            String host=s.split(":")[0];
            Integer port=Integer.parseInt(s.split(":")[1]);
            node.add(new HostAndPort(host,port));
        }
        JedisCluster jedisCluster=new JedisCluster(node);
        System.out.println(jedisCluster);
        return jedisCluster;

    }

}
