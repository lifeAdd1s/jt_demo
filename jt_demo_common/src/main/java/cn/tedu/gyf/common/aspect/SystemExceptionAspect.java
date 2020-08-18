package cn.tedu.gyf.common.aspect;

import cn.tedu.gyf.common.vo.SysResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Date 2020/8/4 14:37
 * @Author GuoYunFeng
 * @Email guoyunfeng520@outllok.com
 */
@RestControllerAdvice
public class SystemExceptionAspect {

    @ExceptionHandler(RuntimeException.class)
    public SysResult systemException(Exception e){
        e.printStackTrace();
        return SysResult.failed();

    }
}
