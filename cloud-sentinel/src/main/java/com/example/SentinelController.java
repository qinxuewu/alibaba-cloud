package com.example;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
public class SentinelController {


    @Value("${spring.application.name}")
    private String appName;

    /***
     * @SentinelResource 注解来完成限流的埋点
     * @return
     */
    @SentinelResource("resource")
    @RequestMapping("/sentinel/hello")
    public Map<String,Object> hello(){
        Map<String,Object> map=new HashMap<>(2);
        map.put("appName",appName);
        map.put("method","hello");
        return map;
    }
    /**
     * 通过控制台配置URL 限流
     * @return
     */
    @RequestMapping("/sentinel/test")
    public Map<String,Object> test(){
        Map<String,Object> map=new HashMap<>(2);
        map.put("appName",appName);
        map.put("method","test");
        return map;
    }


    /**
     * 通过注解限流并自定义限流逻辑
     * value: 资源名称，必需项（不能为空）
     * entryType: 入口类型，可选项（默认为 EntryType.OUT）
     * blockHandler:blockHandlerClass中对应的异常处理方法名。参数类型和返回值必须和原方法一致
     * blockHandlerClass：自定义限流逻辑处理类
     */
    @SentinelResource(value = "resource2", blockHandler = "handleException", blockHandlerClass = {ExceptionUtil.class})
    @RequestMapping("/sentinel/test2")
    public Map<String,Object> test2() {
        Map<String,Object> map=new HashMap<>();
        map.put("method","test2");
        map.put("msg","自定义限流逻辑处理");
        return  map;
    }



    //读取json文件完成限流
    @SentinelResource(value = "resource2", blockHandler = "handleException2", blockHandlerClass = {ExceptionUtil.class})
    @RequestMapping("/sentinel/test3")
    public Map<String,Object> test3() {
        Map<String,Object> map=new HashMap<>();
        map.put("method","test3");
        map.put("msg","通过读取json文件读取限流规则");
        return  map;
    }


}
