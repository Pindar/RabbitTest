package com.example.mq

/**
 * Created by simon on 03.07.13.
 */
abstract class AbstractMQReceiver implements MQReceiver {
   MQListener mqListener

   @Override
   void registerReceiver(MQListener mqListener) {
      this.mqListener = mqListener
   }
}
