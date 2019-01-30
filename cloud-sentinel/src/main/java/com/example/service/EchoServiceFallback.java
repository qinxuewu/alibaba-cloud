package com.example.service;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;


/**
 * 熔断处理
 * @author qinxuewu
 * @version 1.00
 * @time  30/1/2019 上午 11:00
 * @email 870439570@qq.com
 */
@Component
public class EchoServiceFallback implements EchoService {

    @Override
    public String echo(@PathVariable("str") String str) {
        return "echo fallback熔断处理";
    }
}
