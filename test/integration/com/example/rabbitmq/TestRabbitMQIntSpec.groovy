package com.example.rabbitmq

import com.example.mq.MQReceiver
import com.example.mq.MQSender
import grails.plugin.spock.IntegrationSpec
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier

class TestRabbitMQIntSpec extends IntegrationSpec {

   private static final String MESSAGE = "Hello World!"
   @Autowired
   MQSender mqSender

   @Autowired
   @Qualifier("helloExchangeReceiverService")
   MQReceiver helloExchangeReceiver
   @Autowired
   @Qualifier("topicExchangeReceiverService")
   MQReceiver topicExchangeReceiver

   MockMQListener mockListener

   def setup() {
      mockListener = new MockMQListener()
   }

   void "test to send and receive a message via fanout"() {
      given:
        helloExchangeReceiver.registerReceiver(mockListener)

      when:
        "sending MESSAGE"

        mqSender.send "hello-exchange", "hola", MESSAGE

      then:
        "the received MESSAGE should be equal to the send MESSAGE"

        waitForTheMessage(mockListener)
        assert mockListener.getMessage() == MESSAGE
   }

   void "test to send and receive a message via topic"() {
      given:
        topicExchangeReceiver.registerReceiver(mockListener)

      when:
        "sending MESSAGE"

        mqSender.send "topic-exchange", "hola", MESSAGE

      then:
        "the received MESSAGE should be equal to the send MESSAGE"

        waitForTheMessage(mockListener)
        assert mockListener.getMessage() == MESSAGE
   }

   private void waitForTheMessage(final MockMQListener listener) {
      synchronized (listener) {
         mockListener.wait(2000)
      }
   }

}