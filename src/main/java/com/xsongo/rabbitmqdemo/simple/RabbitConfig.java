package com.xsongo.rabbitmqdemo.simple;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Created By GS 15:10 2018/8/27
 */
@Configuration
public class RabbitConfig {

    @Bean
    public Queue okongQueue(){
        return new Queue("okong");
    }
}
