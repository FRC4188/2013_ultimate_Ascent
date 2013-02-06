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
import team4188_2013.RobotMap;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.can.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import team4188_2013.CorpsRobotDrive;
/**
 *
 */
public class Drivetrain extends Subsystem {
    public CorpsRobotDrive Drive;
    private boolean resetG = false;
    private PIDController gyroPID;
    Timer timer = new Timer();
    private boolean timerRunning=false;
    public static final double 
        gyroTOLERANCE = 0.5,
        Pg = 0.006, 
        Ig = 0.0002, 
        Dg = 0.0,     // LEAVE THESE CONSTANTS ALONE!
        PID_LOOP_TIME = .05,
        SETTLED_TIME = 1.0;    // LEAVE THESE CONSTANTS ALONE!;
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    Gyro gyro = RobotMap.drivetrainGyro;
    CANJaguar frontLeft = RobotMap.drivetrainFrontLeft;
    CANJaguar rearLeft = RobotMap.drivetrainRearLeft;
    CANJaguar frontRight = RobotMap.drivetrainFrontRight;
    CANJaguar rearRight = RobotMap.drivetrainRearRight;
    CorpsRobotDrive robotDrive = RobotMap.drivetrainRobotDrive;
    Encoder encoder1 = RobotMap.drivetrainEncoder1;
    Encoder encoder2 = RobotMap.drivetrainEncoder2;
    Encoder encoder3 = RobotMap.drivetrainEncoder3;
    Encoder encoder4 = RobotMap.drivetrainEncoder4;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
   public boolean autoAimPan(double targetAngle) {
        //RobotMap.setDriveTrainMode(RobotMap.GYRO_MODE);
        
        //encPID.disable();
        
        //accelPID.disable();
        if(!resetG) {
            gyro.reset();
            resetG = true;
        }
        if(!gyroPID.isEnable()) gyroPID.enable();
        
        gyroPID.setSetpoint(targetAngle);
        if(thereYet(targetAngle)) {
            disablePID();
            resetG = false;
            return true;
        }
        return false;
    }
   public void disablePID() {
        if(gyroPID.isEnable()) gyroPID.disable();
        //accelPID.disable();
    }
   public boolean thereYet(double target) 
   {
        if(onTarget(target) && !timerRunning) 
        {
            timer.start();
            timerRunning = true;
        }
        else if (!onTarget(target) && timerRunning)
        {
            timer.stop();
            timer.reset();
            timerRunning = false;
        }
        return timer.get() >= SETTLED_TIME;
    }
  
   public double getGyroAngle() 
   {
        return gyro.getAngle();
    }
   public void resetGyro() 
   {
      gyro.reset();
   }
   public void stop()
   {
       Drive.mecanumDrive_Cartesian(0.0,0.0,0.0,0.0);
   }
   private boolean onTarget(double target) 
   {
        boolean toReturn=false;
        //switch(RobotMap.getDriveTrainMode()) {
                if(target<0)
                {
                    if(gyro.getAngle()<=(target+((gyroTOLERANCE/100.0)*180.0)) &&
                            gyro.getAngle()>=(target-((gyroTOLERANCE/100.0)*180.0)))
                    {
                        toReturn=true;
                    }
                    else
                    {
                        toReturn=false;
                    }
                }
                //System.out.println("gyro onTarget...");
                if(gyro.getAngle()>=(target-((gyroTOLERANCE/100.0)*180.0)) &&
                        gyro.getAngle()<=(target+((gyroTOLERANCE/100.0)*180.0)))
                {
                    toReturn = true;
                }
                else
                {
                    toReturn = false;
                }
   return toReturn;
}
   
   
  
    
    public void setMaxVoltages(double voltage) {
        try {
            frontLeft.configMaxOutputVoltage(voltage);
            frontRight.configMaxOutputVoltage(voltage);
            rearLeft.configMaxOutputVoltage(voltage);
            rearRight.configMaxOutputVoltage(voltage);
            
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
    }
}
