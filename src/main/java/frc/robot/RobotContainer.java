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

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.math.trajectory.TrajectoryConfig;
import edu.wpi.first.math.trajectory.TrajectoryGenerator;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.SwerveControllerCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.SwerveCommands.SwerveJoystickCmd;
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
import frc.robot.subsystems.swerve.SwerveSubsystem;

import java.util.List;

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
    private final SwerveSubsystem swerveSubsystem = new SwerveSubsystem();
    private final Joystick driverJoytick = new Joystick(Constants.OIConstants.kDriverControllerPort);
    public XboxController controller0;
    public XboxController controller1;

    /**
     * The container for the robot. Contains subsystems, OI devices, and commands.
     */
    public RobotContainer() {
        controller0 = new XboxController(0);
        controller1 = new XboxController(1);
        swerveSubsystem.setDefaultCommand(new SwerveJoystickCmd(
                swerveSubsystem,
                () -> -driverJoytick.getRawAxis(Constants.OIConstants.kDriverYAxis), // Constants???? or OIConstants?
                () -> driverJoytick.getRawAxis(OIConstants.kDriverXAxis),
                () -> driverJoytick.getRawAxis(OIConstants.kDriverRotAxis),
                () -> !driverJoytick.getRawButton(OIConstants.kDriverFieldOrientedButtonIdx)));

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
            
        new Trigger(controller1::getYButton).whileActiveContinuous(new LowShotCommand(m_shooterSubsystem,m_indexSubsystem));
        new Trigger(controller1::getLeftBumper).whileActiveContinuous(new ParallelCommandGroup(
            new ReverseIndexCommand(m_indexSubsystem), new LowerAndSuckCommand(m_intakeSubsystem)));

        new JoystickButton(driverJoytick, 2).whenPressed(() -> swerveSubsystem.zeroHeading()); // NEW


    }

    /**
     * --------------------------------------------------------------------------------------------
     * Use this to pass the autonomous command to the main {@link Robot} class.
     *
     * @return the command to run in autonomous
     */
    public Command getAutonomousCommand() {
        // 1. Create trajectory settings
        TrajectoryConfig trajectoryConfig = new TrajectoryConfig(
                Constants.AutoConstants.kMaxSpeedMetersPerSecond, //Import?
                AutoConstants.kMaxAccelerationMetersPerSecondSquared)
                .setKinematics(DriveConstants.kDriveKinematics); //Import?

        // 2. Generate trajectory
        Trajectory trajectory = TrajectoryGenerator.generateTrajectory(
                new Pose2d(0, 0, new Rotation2d(0)),
                List.of(
                        new Translation2d(1, 0),
                        new Translation2d(1, -1)),
                new Pose2d(2, -1, Rotation2d.fromDegrees(180)),
                trajectoryConfig);

        // 3. Define PID controllers for tracking trajectory
        PIDController xController = new PIDController(AutoConstants.kPXController, 0, 0);
        PIDController yController = new PIDController(AutoConstants.kPYController, 0, 0);
        ProfiledPIDController thetaController = new ProfiledPIDController(
                AutoConstants.kPThetaController, 0, 0, AutoConstants.kThetaControllerConstraints);
        thetaController.enableContinuousInput(-Math.PI, Math.PI);

        // 4. Construct command to follow trajectory
        SwerveControllerCommand swerveControllerCommand = new SwerveControllerCommand(
                trajectory,
                swerveSubsystem::getPose,
                DriveConstants.kDriveKinematics,
                xController,
                yController,
                thetaController,
                swerveSubsystem::setModuleStates,
                swerveSubsystem);

        // 5. Add some init and wrap-up, and return everything
        return new SequentialCommandGroup(
                new InstantCommand(() -> swerveSubsystem.resetOdometry(trajectory.getInitialPose())), //Import?
                swerveControllerCommand,
                new InstantCommand(() -> swerveSubsystem.stopModules()));
    }
}