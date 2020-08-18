package cn.tedu.gyf.common.anno;

import java.lang.annotation.*;

/**
 * @Date 2020/8/14 11:42
 * @Author GuoYunFeng
 * @Email guoyunfeng520@outllok.com
 */
@Target(ElementType.METHOD)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface CacheFind {

    //redis缓存中的key
    String key();


    //获取缓存的超时时间
    int timeOutSecond() default 0;


}
