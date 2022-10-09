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
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.autoCommands.AutoPIDShot;
import frc.robot.commands.climberCommand.RaiseClimbCommand;
import frc.robot.commands.climberCommand.LowerClimbCommand;
import frc.robot.commands.drivetrainCommand.DrivetrainCommand;
import frc.robot.commands.autoCommands.ReverseDriveCommand;
import frc.robot.commands.indexCommand.ReverseIndexCommand;
import frc.robot.commands.indexCommand.StopIndexCommand;
import frc.robot.commands.intakeCommand.LowerAndSuckCommand;
import frc.robot.commands.intakeCommand.RaiseAndStopCommand;
import frc.robot.commands.intakeCommand.StopIntakeCommand;
import frc.robot.commands.shooterCommand.HighShotCommand;
import frc.robot.commands.shooterCommand.LowShotCommand;
import frc.robot.commands.shooterCommand.StopShooterCommand;
import frc.robot.commands.climberCommand.StopClimberCommand;
import frc.robot.commands.indexCommand.OverrideReverseIndexCommand;
import frc.robot.commands.indexCommand.OverrideRunIndexCommand;
import frc.robot.subsystems.climber.ClimberSubsystem;
import frc.robot.subsystems.drivetrain.DrivetrainSubsystem;
import frc.robot.subsystems.index.IndexSubsystem;
import frc.robot.subsystems.intake.IntakeSubsystem;
import frc.robot.subsystems.shooter.ShooterSubsystem;
import frc.robot.commands.intakeCommand.LowerIntake;
import frc.robot.commands.indexCommand.RunIndexCommand;
import frc.robot.commands.drivetrainCommand.OverdriveCommand;

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
        m_climberSubsystem.setDefaultCommand(new StopClimberCommand(m_climberSubsystem));
        m_indexSubsystem.setDefaultCommand(new StopIndexCommand(m_indexSubsystem));
        m_intakeSubsystem.setDefaultCommand(new RaiseAndStopCommand(m_intakeSubsystem));
        m_shooterSubsystem.setDefaultCommand(new StopShooterCommand(m_shooterSubsystem));
        new Trigger(controller0::getRightBumper).or(new Trigger(controller0:: getLeftBumper)).whileActiveContinuous(
                new RaiseClimbCommand(m_climberSubsystem, controller0::getRightBumper, controller0::getLeftBumper));
        new Trigger(()->{return controller0.getRightTriggerAxis() > 0.05;}).or(
                new Trigger(()->{return controller0.getLeftTriggerAxis() > 0.05;})).whileActiveContinuous(
                new LowerClimbCommand(m_climberSubsystem, controller0::getRightTriggerAxis, controller0::getLeftTriggerAxis));

        new Trigger(controller1::getAButton).whileActiveContinuous(new OverrideReverseIndexCommand(m_indexSubsystem, m_intakeSubsystem));
        new Trigger(controller1::getBButton).whileActiveContinuous(new HighShotCommand(m_shooterSubsystem, m_indexSubsystem));
        new Trigger(controller1::getRightBumper).whileActiveContinuous(new OverrideRunIndexCommand(m_indexSubsystem));


        ///////////
        new Trigger(()->{return controller0.getRightTriggerAxis() > 0.05;}).and(new Trigger(controller0::getRightStickButtonPressed)).and(
        new Trigger(()->{return controller0.getLeftTriggerAxis() > 0.05;})).and(new Trigger(controller0::getLeftStickButtonPressed)).whileActiveContinuous(
        new OverdriveCommand(m_drivetrainSubsystem, controller0::getLeftY, controller0::getRightY));
        ///////////
        new Trigger(controller1::getYButton).whileActiveContinuous(new LowShotCommand(m_shooterSubsystem,m_indexSubsystem));
        new Trigger(controller1::getLeftBumper).whileActiveContinuous(new ParallelCommandGroup(
            new ReverseIndexCommand(m_indexSubsystem), new LowerAndSuckCommand(m_intakeSubsystem)));




    }

    /**
     * --------------------------------------------------------------------------------------------
     * Use this to pass the autonomous command to the main {@link Robot} class.
     *
     * @return the command to run in autonomous
     */
    public Command getAutonomousCommand() {
        // An ExampleCommand will run in autonomous
        SequentialCommandGroup m_autoCommand = new SequentialCommandGroup(
                new AutoPIDShot(m_shooterSubsystem,m_indexSubsystem),
                new ReverseDriveCommand(m_drivetrainSubsystem));
        // return m_runIndexCommand;
        return m_autoCommand;
    }

}