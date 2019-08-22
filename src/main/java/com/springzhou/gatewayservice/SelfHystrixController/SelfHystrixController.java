package com.springzhou.gatewayservice.SelfHystrixController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhou
 * @create 2019-08-21 14:31
 * @description:
 */
@RestController
public class SelfHystrixController {

    @RequestMapping("/defaultfallback")
    public Map<String,String> defaultfallback(){
        System.out.println("请求被熔断.");
        Map<String,String> map = new HashMap<>();
        map.put("Code","fail");
        map.put("Message","服务异常");
        map.put("result","");
        return map;
    }

}