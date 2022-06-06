package PhidgetsAdvanced;

//Add Phidgets Library
import com.phidget22.*;

public class ClosingPhidget
{
	
  public static void main(String[] args) throws Exception{

      //Create
      TemperatureSensor temperatureSensor = new TemperatureSensor();

      //Open
      temperatureSensor.open(1000);

      //Use your Phidgets
      System.out.println("Temperature: " + temperatureSensor.getTemperature() + " °C" );
      
      //Close your Phidgets
      temperatureSensor.close();
      
      //Upon calling the open method after the close method, the below code does print. 	
      temperatureSensor.open(1000);
      
      //Upon printing the temperature after the close call, I get an error that the device is not attached. 
      System.out.println("Temperature: " + temperatureSensor.getTemperature() + " °C");
  }
}
