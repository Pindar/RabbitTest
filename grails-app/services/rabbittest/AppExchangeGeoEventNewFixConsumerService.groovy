package rabbittest

class AppExchangeGeoEventNewFixConsumerService {

   // this guy only receives messages with the specified routing key on this exchange
   static rabbitSubscribe = [ name: 'tadoappexchange', routingKey: 'geoevent.newfix' ]

   void handleMessage(message) {
      println "--------------------------------------------------------------"
      println "AppExchangeGeoEventNewFixConsumerService handle message start"
      println message
      println "AppExchangeGeoEventNewFixConsumerService handle message finish"
      println "--------------------------------------------------------------"
   }





}
