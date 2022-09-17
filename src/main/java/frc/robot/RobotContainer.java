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
//import edu.wpi.first.wpilibj2.command.button.Trigger;

import frc.robot.daydream.commands.DrivetrainCommand;
import frc.robot.daydream.commands.HighClimb;
import frc.robot.daydream.commands.HighShotCommand;
import frc.robot.daydream.commands.LowClimb;
import frc.robot.daydream.commands.RaiseAndStopCommand;
import frc.robot.daydream.commands.ReverseIndexCommand;
import frc.robot.daydream.commands.LowShotCommand;
import frc.robot.daydream.commands.LowerAndRejectCommand;
import frc.robot.daydream.commands.LowerAndSuckCommand;
import frc.robot.daydream.commands.LowerHighClimb;
import frc.robot.daydream.commands.LowerIntake;
import frc.robot.daydream.commands.LowerLowClimb;
import frc.robot.daydream.commands.RaiseAndStopCommand;
import frc.robot.daydream.commands.RunIndexCommand;
import frc.robot.daydream.subsystems.climber.ClimberSubsystem;
import frc.robot.daydream.subsystems.drivetrain.DrivetrainSubsystem;
import frc.robot.daydream.subsystems.index.IndexSubsystem;
import frc.robot.daydream.subsystems.intake.IntakeSubsystem;
import frc.robot.daydream.subsystems.shooter.ShooterSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  public XboxController controller0; 
  public XboxController controller1; 
  // The robot's subsystems and commands are defined here...

  //************SUBSYSTEMS*************************************************************/

  private final ClimberSubsystem m_climberSubsystem = new ClimberSubsystem();
  private final DrivetrainSubsystem m_drivetrainSubsystem = new DrivetrainSubsystem();
  //private DrivetrainSubsystem m_leftpower = new DrivetrainSubsystem();
  private final IndexSubsystem m_indexSubsystem = new IndexSubsystem();
  private final IntakeSubsystem m_intakeSubsystem = new IntakeSubsystem();
  private final ShooterSubsystem m_shooterSubsystem = new ShooterSubsystem();

  //************COMMANDS***************************************************************/
  //climbs
  private final HighClimb m_highClimbCommand = new HighClimb(m_climberSubsystem);
  private final LowerHighClimb m_lowerHighClimb = new LowerHighClimb(m_climberSubsystem);

  //intake
  private final LowerIntake m_lowerIntakeCommand = new LowerIntake(m_intakeSubsystem);
  private final LowerAndRejectCommand m_lowerAndRejectCommand = new LowerAndRejectCommand(m_intakeSubsystem);
  private final LowerAndSuckCommand m_lowerAndSuckCommand = new LowerAndSuckCommand(m_intakeSubsystem);
  private final RaiseAndStopCommand m_raiseAndStopCommand = new RaiseAndStopCommand(m_intakeSubsystem);

  //shooter
  private final LowShotCommand m_lowShotCommand = new LowShotCommand(m_shooterSubsystem);
  private final HighShotCommand m_highShotCommand = new HighShotCommand(m_shooterSubsystem);

  //index
  private final RunIndexCommand m_runIndexCommand = new RunIndexCommand(m_indexSubsystem);
  private final ReverseIndexCommand m_reverseIndexCommand = new ReverseIndexCommand(m_indexSubsystem);

  //************************************************************************************/

  
  //private static final Joystick auxController; 

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings 
    controller0 = new XboxController(0);
    controller1 = new XboxController(1);
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

    //Driver
    m_drivetrainSubsystem.setDefaultCommand(new DrivetrainCommand(m_drivetrainSubsystem, controller0::getLeftY, controller0::getRightY));
    m_intakeSubsystem.setDefaultCommand(m_lowerIntakeCommand);
    final JoystickButton yButton = new JoystickButton(controller0, 0);
    final JoystickButton bButton = new JoystickButton(controller0, 1);
    final JoystickButton aButton = new JoystickButton(controller0, 2);
    final JoystickButton xButton = new JoystickButton(controller0, 3);
    

      yButton.whenPressed(m_highClimbCommand);
      xButton.whenPressed(m_lowerHighClimb);
    
      //Shooter
      final JoystickButton yButton2 = new JoystickButton(controller1, 0);
      final JoystickButton bButton2 = new JoystickButton(controller1, 1);
      final JoystickButton aButton2 = new JoystickButton(controller1, 2);
      final JoystickButton xButton2 = new JoystickButton(controller1, 3);
      final JoystickButton leftShoulderButton = new JoystickButton(controller1, 4);
      final JoystickButton rightShoulderButton = new JoystickButton(controller1, 5);
      final JoystickButton rightTrigger = new JoystickButton(controller1, 7);
      yButton2.whenPressed(m_lowShotCommand);
      bButton2.whenPressed(m_highShotCommand); //haven't done shooter (especially PID)
      aButton2.whenActive(m_reverseIndexCommand);
      xButton2.whenPressed(m_lowerAndRejectCommand);
      leftShoulderButton.whenPressed(m_lowerAndSuckCommand);
      rightShoulderButton.whenPressed(m_runIndexCommand);
      rightTrigger.whileHeld(m_raiseAndStopCommand);

      
      // bButton.whenPressed(m_lowerIntakeCommand);
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

    return m_runIndexCommand;
  }
  
}