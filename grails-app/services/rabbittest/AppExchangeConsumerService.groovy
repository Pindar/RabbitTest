package rabbittest

class AppExchangeConsumerService {

   // this guy receives everything on the exchange
   static rabbitSubscribe = 'tadoappexchange'

   void handleMessage(message) {
      println "--------------------------------------------------------------"
      println "AppExchangeConsumerService handle message start"
      println message
      println "AppExchangeConsumerService handle message finish"
      println "--------------------------------------------------------------"
   }





}
