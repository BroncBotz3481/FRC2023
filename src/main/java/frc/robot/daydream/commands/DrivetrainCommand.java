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


package frc.robot.daydream.commands;

import frc.robot.daydream.subsystems.drivetrain.DrivetrainSubsystem;
import frc.robot.daydream.subsystems.drivetrain.DrivetrainPolicy;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.Timer;

/** An example command that uses an example subsystem. */
public class DrivetrainCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final DrivetrainSubsystem m_driveTrainSubsystem;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public DrivetrainCommand(DrivetrainSubsystem subsystem) {
    m_driveTrainSubsystem = subsystem;
    DrivetrainPolicy.time = new Timer();
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    DrivetrainPolicy.time.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_driveTrainSubsystem.run();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    DrivetrainPolicy.powerLeft = 0;
    DrivetrainPolicy.powerRight = 0;
    m_driveTrainSubsystem.run();
    DrivetrainPolicy.time.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    DrivetrainPolicy.time.get();
    return false;
  }
}