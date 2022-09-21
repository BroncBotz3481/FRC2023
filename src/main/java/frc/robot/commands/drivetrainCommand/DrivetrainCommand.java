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
public class DrivetrainCommand extends CommandBase {
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    private final DrivetrainSubsystem m_drivetrainSubsystem;
    private final DoubleSupplier m_leftpower, m_rightpower;


    /**
     * Creates a new ExampleCommand.
     *
     * @param subsystem The subsystem used by this command.
     */
    public DrivetrainCommand(DrivetrainSubsystem subsystem, DoubleSupplier leftpower, DoubleSupplier rightpower) {
        m_drivetrainSubsystem = subsystem;
        m_leftpower = leftpower;
        m_rightpower = rightpower;
        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(subsystem);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {

    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        DrivetrainPolicy.powerLeft = m_leftpower.getAsDouble();
        DrivetrainPolicy.powerRight = m_rightpower.getAsDouble();
        m_drivetrainSubsystem.run();
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        DrivetrainPolicy.powerLeft = 0;
        DrivetrainPolicy.powerRight = 0;
        m_drivetrainSubsystem.run();

    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
}
