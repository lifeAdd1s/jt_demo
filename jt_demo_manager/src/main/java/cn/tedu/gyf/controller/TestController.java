package cn.tedu.gyf.controller;

import cn.tedu.gyf.common.pojo.User;
import cn.tedu.gyf.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;


/**
 * @Date 2020/7/30 16:41
 * @Author GuoYunFeng
 * @Email guoyunfeng520@outllok.com
 */
@Controller
public class TestController {

    @Resource
    private UserService userService;

    @RequestMapping("/json")
    @ResponseBody
    public List<User> result(){
        return userService.findAll();
    }

    @RequestMapping("/page/{moduleName}")
    public String model(@PathVariable String moduleName){
        return moduleName;
    }
}
