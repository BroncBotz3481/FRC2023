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

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.index.IndexSubsystem;
import frc.robot.subsystems.index.IndexPolicy;

/**
 * An example command that uses an example subsystem.
 */
public class BallToPressurePad extends CommandBase {
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    private final IndexSubsystem m_indexSubsystem;

    /**
     * Creates a new ExampleCommand.
     *
     * @param subsystem The subsystem used by this command.
     */
    public BallToPressurePad(IndexSubsystem subsystem) {
        m_indexSubsystem = subsystem;
        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(subsystem);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        m_indexSubsystem.runIndex(-0.5);
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        m_indexSubsystem.stopIndex();
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        if(IndexPolicy.indexFull()){
            return true;
        }
        return false;
    }
}
