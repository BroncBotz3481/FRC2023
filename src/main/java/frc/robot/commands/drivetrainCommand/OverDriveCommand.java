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


package frc.robot.commands.drivetrainCommand;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.drivetrain.DrivetrainPolicy;
import frc.robot.subsystems.drivetrain.DrivetrainSubsystem;

import java.util.function.DoubleSupplier;


/**
 * An example command that uses an example subsystem.
 */
public class OverDriveCommand extends CommandBase {
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})

    /**
     * Creates a new ExampleCommand.
     *
     * @param subsystem The subsystem used by this command.
     */
    public OverDriveCommand() {
        // Use addRequirements() here to declare subsystem dependencies.

    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        DrivetrainPolicy.forwardPowerScale = 1.0;

    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
    ;
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        DrivetrainPolicy.forwardPowerScale = 0.85;

    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
}
