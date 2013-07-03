package com.example.mqtt

import com.example.mq.MQListener
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken
import org.eclipse.paho.client.mqttv3.MqttCallback
import org.eclipse.paho.client.mqttv3.MqttMessage

/**
 * Created by simon on 03.07.13.
 */
class MqttCallbackImpl implements MqttCallback {

   MQListener mqListener;


   @Override
   void connectionLost(Throwable throwable) {

   }

   @Override
   void messageArrived(String mqttTopic, MqttMessage mqttMessage) throws Exception {
      mqListener.msgReceived(new String(mqttMessage.getPayload()))
   }

   @Override
   void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {

   }
}
