package com.example

import com.example.mq.MQListener
/**
 * Created by simon on 03.07.13.
 */
class TestUtilities {
   static void waitForTheMessage(final MQListener listener) {
      synchronized (listener) {
         listener.wait(2000)
      }
   }
}
