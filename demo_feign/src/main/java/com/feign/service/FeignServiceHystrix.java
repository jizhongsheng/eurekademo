package com.feign.service;

import org.springframework.stereotype.Component;

/**
 * Created by jizhongsheng on 2018/7/11.
 */
@Component
public class FeignServiceHystrix implements SchedualServiceHi{
    @Override
    public String sayHiFromClient(String name) {
        return name + "is Error !";
    }
}
