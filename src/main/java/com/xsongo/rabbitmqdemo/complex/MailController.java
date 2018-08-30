package com.xsongo.rabbitmqdemo.complex;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created By GS 14:09 2018/8/27
 */
@RestController
@RequestMapping(value = "/mail")
public class MailController {

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public MailController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    /**
     * this.rabbitTemplate.convertAndSend(RabbitConfig.DEFAULT_MAIL_QUEUE, mailEntity);
     * 对应 {@link MailHandler#listenerAutoAck};
     * this.rabbitTemplate.convertAndSend(RabbitConfig.MANUAL_MAIL_QUEUE, mailEntity);
     * 对应 {@link MailHandler#listenerManualAck};
     */
    @GetMapping("/default")
    public String defaultMailMsg() {
        MailEntity mailEntity = new MailEntity();
        mailEntity.setId("1");
        mailEntity.setName("First Mail Message");
        mailEntity.setTitle("RabbitMQ with Spring boot!");
        mailEntity.setContent("Come on! Let's study Micro-Service together!");
        this.rabbitTemplate.convertAndSend(RabbitMQConfig.DEFAULT_MAIL_QUEUE, mailEntity);
        return RabbitMQConfig.DEFAULT_MAIL_QUEUE+"---\n"+mailEntity.toString();
    }
    @GetMapping("/manual")
    public String manualMailMsg() {
        MailEntity mailEntity = new MailEntity();
        mailEntity.setId("2");
        mailEntity.setName("First Mail Message2");
        mailEntity.setTitle("RabbitMQ with Spring boot2!");
        mailEntity.setContent("Come on! Let's study Micro-Service together2!");
        this.rabbitTemplate.convertAndSend(RabbitMQConfig.MANUAL_MAIL_QUEUE, mailEntity);
        return RabbitMQConfig.MANUAL_MAIL_QUEUE+"---\n"+mailEntity.toString();
    }
}
