package com.xsongo.rabbitmqdemo.simple;

/**
 * Created By GS 15:11 2018/8/27
 */

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
//@RabbitListener 监听 okong 队列
@RabbitListener(queues ="okong")
public class Consumer {


    @RabbitHandler
    public void process(String message){
        System.out.println("接收消息为："+message);
    }
}

