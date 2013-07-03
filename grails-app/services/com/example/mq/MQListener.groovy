package com.example.mq

/**
 * Created by simon on 02.07.13.
 */
public interface MQListener extends EventListener {
   void msgReceived(String msg)

   String getMessage()
}