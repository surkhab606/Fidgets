//Add Phidgets Library | You added a file called phidget22 when configuring your project. Import gives you access to the Phidgets library code inside that file. 
import com.phidget22.*;


public class TugofWar 
{
    //Handle Exceptions | Exceptions will happen in your code from time to time. These are caused by unexpected things happening. Make sure you’ve added "throws Exception" to your main method.
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
		
        
        //Variables for players, point counters and button state 
        boolean buttonState = false;
        boolean redButtonPlayer = false;
        boolean greenButtonPlayer = false;
        int greenCounter = 0;
        int redCounter = 0;
        
        //While the buttons have been pressed less than 10 times, run this loop
        while(greenCounter < 10 && redCounter < 10)
        {
        	
        	//If the green button is pressed...
        	if(greenButton.getState() && !buttonState)
        	{
        		//...Add one point to green player
        		greenCounter +=1;
        		greenLED.setState(true);
        		
        	}
        	
        	//...If the button is not pressed then do not add any points and set LED off 
        	else if (!greenButton.getState()) 
        	{
        		greenLED.setState(false);
        	}
        	
        	//If the red button is pressed...
        	if(redButton.getState() && !buttonState)
        	{
        		//...Add one point to red player 
        		redCounter +=1;
        		redLED.setState(true);
  
        	}
        	
        	//...If the button is not pressed then do not add any points and turn LED off 
        	else if (!redButton.getState()) 
        	{
        		redLED.setState(false);
        	}
        	
        	
        	
            greenButtonPlayer = greenButton.getState();
            redButtonPlayer = redButton.getState();
            Thread.sleep(150);
	} 
        
        		 //Flashes both LED lights once 
        		 redLED.setState(false);
        		 greenLED.setState(false);
        		 Thread.sleep(100);
              	 redLED.setState(true);
               	 greenLED.setState(true);
               	 Thread.sleep(100);
               	 redLED.setState(false);
               	 greenLED.setState(false);
               	 Thread.sleep(100);
            	 
            	 
               	 
            //Flash the winner's LED 5 times
             
            //If red wins
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
            
            //If green wins
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
