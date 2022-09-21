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


package frc.robot.daydream.commands.drivetrainCommand;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.daydream.subsystems.drivetrain.DrivetrainPolicy;
import frc.robot.daydream.subsystems.drivetrain.DrivetrainSubsystem;

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
        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(subsystem);
        System.out.println("Are there errors here in DrivetrainCommand?");
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        time.start();
        System.out.println("Is the initialize method working");
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        DrivetrainPolicy.powerLeft = -1;
        DrivetrainPolicy.powerRight = -1;
        m_drivetrainSubsystem.run();
        System.out.println("Is the execute method working?");
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        time.stop();
        DrivetrainPolicy.powerLeft = 0;
        DrivetrainPolicy.powerRight = 0;
        m_drivetrainSubsystem.run();

    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        if(time.get()>=3.0){
            return true;
        }
        return false;
    }
}
