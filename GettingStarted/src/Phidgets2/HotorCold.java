package Phidgets2;

//Add Phidgets Library | You added a file called phidget22 when configuring your project. Import gives you access to the Phidgets library code inside that file. 
import com.phidget22.*;

public class HotorCold {
  public static void main(String[] args) throws Exception{

      //Create | Here you have created a TemperatureSensor object. TemperatureSensor is a class in your Phidgets library that gathers temperature data from your Phidget. 
      TemperatureSensor temperatureSensor = new TemperatureSensor();

      //Open | Open establishes a connection between your object and your physical Phidget. You provide a timeout value of 1000  to give the program 1000 milliseconds (1 second) to locate your Phidget. If your Phidget can't be found, an exception will be thrown.
      temperatureSensor.open(1000);
      
      DigitalOutput redLED = new DigitalOutput();
	  DigitalOutput greenLED = new DigitalOutput();
	  
	  redLED.setHubPort(1);
	  redLED.setIsHubPortDevice(true);
	  greenLED.setHubPort(4);
	  greenLED.setIsHubPortDevice(true);
	      
	  redLED.open(1000);
	  greenLED.open(1000);

		 //If temperature is between 20 and 24 degrees, turn on green LED
		 if(temperatureSensor.getTemperature() > 20 && temperatureSensor.getTemperature() < 24) 
		 {
			 
			 greenLED.setState(true);
			 System.out.println("Temperature is " + temperatureSensor.getTemperature() + "°C" );
			 System.out.println("Green LED is on.");
		 }
		 
		 
		 //If temperature is above 24 degrees, turn on red LED
		 else 
		 {
			 redLED.setState(true);
			 System.out.println("Temperature is " + temperatureSensor.getTemperature() + "°C" );
			 System.out.println("Red LED is on.");
		 }
	
	
		
		
      }
  }

