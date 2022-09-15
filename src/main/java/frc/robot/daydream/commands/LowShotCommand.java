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

import frc.robot.daydream.subsystems.index.IndexPolicy;
import frc.robot.daydream.subsystems.shooter.ShooterPolicy;
import frc.robot.daydream.subsystems.shooter.ShooterSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class LowShotCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final ShooterSubsystem m_shooterSubsystem;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public LowShotCommand(ShooterSubsystem subsystem) {
    m_shooterSubsystem = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    IndexPolicy.overridePressurePad = true;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    ShooterPolicy.powerShooter = 0.4;
    m_shooterSubsystem.shoot();


  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    IndexPolicy.overridePressurePad = false;
    m_shooterSubsystem.stopShooter();

  }


  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
