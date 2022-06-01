
import com.phidget22.*;

public class TugofWar 
{
	public static void main(String[] args) throws Exception
	{
		
        //Create | Create objects for your buttons and LEDs.
        DigitalInput redButton = new DigitalInput();
        DigitalOutput redLED = new DigitalOutput();
        DigitalInput greenButton = new DigitalInput();
        DigitalOutput greenLED = new DigitalOutput();

        //Address | Address your four objects which lets your program know where to find them.
        redButton.setHubPort(0);
        redButton.setIsHubPortDevice(true);
        redLED.setHubPort(1);
        redLED.setIsHubPortDevice(true);
        greenButton.setHubPort(5);
        greenButton.setIsHubPortDevice(true);
        greenLED.setHubPort(4);
        greenLED.setIsHubPortDevice(true);

        //Open | Connect your program to your physical devices.
        redButton.open(1000);
        redLED.open(1000);
        greenButton.open(1000);
        greenLED.open(1000);
		
        
        boolean buttonState = false;
        boolean redPlayer = false;
        boolean greenPlayer = false;
        int greenCounter = 0;
        int redCounter = 0;
        
        
        while(greenCounter < 10 && redCounter < 10)
	{
        	
        	if(greenButton.getState() && !buttonState)
        	{
        		greenCounter +=1;
        		greenLED.setState(true);
        		
        	}
        	
        	else if (!greenButton.getState()) 
        	{
        		greenLED.setState(false);
        	}
        	
        	if(redButton.getState() && !buttonState)
        	{
        		redCounter +=1;
        		redLED.setState(true);
  
        	}
        	
        	else if (!redButton.getState()) 
        	{
        		redLED.setState(false);
        	}
        	
        	
        	
            greenPlayer = greenButton.getState();
            redPlayer = redButton.getState();
            Thread.sleep(150);
	} 
        
        //Flash all lights
        
            
        		 redLED.setState(false);
        		 greenLED.setState(false);
        		 Thread.sleep(100);
              	 redLED.setState(true);
               	 greenLED.setState(true);
               	 Thread.sleep(100);
               	 redLED.setState(false);
               	 greenLED.setState(false);
               	 Thread.sleep(100);
            	 
            	 
               	 
        //Display the winner
         
            	 
            
            if (redCounter == 10) 
            {
            	
            	while (redCounter > 5) 
            	{
            		redLED.setState(true);
            		Thread.sleep(500);
            		redLED.setState(false);
            		Thread.sleep(500);
            		redCounter--;
            	}
            }
            
            
            
            
            else if (greenCounter == 10) 
            {
            	while (greenCounter > 5) 
            	{
            		greenLED.setState(true);
            		Thread.sleep(500);
            		greenLED.setState(false);
            		Thread.sleep(500);
            		greenCounter--;
            		
            	}
            } 
          
    		
    	}

}
