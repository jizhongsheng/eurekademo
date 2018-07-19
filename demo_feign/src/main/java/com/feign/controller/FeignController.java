package com.feign.controller;

import com.feign.service.SchedualServiceHi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*
 * feign组件里面的Controller
 * 1 注入 service
 * 2 暴露接口 /hi
 * 当注入一个接口的时候 Application启动类 需要在上一层包目录下 才可以扫描到该接口。
 */
@RestController
public class FeignController {
    @Autowired
    SchedualServiceHi schedualServiceHi;
    @RequestMapping(value = "/hi" ,method = RequestMethod.GET)
    public String sayHi(@RequestParam String name){
        return  schedualServiceHi.sayHiFromClient(name);
    }
}
