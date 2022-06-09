
//Add Phidgets Library
import com.phidget22.*;

public class RoverJoystick
{
    public static void main(String[] args) throws Exception 
    {

        //Connect to wireless rover
        Net.addServer("", "192.168.100.1", 5661, "", 0);

        //Create
        DCMotor leftMotors = new DCMotor();
        DCMotor rightMotors = new DCMotor();
        VoltageRatioInput hAxis = new VoltageRatioInput(); 

        //Address
        leftMotors.setChannel(0);
        rightMotors.setChannel(1);
        hAxis.setChannel(1);

        //Open
        leftMotors.open(5000);
        rightMotors.open(5000);
        hAxis.open(5000);

        //Increase acceleration
        leftMotors.setAcceleration(leftMotors.getMaxAcceleration());
        rightMotors.setAcceleration(rightMotors.getMaxAcceleration());

        //Use your Phidgets
        while(true)
        		
        {
            //Get data from vertical axis (value between -1 and 1)
            double horizontalAxis = hAxis.getVoltageRatio();
            
            //Use Thumbstick position set motor controller target velocity
            leftMotors.setTargetVelocity(horizontalAxis);
            rightMotors.setTargetVelocity(horizontalAxis);
            
            System.out.println(horizontalAxis);
            
           //Wait 100 milliseconds
            Thread.sleep(100);
        }
    }
}
