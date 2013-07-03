package com.example.rabbitmq

import com.example.mq.MQListener
import com.example.mq.MQService

class RabbitMQService implements MQService {


   static rabbitSubscribe = 'hello-exchange'

   private MQListener mqListener

   @Override
   void send(String queueName, String routingKey, String message) {
      rabbitSend queueName, routingKey, message
   }

   @Override
   void registerReceiver(MQListener mqListener) {

      this.mqListener = mqListener
   }

   void handleMessage(String message) {
      println 'callback ' + message
      mqListener.msgReceived(message)
   }
}
