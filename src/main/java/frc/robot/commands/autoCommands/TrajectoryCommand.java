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

import edu.wpi.first.math.controller.RamseteController;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.DifferentialDriveWheelSpeeds;
import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.drivetrain.DrivetrainPolicy;
import frc.robot.subsystems.drivetrain.DrivetrainSubsystem;


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

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        timer.start();
        timer.reset();
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
