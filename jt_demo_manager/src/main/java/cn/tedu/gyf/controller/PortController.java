package cn.tedu.gyf.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date 2020/8/7 16:27
 * @Author GuoYunFeng
 * @Email guoyunfeng520@outllok.com
 */
@RestController
public class PortController {

    @Value("${server.port}")
    private String port;


    @RequestMapping("/getPort")
    public String getPort(){
        return this.port;
    }
}
