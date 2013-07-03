package com.example.rabbitmq

import com.example.mq.MQListener

/**
 * Created by simon on 02.07.13.
 */
class MockMQListener implements MQListener {

   String message;

   @Override
   void msgReceived(String msg) {
      this.message = msg

      synchronized (this) {
         notifyAll()
      }
   }

   String getMessage() {
      return message
   }
}
