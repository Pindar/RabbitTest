// Place your Spring DSL code here
import org.eclipse.paho.client.mqttv3.MqttClient
//noinspection GroovyUnusedAssignment
beans = {
   mqttClient(MqttClient, "tcp://localhost:1883", "SampleClient") { bean ->
      bean.initMethod = 'connect'
      bean.destroyMethod = 'disconnect'
   }
}
