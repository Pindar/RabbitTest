package rabbittest

class MessageSenderController {


   def testAMPQ_send2appexchange() {
       println "testAMPQ_send2appexchange - beforeSend"
       // rabbitSend    exchange, routingKey, msg
       rabbitSend('tadoappexchange', '', 'Hello AMQP-World!!!! (testAMPQ_send2appexchange)')
       println "testAMPQ_send2appexchange - afterSend"
       render "testAMPQ_send2appexchange"
   }



   def testAMPQ_send2appexchange_geoevent_newfix_routing() {
      println "testAMPQ_send2appexchange_geoevent_newfix_routing - beforeSend"
      // rabbitSend    exchange, routingKey, msg
      rabbitSend('tadoappexchange', 'geoevent.newfix', 'Hello AMQP-World!!!! (testAMPQ_send2appexchange_geoevent_newfix_routing)')
      println "testAMPQ_send2appexchange_geoevent_newfix_routing - afterSend"
      render "testAMPQ_send2appexchange_geoevent_newfix_routing"
   }



   def testMQTT_send2mqttexchange() {
      println "testMQTT_send2mqttexchange start!"

      rabbitSend('tadomqttexchange', '', 'Hello to the MQTT-World!!!! (testMQTT_send2mqttexchange)')

      println "testMQTT_send2mqttexchange finish!"
      render "testMQTT_send2mqttexchange"
   }


   def testMQTT_send2mqttexchange_device_command_routing() {
      println "testMQTT_send2mqttexchange_device_command_routing start!"

      rabbitSend('tadomqttexchange', 'device.command', 'Hello to the MQTT-World!!!! (testMQTT_send2mqttexchange_device_command_routing)')

      println "testMQTT_send2mqttexchange_device_command_routing finish!"
      render "testMQTT_send2mqttexchange_device_command_routing"
   }


}
