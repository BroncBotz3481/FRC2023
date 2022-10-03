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


package frc.robot.commands.climberCommand;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.climber.ClimberPolicy;
import frc.robot.subsystems.climber.ClimberSubsystem;
import java.util.function.DoubleSupplier;

////

/**
 * An example command that uses an example subsystem.
 */
public class LowerClimbCommand extends CommandBase {
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    private final ClimberSubsystem m_climberSubsystem;
    private final DoubleSupplier m_rightpower, m_leftpower;
    /**
     * Creates a new ExampleCommand.
     *
     * @param subsystem The subsystem used by this command.
     */
    public LowerClimbCommand(ClimberSubsystem subsystem, DoubleSupplier rightPower, DoubleSupplier leftPower) {
        m_climberSubsystem = subsystem;
        m_rightpower = rightPower;
        m_leftpower = leftPower;
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
        ClimberPolicy.rightPowerClimb = m_rightpower.getAsDouble();
        ClimberPolicy.leftPowerClimb = m_leftpower.getAsDouble();
        m_climberSubsystem.runRightMotor();
        m_climberSubsystem.runLeftMotor();
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        m_climberSubsystem.stopRightMotor();
        m_climberSubsystem.stopLeftMotor();
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
}
