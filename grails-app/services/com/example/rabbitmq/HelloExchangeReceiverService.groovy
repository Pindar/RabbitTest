package com.example.rabbitmq

import com.example.mq.AbstractMQReceiver

class HelloExchangeReceiverService extends AbstractMQReceiver {


   @SuppressWarnings("GroovyUnusedDeclaration")
   static def rabbitSubscribe = 'hello-exchange'

   @SuppressWarnings("GroovyUnusedDeclaration")
   void handleMessage(String message) {
      mqListener.msgReceived(message)
   }
}
