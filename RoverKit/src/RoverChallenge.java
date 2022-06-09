//Add Phidgets Library
import com.phidget22.*;


public class RoverChallenge 
{
	
	public static void main(String[] args ) throws Exception 
	{
        Net.addServer("", "192.168.100.1", 5661, "", 0);
        
        //Create 
        DCMotor leftMotors = new DCMotor();
        DCMotor rightMotors = new DCMotor();
        DistanceSensor sonar = new DistanceSensor();
        
        //Address
        leftMotors.setChannel(0);
        rightMotors.setChannel(1);

        //Open
        leftMotors.open(5000);
        rightMotors.open(5000);
        sonar.open(5000);
        sonar.setDataInterval(100);
        int turnCount = 0;
        

        while (true) 
        {

            System.out.println("Distance: " + sonar.getDistance() + " mm");
            turnCount ++;
            
            if (sonar.getDistance() < 500) 
            
            {
                //Object detected! Stop motors
                leftMotors.setTargetVelocity(0);
                rightMotors.setTargetVelocity(0);
                
                //Sleep for one second 
                Thread.sleep(1000);
             
    	        //Turn in one direction
    	        leftMotors.setTargetVelocity(-1);
    	        rightMotors.setTargetVelocity(1);
    	        
    	        //Sleep for one second 
    	        Thread.sleep(1000);
    	        
    	        //Temporarily stop
    	        leftMotors.setTargetVelocity(0);
    	        rightMotors.setTargetVelocity(0);
    	        
    	        //Sleep for one second 
    	        Thread.sleep(800);
    	        
    	        //Move forward
    	        leftMotors.setTargetVelocity(1);
    	        rightMotors.setTargetVelocity(1);
    	        
    	        //Sleep for one second 
    	        Thread.sleep(1000);
    	        
            } 
            
            else
            	
            {
            	if (turnCount < 10)
            	{
            		leftMotors.setTargetVelocity(0.8);
                	rightMotors.setTargetVelocity(0.8);
            	}
         
            	
            
            
            else 
            {
            	turnCount = 0;
            }
            
            
    	        
            //Wait for 100 milliseconds 
            Thread.sleep(100);
		
		
            }
        }
	}
}


	
