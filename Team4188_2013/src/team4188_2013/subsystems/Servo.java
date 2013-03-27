// RobotBuilder Version: 0.0.2
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in th future.
package team4188_2013.subsystems;
import edu.wpi.first.wpilibj.PIDController;
import team4188_2013.RobotMap;
import team4188_2013.commands.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import team4188_2013.CorpsServo;
/**
 *@author Tobore Tasker
 */
public class Servo extends Subsystem {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
        // Put methods for controlling this subsystem
    // here. Call these from Commands.
    private PIDController servoX;
    public CorpsServo panY , panX ;
    double position = 90.0;
    boolean down = false;
    final static double 
            panXMin = 0,
            panXMax = 58,
            panYMin =.5,
            panYMax = 1,
            TOLERANCE = 5.0,
            //BoardDistance = 60.0, //60.0 inches 
            X_RANGE = 116;
 
    
    public void init(){
        System.out.println("Initializing Servos");
        
       // panX = new CorpsServo(panXMin, panXMax, RobotMap.panX);
        panY = new CorpsServo(panYMin, panYMax, RobotMap.panY);    
        //panX.goToAngle(position);
        //servoX = new PIDController(2.0, .005, 0.0, position, panX, .05);
        panY.set(panYMin);
    }
    public void manualControl(double input, int x){
        //if(x == 1)panX.goToPosition(input);
        if(x==2)panY.moveToPosition(input);
      
        //setPosition(panX.getAngle());
       // System.out.println(panX.getAngle());
    }
    public void setPosition(double angle){
        position = angle;
        //panX.setAngle(angle);
    }
    public double getPosition(){
        return position;
    }
    public void yDown(){
        panY.set(panYMax);
        down = true;
    }
    public void yUp(){
        panY.set(panYMin);
        down = false;
    }
    public boolean isDown(){
        return down;
    }
    
}
