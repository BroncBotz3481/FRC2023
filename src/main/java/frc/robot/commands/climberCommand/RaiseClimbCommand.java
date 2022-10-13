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

////

package frc.robot.commands.climberCommand;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.climber.ClimberPolicy;
import frc.robot.subsystems.climber.ClimberSubsystem;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

/**
 * An example command that uses an example subsystem.
 */
public class RaiseClimbCommand extends CommandBase {
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    private final ClimberSubsystem m_climberSubsystem;

    private BooleanSupplier rightPower, leftPower;

    /**
     * Creates a new ExampleCommand.
     *ss
     * @param subsystem The subsystem used by this command.
     */
    public RaiseClimbCommand(ClimberSubsystem subsystem, BooleanSupplier powerRight, BooleanSupplier powerLeft) {
        m_climberSubsystem = subsystem;
        rightPower = powerRight;
        leftPower = powerLeft;
        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(subsystem);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        ClimberPolicy.leftPowerClimb = 0;
        ClimberPolicy.rightPowerClimb = 0;
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        if(rightPower.getAsBoolean())
        {
            m_climberSubsystem.runRightMotor(-1.0);

        }

        if(leftPower.getAsBoolean()){


            m_climberSubsystem.runLeftMotor(-1.0);
        }

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
