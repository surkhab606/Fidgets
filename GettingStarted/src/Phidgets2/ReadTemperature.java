package Phidgets2;

//Add Phidgets Library | You added a file called phidget22 when configuring your project. Import gives you access to the Phidgets library code inside that file. 
import com.phidget22.*;

public class ReadTemperature {
	
  public static void main(String[] args) throws Exception {

      //Create | Here you've created a HumiditySensor and a TemperatureSensor object for your Humidity Phidget. This allows you to access both temperature and humidity data from your Phidget.
      HumiditySensor humiditySensor = new HumiditySensor();
      TemperatureSensor temperatureSensor = new TemperatureSensor();

      //Open | Open establishes a connection between your object and your physical Phidget. You provide a timeout value of 1000 to give the program 1000 milliseconds (1 second) to locate your Phidget. If your Phidget can't be found, an exception occur.
      humiditySensor.open(1000);
      temperatureSensor.open(1000);

      //Use your Phidgets | This code will print humidity and temperature read by the sensor every 150ms.
      while(true) {
          System.out.println("Humidity: " + humiditySensor.getHumidity() +" %RH, Temperature: " + temperatureSensor.getTemperature() + " °C" );
          Thread.sleep(150);
          
          //If humidity below 30, output humidity is low 
          if (humiditySensor.getHumidity() < 30) 
          {
          	System.out.println("Humidity is low.");
          }
          
          //If humidity is above 30, output humidity level 
          else 
          {
          	System.out.println("Humidity: " + humiditySensor.getHumidity() +" %RH ");
          }
          
          //If temperature below 21, output room is too cold
          if(temperatureSensor.getTemperature() < 21) 
          {
          	System.out.println("Room is too cold");
          }
          
          //If humidity above 21, output temperature
          else 
          {
          	System.out.println(temperatureSensor.getTemperature() + "°C" );
          }
          
          
          }
      }
  }
 


