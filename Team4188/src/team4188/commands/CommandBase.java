package team4188.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import team4188.OI;
import team4188.subsystems.*;

/**
 * The base for all commands. All atomic commands should subclass CommandBase.
 * CommandBase stores creates and stores each control system. To access a
 * subsystem elsewhere in your code in your code use CommandBase.exampleSubsystem
 * @author Author
 */
public abstract class CommandBase extends Command {

    public static OI oi;
    public static Vision vision;
    public static Pan pan;
    // Create a single static instance of all of your subsystems
   

    public static void init() {
        // This MUST be here. If the OI creates Commands (which it very likely
        // will), constructing it during the construction of CommandBase (from
        // which commands extend), subsystems are not guaranteed to be
        // yet. Thus, their requires() statements may grab null pointers. Bad
        // news. Don't move it.
        oi = new OI();
        vision = new Vision();
        vision.init();
        pan = new Pan();
        
        
        // Show what command your subsystem is running on the SmartDashboard
       
    }
    private static void showSubsystem() {
        // Show what command your subsystem is running on the SmartDashboard

        SmartDashboard.putData(vision);

    }
    
    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
}
