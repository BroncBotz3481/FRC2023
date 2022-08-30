/****************************** Header ******************************\
Class Name: RobotContainer
File Name: RobotContainer.java
Summary: Contains robot button bindings with commands, and autonomous commands
Project: BroncBotzFRC2023
Copyright (c) BroncBotz.
All rights reserved.

Author(s): Dylan Watson
Email: dylantrwatson@gmail.com
\********************************************************************/

package frc.robot.daydream.robotcontainer;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.daydream.commands.ClimberCommand;
import frc.robot.daydream.commands.DrivetrainCommand;
import frc.robot.daydream.commands.IndexCommand;
import frc.robot.daydream.commands.IntakeCommand;
import frc.robot.daydream.commands.ShooterCommand;
import frc.robot.daydream.subsystems.climber.ClimberSubsystem;
import frc.robot.daydream.subsystems.drivetrain.DrivetrainSubsystem;
import frc.robot.daydream.subsystems.index.IndexSubsystem;
import frc.robot.daydream.subsystems.intake.IntakeSubsystem;
import frc.robot.daydream.subsystems.shooter.ShooterSubsystem;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.commands.ExampleCommand;
import edu.wpi.first.wpilibj2.command.Command;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  private final ClimberSubsystem m_climberSubsystem = new ClimberSubsystem();

  private final ClimberCommand m_climberCommand = new ClimberCommand(m_climberSubsystem);

  private final DrivetrainSubsystem m_drivetrainSubsystem = new DrivetrainSubsystem();
  
  private final DrivetrainCommand m_driveTrainCommand = new DrivetrainCommand(m_drivetrainSubsystem);

  private final IndexSubsystem m_indexSubsystem = new IndexSubsystem();

  private final IndexCommand m_indexCommand = new IndexCommand(m_indexSubsystem);

  private final IntakeSubsystem m_intakeSubsystem = new IntakeSubsystem();

  private final IntakeCommand m_intakeCommand = new IntakeCommand(m_intakeSubsystem);

  private final ShooterSubsystem m_shooterSubsystem = new ShooterSubsystem();

  private final ShooterCommand m_shooterCommand = new ShooterCommand(m_shooterSubsystem);
  
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {}

  /**--------------------------------------------------------------------------------------------
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}