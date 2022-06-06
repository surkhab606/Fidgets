package PhidgetsAdvanced; 


//Add Phidgets Library 
import com.phidget22.*;

public class LEDBrightness 

{
    //Handle Exceptions 
    public static void main(String[] args) throws Exception{

        //Create 
        DigitalOutput redLED = new DigitalOutput();

        //Address 
        redLED.setHubPort(1);
        redLED.setIsHubPortDevice(true);

        //Open 
        redLED.open(1000);

        //Use your Phidgets with Duty Cycle | Duty Cycle controls the power to your Phidget (Digital Output object). Duty Cycle values range from 0.0 - 1.0.
        //The longer the duty cycle, the longer the LED stays on for 
        //Modified code so LED slowly turns bright and then dims 
       
        redLED.setDutyCycle(0.1);
        Thread.sleep(1000);
        redLED.setDutyCycle(0.5);   
        Thread.sleep(1000);
        redLED.setDutyCycle(1.0);
        Thread.sleep(1000);
        redLED.setDutyCycle(0.5);
        Thread.sleep(1000);
        redLED.setDutyCycle(0.1);
        Thread.sleep(1000);
        redLED.setDutyCycle(0.0);
    }
}
  