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

import frc.robot.daydream.subsystems.climber.ClimberPolicy;
import frc.robot.daydream.subsystems.climber.ClimberSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class LowerHighClimb extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final ClimberSubsystem m_climberSubsystem;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public LowerHighClimb(ClimberSubsystem subsystem) {
    m_climberSubsystem = subsystem;
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
    ClimberPolicy.leftPowerClimb = -0.5;
    ClimberPolicy.rightPowerClimb = -0.5;
    m_climberSubsystem.runLeftMotor();
    m_climberSubsystem.runRightMotor();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_climberSubsystem.stopLeftMotor();
    m_climberSubsystem.stopRightMotor();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
