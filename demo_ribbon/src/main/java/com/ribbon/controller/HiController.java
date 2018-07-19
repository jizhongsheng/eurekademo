package com.ribbon.controller;

import com.ribbon.service.HiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jizhongsheng on 2018/7/10.
 */
@RestController
public class HiController {
    @Value("${server.port}")
    String port;

    String flag;

    @Autowired
    HiService hiService;
    @RequestMapping(value = "/hi")
    public String hi(@RequestParam String name){
        flag = hiService.hiService(name);
        return flag + " 这次分配得端口是" +  port;
    }
}
