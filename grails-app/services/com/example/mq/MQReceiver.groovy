package com.example.mq

/**
 * Created by simon on 03.07.13.
 */
public interface MQReceiver {
   void registerReceiver(MQListener mqListener)
}