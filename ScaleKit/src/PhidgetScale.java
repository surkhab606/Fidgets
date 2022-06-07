//Add Phidgets Library
import com.phidget22.*;

public class PhidgetScale 
{
    public static void main(String[] args) throws Exception 
    {	
        //Create
        VoltageRatioInput scale = new VoltageRatioInput();
        double totalOffset = 0; 
        double offSet = 0;
        
        //Open
        scale.open(1000);
        
        
        for (int i = 0; i < 64; i++) 
        {
        	//Averages offset value from 64 samples 
        	totalOffset += scale.getVoltageRatio();
        	offSet = totalOffset/64;
        	
        	//Prints calculating offset to user 
        	System.out.println("Calculating offset...");
        	
        }
        
        
        //Use your Offset Value
        double offsetValue = offSet;
        
        //Use your Phidgets
        while(true) 
        {

            //Calculate Weight (kg)
            double weight = 23556 * (scale.getVoltageRatio() - offsetValue);
            //Display Weight
            System.out.println(String.format("%.3f kg", weight));      
            
            Thread.sleep(250);
        }
    }    
}
  
