package rabbittest

import org.springframework.amqp.core.Message

class MQTTConsumerService {

   // this guy receives everything on the exchange; messageConverterBean:'' allows accessing the message
   static rabbitSubscribe = [name: 'tadomqttexchange', messageConverterBean: '']

   void handleMessage(Message message) {
      println "--------------------------------------------------------------"
      println "MQTTConsumerService - start handle message"
      println message
      println "MQTTConsumerService - finish handle message"
      println "--------------------------------------------------------------"
   }

}
