package com.example.mqtt

import com.example.mq.AbstractMQReceiver
import com.example.mq.MQListener
import org.eclipse.paho.client.mqttv3.MqttCallback
import org.eclipse.paho.client.mqttv3.MqttClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
/**
 * Created by simon on 03.07.13.
 */
class DeviceEventReceiverService extends AbstractMQReceiver {

   private static final String TOPIC_NAME = "device/event"
   @Autowired
   @Qualifier("mqttClient")
   MqttClient mqttClient

   @Override
   void registerReceiver(MQListener mqListener) {

      MqttCallback mqttCallback = new MqttCallbackImpl(mqListener: mqListener)
      mqttClient.setCallback(mqttCallback)
      mqttClient.subscribe(TOPIC_NAME, 0)
   }
}
