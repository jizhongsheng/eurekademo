package com.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/*
 *该service是feign的接口，通过 @FeignClient注解来提供要在注册中心访问的服务名，通过服务名在各个端口间相互调用。
 */
@FeignClient(value = "service-hi",fallback = FeignServiceHystrix.class)
public interface SchedualServiceHi {
    /*
    定义访问的路径RequestMapping 请求方法为Get 请求的参数@RequestParam name 作为参数String name 传入方法sayHiFromClient
     */

    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    String sayHiFromClient(@RequestParam(value = "name")String name);
}
