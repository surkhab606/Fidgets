
//Add Phidgets Library
import com.phidget22.*;
import java.util.Scanner;

public class ScaleCalibration {
    //Define
    static VoltageRatioInput scale;
    
    public static double getAverage()throws Exception{
        double average = 0;
        int count = 0;
        System.out.println("Averaging Value...");
        while(count < 64){
            average += scale.getVoltageRatio();
            count += 1;
            Thread.sleep(20);
        }
        return average/count;
    }
    
    public static void main(String[] args) throws Exception{
        Scanner scan = new Scanner(System.in);
        
        //Create
        scale = new VoltageRatioInput();
        
        //Open
        scale.open(1000);
        
        //Set data interval to minimum
        scale.setDataInterval(scale.getMinDataInterval());
        
        System.out.println("Make sure nothing is on your scale and press Enter");
        scan.nextLine();
        double offset = getAverage();
        
        System.out.println("Place a known weight on the scale, type the weight in kilograms and press Enter");
        double knownWeight = Double.parseDouble(scan.nextLine());
        
        double measuredWeight = getAverage();
        
        double slope = knownWeight / (measuredWeight - offset);
        
        System.out.println("Your new slope value is: " + Math.round(slope));
    }    
}



/* SCREEN DUMP
 * 
Make sure nothing is on your scale and press Enter

Averaging Value...
Place a known weight on the scale, type the weight in kilograms and press Enter
0.194
Averaging Value...
Your new slope value is: 21315

 */
