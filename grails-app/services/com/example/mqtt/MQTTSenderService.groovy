package com.example.mqtt

import com.example.mq.MQSender
import org.eclipse.paho.client.mqttv3.MqttClient
import org.eclipse.paho.client.mqttv3.MqttMessage
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
/**
 * Created by simon on 03.07.13.
 */
class MQTTSenderService implements MQSender {

   @Autowired
   @Qualifier("mqttClient")
   MqttClient mqttClient

   @Override
   void send(String queueName, String routingKey, String message) {
      MqttMessage mqttMessage = createMqttMessage(message)

      mqttClient.getTopic(queueName).publish(mqttMessage)

   }

   private static MqttMessage createMqttMessage(String message) {
      MqttMessage mqttMessage = new MqttMessage(message.getBytes())
      mqttMessage.setQos(0)
      return mqttMessage
   }
}
