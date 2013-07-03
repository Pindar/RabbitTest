package com.example.rabbitmq

import com.example.mq.MQService
import grails.plugin.spock.IntegrationSpec
import org.springframework.beans.factory.annotation.Autowired

class TestRabbitMQIntSpec extends IntegrationSpec {

   @Autowired
   MQService mqService

   def setup() {
   }

   def cleanup() {
   }

   void "test to send and receive a message"() {
      given:
        String message = "Hello World!"
        MockMQListener mockListener = new MockMQListener()
        mqService.registerReceiver(mockListener)

      when:
        "sending message"

        mqService.send "hello-exchange", "hola", message



      then:
        "the received message should be equal to the send message"

        synchronized (mockListener) {
           mockListener.wait(2000)
        }
        assert mockListener.getMessage() == message
   }

}