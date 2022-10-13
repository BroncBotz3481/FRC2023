/****************************** Header ******************************\
 Class Name: ExampleCommand extends CommandBase
 File Name: ExampleCommand.java
 Summary: An example command to use for learning and testing.
 Project: BroncBotzFRC2023
 Copyright (c) BroncBotz.
 All rights reserved.

 Author(s): Dylan Watson
 Email: dylantrwatson@gmail.com
 \********************************************************************/


package frc.robot.commands.autoCommands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.drivetrain.DrivetrainPolicy;
import frc.robot.subsystems.drivetrain.DrivetrainSubsystem;

import java.util.function.DoubleSupplier;


/**
 * An example command that uses an example subsystem.
 */
public class ReverseDriveCommand extends CommandBase {
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    private final DrivetrainSubsystem m_drivetrainSubsystem;
    private Timer time;

    /**
     * Creates a new ExampleCommand.
     *
     * @param subsystem The subsystem used by this command.
     */
    public ReverseDriveCommand(DrivetrainSubsystem subsystem) {
        m_drivetrainSubsystem = subsystem;
        time = new Timer();
        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(subsystem);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        time.start();
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        m_drivetrainSubsystem.run(1,1);
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        time.stop();
        m_drivetrainSubsystem.run(0,0);

    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        if(time.get()>=2.0){
            return true;
        }
        return false;
    }
}
