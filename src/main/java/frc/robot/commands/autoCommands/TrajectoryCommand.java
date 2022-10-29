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


package frc.robot.commands.autoCommands;

import java.util.ArrayList;

import edu.wpi.first.math.controller.RamseteController;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.DifferentialDriveWheelSpeeds;
import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.drivetrain.DrivetrainPolicy;
import frc.robot.subsystems.drivetrain.DrivetrainSubsystem;
import edu.wpi.first.math.trajectory.TrajectoryConfig;
import edu.wpi.first.math.trajectory.TrajectoryGenerator;
import edu.wpi.first.math.util.Units;

/**
 * An example command that uses an example subsystem.
 */
public class TrajectoryCommand extends CommandBase {
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    private final DrivetrainSubsystem m_drivetrainSubsystem;

    private final Timer timer;
    private final RamseteController m_ramseteController;
    private Trajectory autoTrajectory;
    private Trajectory.State currentGoal;
    private ChassisSpeeds adjustedSpeeds;
    private DifferentialDriveWheelSpeeds wheelSpeeds;
    private TrajectoryConfig trajectoryConfig;
    /**
     * Creates a new ExampleCommand.
     *
     * @param subsystem The subsystem used by this command.
     */
    public TrajectoryCommand(DrivetrainSubsystem subsystem, RamseteController ramseteController) {
      
        timer = new Timer();
        m_ramseteController = ramseteController;
        m_drivetrainSubsystem = subsystem;
        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(subsystem);
        //addRequirements(ramseteController);


    }

    public void generateTrajectory(){

        //Intake second ball
        var Start = new Pose2d(0, 0, Rotation2d.fromDegrees(0));
        var intakeBallTwo = new Pose2d(0, 0, Rotation2d.fromDegrees(0));

        var interiorWaypoints = new ArrayList<Translation2d>();
        interiorWaypoints.add(new Translation2d(0,0));

        TrajectoryConfig config = new TrajectoryConfig(0,0);
        config.setReversed(true);

        var trajectory1 = TrajectoryGenerator.generateTrajectory(Start, 
        interiorWaypoints, intakeBallTwo, config);

        //Shoot first two balls and intake third ball
        var shootBallOneTwo = new Pose2d(0, 0, Rotation2d.fromDegrees(0));
        var intakeBallThree = new Pose2d(0, 0, Rotation2d.fromDegrees(0));

        interiorWaypoints.add(new Translation2d(0,0));

        config = new TrajectoryConfig(0,0);
        config.setReversed(true);

        var trajectory2 = TrajectoryGenerator.generateTrajectory(shootBallOneTwo, 
        interiorWaypoints, intakeBallThree, config);

        var trajectory12 = trajectory1.concatenate(trajectory2);

        //Intake ball 4 and shoot balls 3 and 4
        var intakeBallFour = new Pose2d(0, 0, Rotation2d.fromDegrees(0));
        var shootBallThreeFour = new Pose2d(0, 0, Rotation2d.fromDegrees(0));

        interiorWaypoints.add(new Translation2d(0,0));

        config = new TrajectoryConfig(0,0);
        config.setReversed(true);

        var trajectory3 = TrajectoryGenerator.generateTrajectory(intakeBallFour, 
        interiorWaypoints, shootBallThreeFour, config);

        var trajectory123 = trajectory12.concatenate(trajectory3);

        //Intake balls 5 and 6 and shoot them
        var intakeBallFive = new Pose2d(0, 0, Rotation2d.fromDegrees(0));
        var intakeShootBallFiveSix = new Pose2d(0, 0, Rotation2d.fromDegrees(0));

        interiorWaypoints.add(new Translation2d(0,0));

        config = new TrajectoryConfig(0,0);
        config.setReversed(true);

        var trajectory4 = TrajectoryGenerator.generateTrajectory(intakeBallFive, 
        interiorWaypoints, intakeShootBallFiveSix, config);

        var finaltrajectory = trajectory123.concatenate(trajectory4);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        timer.start();
        timer.reset();
        trajectoryConfig.setStartVelocity(0);
        trajectoryConfig.setReversed(true);
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        currentGoal = autoTrajectory.sample(timer.get());
        adjustedSpeeds = m_ramseteController.calculate(DrivetrainPolicy.driveOdometry.getPoseMeters(), currentGoal);
        wheelSpeeds = DrivetrainPolicy.driveKinematics.toWheelSpeeds(adjustedSpeeds);
        new DifferentialDriveWheelSpeeds(wheelSpeeds.leftMetersPerSecond, wheelSpeeds.rightMetersPerSecond);
        m_drivetrainSubsystem.set(wheelSpeeds.leftMetersPerSecond, wheelSpeeds.rightMetersPerSecond);
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        trajectoryConfig.setEndVelocity(0);
        timer.stop();
        timer.reset();
      
    }


    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        if(timer.get()>=4){
            return true;
        }
        return false;
    }
}
