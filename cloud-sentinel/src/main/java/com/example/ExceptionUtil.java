package com.example;

import com.alibaba.csp.sentinel.slots.block.BlockException;

import java.util.HashMap;
import java.util.Map;

public class ExceptionUtil {

    public static Map<String,Object> handleException(BlockException ex) {
        Map<String,Object> map=new HashMap<>();
        System.out.println("Oops: " + ex.getClass().getCanonicalName());
        map.put("Oops",ex.getClass().getCanonicalName());
        map.put("msg","通过@SentinelResource注解配置限流埋点并自定义处理限流后的逻辑");
        return  map;
    }

    public static Map<String,Object> handleException2(BlockException ex) {
        Map<String,Object> map=new HashMap<>();
        map.put("Oops",ex.getClass().getCanonicalName());
        map.put("msg","通过读取json文件读取限流规则");
        return  map;
    }
}
