package com.example.mq

/**
 * Created by simon on 02.07.13.
 */
public interface MQSender {
   void send(String queueName, String routingKey, String message)
}