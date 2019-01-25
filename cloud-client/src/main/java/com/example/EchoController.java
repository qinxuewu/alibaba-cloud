package com.example;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qinxuewu
 * @version 1.00
 * @time  18/1/2019 上午 10:36
 * @email 870439570@qq.com
 */
@RestController
public class EchoController {

    @RequestMapping(value = "/echo/{string}", method = RequestMethod.GET)
    public String echo(@PathVariable String string) {
        return "第一个Nacos 程序" + string;
    }


}
