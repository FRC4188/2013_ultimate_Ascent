// RobotBuilder Version: 0.0.2
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in th future.
package team4188_2013.commands;
import edu.wpi.first.wpilibj.command.Command;
import team4188_2013.Robot;
/**
 *@author Tobore Tasker
 */
public class  TurnXDegrees extends Command {
    private double angle;
    private boolean isAimed;    
    public TurnXDegrees(double Angle) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
	 this.angle=angle;
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.drivetrain);
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }
    // Called just before this Command runs the first time
    // Called just before this Command runs the first time
    protected void initialize() {
    isAimed=false;
    Robot.drivetrain.resetGyro();
    System.out.println("im in the init");
    }
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    if(this.angle<0)
    {
        isAimed=Robot.drivetrain.autoAimPan(this.angle);
    }
    else
    {
        isAimed=Robot.drivetrain.autoAimPan(this.angle);        
    }
    
    }
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isAimed;
    }
    // Called once after isFinished returns true
    protected void end() {
        Robot.drivetrain.disablePID();
        isAimed=false;
        System.out.println("im done");
    }
    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
