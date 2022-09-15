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

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.daydream.commands.DrivetrainCommand;
//import frc.robot.daydream.commands.IndexCommand;
//import frc.robot.daydream.commands.RaiseAndStopCommand;
import frc.robot.daydream.commands.LowShotCommand;
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
  public XboxController controller1;
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final ClimberSubsystem m_climberSubsystem = new ClimberSubsystem();
  private final DrivetrainSubsystem m_drivetrainSubsystem = new DrivetrainSubsystem();
  //private DrivetrainSubsystem m_leftpower = new DrivetrainSubsystem();
  private final IndexSubsystem m_indexSubsystem = new IndexSubsystem();
  private final IntakeSubsystem m_intakeSubsystem = new IntakeSubsystem();
  private final ShooterSubsystem m_shooterSubsystem = new ShooterSubsystem();
  
  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);
 // private final DrivetrainCommand m_driveTrainCommand = new DrivetrainCommand(m_drivetrainSubsystem);
  //private final RunIndexCommand m_indexCommand = new RunIndexCommand(m_indexSubsystem);
 // private final RaiseAndStopCommand m_intakeCommand = new RaiseAndStopCommand(m_intakeSubsystem);
  private final LowShotCommand m_shooterCommand = new LowShotCommand(m_shooterSubsystem);
  private final DrivetrainCommand m_drivetrainCommand = new DrivetrainCommand(m_drivetrainSubsystem, controller1::getLeftY, controller1::getRightY);
  //private final DrivetrainCommand m_drivetrainCommand = new DrivetrainCommand(m_leftpower);

  
  //private static final Joystick auxController; 

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    controller1 = new XboxController(0);    
    //auxController = new Joystick(0);  
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    //final JoystickButton leftJoystick = new JoystickButton(controller1, 1);
    //final JoystickButton rightJoystick = new JoystickButton(controller1, 2);
    m_drivetrainSubsystem.setDefaultCommand(m_drivetrainCommand);
    // leftJoystick.
    //final JoystickButton auxButtonA = new JoystickButton(, 1);
  }

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