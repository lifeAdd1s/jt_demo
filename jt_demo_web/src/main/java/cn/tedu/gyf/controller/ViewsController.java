package cn.tedu.gyf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Date 2020/8/17 17:04
 * @Author GuoYunFeng
 * @Email guoyunfeng520@outllok.com
 */
@Controller
@RequestMapping("/")
public class ViewsController {

    @RequestMapping("/{viewName}")
    public String getView(@PathVariable String viewName){
        System.out.println(viewName);
        return "index";
    }
}
