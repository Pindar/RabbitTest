package com.example.rabbitmq

import com.example.mq.MQListener
import com.example.mq.MQReceiver

class HelloExchangeReceiverService implements MQReceiver {

   MQListener mqListener;
   @SuppressWarnings("GroovyUnusedDeclaration")
   static def rabbitSubscribe = 'hello-exchange'


   @Override
   void registerReceiver(MQListener mqListener) {
      this.mqListener = mqListener
   }

   @SuppressWarnings("GroovyUnusedDeclaration")
   void handleMessage(String message) {
      mqListener.msgReceived(message)
   }
}
