package com.example.config;
import com.example.service.EchoServiceFallback;
import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;


/**
 *  Feign配置
 * @author qinxuewu
 * @version 1.00
 * @time  30/1/2019 上午 10:56
 * @email 870439570@qq.com
 */

@Configuration
public class FeignConfiguration {

    public static final org.slf4j.Logger log = LoggerFactory.getLogger(FeignConfiguration.class);
    /**
     * feign日志输出
     * @return
     */
    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }

    @Bean
    public EchoServiceFallback echoServiceFallback() {
        return new EchoServiceFallback();
    }
}
