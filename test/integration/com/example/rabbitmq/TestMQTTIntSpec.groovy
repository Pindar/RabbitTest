package com.example.rabbitmq

import com.example.mq.MQListener
import com.example.mq.MQReceiver
import com.example.mq.MQSender
import grails.plugin.spock.IntegrationSpec
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier

import static com.example.TestUtilities.waitForTheMessage
/**
 * Created by simon on 03.07.13.
 */
class TestMQTTIntSpec extends IntegrationSpec {
   private static final String MESSAGE = "Hello World!"
   @Autowired
   @Qualifier("MQTTSenderService")
   MQSender mqSender

   @Autowired
   @Qualifier("deviceEventReceiverService")
   MQReceiver deviceEventReceiver


   MQListener mockMqttListener

   def setup() {
      mockMqttListener = new MockMQListener()
   }

   void "test to send and receive a message via mqtt connection"() {
      given:
        deviceEventReceiver.registerReceiver(mockMqttListener)

      when:
        "sending MESSAGE"

        mqSender.send "device/event", "", MESSAGE

      then:
        "the received MESSAGE should be equal to the send MESSAGE"

        waitForTheMessage(mockMqttListener)
        assert mockMqttListener.getMessage() == MESSAGE
   }
}
