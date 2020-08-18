package cn.tedu.gyf.common.aspect;

import cn.tedu.gyf.common.anno.CacheFind;
import cn.tedu.gyf.common.util.ObjectMapperUtil;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.ShardedJedis;

import java.util.Arrays;

/**
 * @Date 2020/8/14 11:07
 * @Author GuoYunFeng
 * @Email guoyunfeng520@outllok.com
 */
@Component
@Aspect
public class CacheAOP {

    @Autowired
    private Jedis jedis;

    @Autowired
    private ShardedJedis shardedJedis;

    @Autowired
    private JedisCluster jedisCluster;

//
//    @Pointcut("bean(itemCatServiceImpl)")
//    public void pointCut(){
//
//    }


//    @Before(value = "pointCut()")
//    public void beforePoint(JoinPoint joinPoint){
//        System.out.println("我是前置通知");
//        String methodName = joinPoint.getSignature().getName();
//        String className=joinPoint.getSignature().getDeclaringType().getSimpleName();
//        System.out.println("className"+className);
//        System.out.println("method:"+methodName);
//        Object tar = joinPoint.getTarget();
//        System.out.println("target"+tar);
//        Object[] args= joinPoint.getArgs();
//        System.out.println("args"+args);
//    }

    @Around("@annotation(cacheFind)")
    public Object around(ProceedingJoinPoint joinPoint, CacheFind cacheFind){

        System.out.println("环绕通知开始");
        try{
            Object result = null;
            String preKey=cacheFind.key();
            String args= Arrays.toString(joinPoint.getArgs());
            String key=preKey+"::"+args;
            if(jedisCluster.exists(key)){
                System.out.println("执行缓存操作");

                String resultValue=jedisCluster.get(key);

                Class resultType= ((MethodSignature) joinPoint.getSignature()).getReturnType();

                result=ObjectMapperUtil.fromJSON(resultValue,resultType);
            }
            else{
                System.out.println("执行数据库操作");

                result=joinPoint.proceed();

                String value=ObjectMapperUtil.toJSON(result);
                if(cacheFind.timeOutSecond()==0)
                    jedisCluster.set(key, value);
                else
                    jedisCluster.setex(key,cacheFind.timeOutSecond(),value);

            }

            System.out.println("环绕通知结束");
            System.out.println("8<------------->8");
            return result;

        } catch (Throwable throwable) {
            throwable.printStackTrace();
            throw new RuntimeException(throwable);
        }

    }
}
