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
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.daydream.commands.*;
import frc.robot.daydream.subsystems.climber.ClimberSubsystem;
import frc.robot.daydream.subsystems.drivetrain.DrivetrainSubsystem;
import frc.robot.daydream.subsystems.index.IndexSubsystem;
import frc.robot.daydream.subsystems.intake.IntakeSubsystem;
import frc.robot.daydream.subsystems.shooter.ShooterSubsystem;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
    private final ClimberSubsystem m_climberSubsystem = new ClimberSubsystem();
    private final DrivetrainSubsystem m_drivetrainSubsystem = new DrivetrainSubsystem();
    // The robot's subsystems and commands are defined here...

    //************SUBSYSTEMS*************************************************************/
    //private DrivetrainSubsystem m_leftpower = new DrivetrainSubsystem();
    private final IndexSubsystem m_indexSubsystem = new IndexSubsystem();
    private final IntakeSubsystem m_intakeSubsystem = new IntakeSubsystem();
    private final ShooterSubsystem m_shooterSubsystem = new ShooterSubsystem();
    public XboxController controller0;
    public XboxController controller1;

    /**
     * The container for the robot. Contains subsystems, OI devices, and commands.
     */
    public RobotContainer() {
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


        m_drivetrainSubsystem.setDefaultCommand(new DrivetrainCommand(m_drivetrainSubsystem, controller0::getLeftY, controller0::getRightY));
        m_indexSubsystem.setDefaultCommand(new StopIndexCommand(m_indexSubsystem));
        m_intakeSubsystem.setDefaultCommand(new RaiseAndStopCommand(m_intakeSubsystem));
        m_shooterSubsystem.setDefaultCommand(new StopShooterCommand(m_shooterSubsystem));
        new Trigger(controller1::getAButton).whenActive(new ReverseIndexCommand(m_indexSubsystem));
        new Trigger(controller1::getBButton).whenActive(new HighShotCommand(m_shooterSubsystem));
        new Trigger(controller1::getXButton).whenActive(new LowerAndRejectCommand(m_intakeSubsystem));
        new Trigger(controller1::getYButton).whenActive(new LowShotCommand(m_shooterSubsystem));
        new Trigger(controller1::getRightBumper).whenActive(new RaiseAndStopCommand(m_intakeSubsystem));
        new Trigger(controller1::getAButton).whenInactive(new StopIndexCommand(m_indexSubsystem));
        new Trigger(controller1::getBButton).whenInactive(new StopShooterCommand(m_shooterSubsystem));
        new Trigger(controller1::getXButton).whenInactive(new StopIntakeCommand(m_intakeSubsystem));
        new Trigger(controller1::getYButton).whenInactive(new StopShooterCommand(m_shooterSubsystem));
        new Trigger(controller1::getRightBumper).whenInactive(new StopIntakeCommand(m_intakeSubsystem));


    }

    /**
     * --------------------------------------------------------------------------------------------
     * Use this to pass the autonomous command to the main {@link Robot} class.
     *
     * @return the command to run in autonomous
     */
    public Command getAutonomousCommand() {
        // An ExampleCommand will run in autonomous
        return null;
        // return m_runIndexCommand;
    }

}