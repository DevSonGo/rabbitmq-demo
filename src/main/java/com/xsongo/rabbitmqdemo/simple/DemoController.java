package com.xsongo.rabbitmqdemo.simple;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created By GS 15:13 2018/8/27
 */
@RestController
public class DemoController {

    @Autowired
    AmqpTemplate rabbitmqTemplate;

    @GetMapping("/send")
    public String send(String msg){
        rabbitmqTemplate.convertAndSend("okong",msg);
        return "消息"+msg+",已发送！";
    }
}
