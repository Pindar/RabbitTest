package com.example.rabbitmq

import com.example.mq.MQSender
import org.springframework.stereotype.Component

@Component
class RabbitMQSenderService implements MQSender {

   @Override
   void send(String queueName, String routingKey, String message) {
      rabbitSend queueName, routingKey, message
   }

}
