/****************************** Header ******************************\
 Class Name: IndexCommand extends CommandBase
 File Name: IndexCommand.java
 Summary: Practice
 Project: BroncBotzFRC2023
 Copyright (c) BroncBotz.
 All rights reserved.

 Author(s): Shruti Venkat
 Email: shruti.venkat05@gmail.com
 \********************************************************************/


package frc.robot.ShrutiInterfacePractice.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.ShrutiInterfacePractice.subsystems.index.IndexSubsystem;


/**
 * An example command that uses an example subsystem.
 */
public class IndexCommand extends CommandBase {
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    private final IndexSubsystem m_IndexSubsystem;

    /**
     * Creates a new ExampleCommand.
     *
     * @param subsystem The subsystem used by this command.
     */
    public IndexCommand(IndexSubsystem subsystem) {
        m_IndexSubsystem = subsystem;
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
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
}
