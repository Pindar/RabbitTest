package rabbittest

class MQTTConsumerDeviceEventService {

   // this guy only receives messages with the specified routing key on this exchange
   static rabbitSubscribe = [ name: 'tadomqttexchange', routingKey: 'device.event' ]

   void handleMessage(message) {
      println "--------------------------------------------------------------"
      println "MQTTConsumerDeviceEventService - start handle message"
      println message
      println "MQTTConsumerDeviceEventService - finish handle message"
      println "--------------------------------------------------------------"
   }

}
