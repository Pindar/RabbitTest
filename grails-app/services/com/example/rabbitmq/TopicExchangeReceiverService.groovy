package com.example.rabbitmq

import com.example.mq.AbstractMQReceiver

class TopicExchangeReceiverService extends AbstractMQReceiver {

   @SuppressWarnings("GroovyUnusedDeclaration")
   static def rabbitSubscribe = 'topic-exchange'

   @SuppressWarnings("GroovyUnusedDeclaration")
   void handleMessage(String message) {
      mqListener.msgReceived(message)
   }
}
