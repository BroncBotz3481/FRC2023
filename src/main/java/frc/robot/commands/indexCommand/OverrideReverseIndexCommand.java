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


package frc.robot.commands.indexCommand;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.index.IndexPolicy;
import frc.robot.subsystems.index.IndexSubsystem;
import frc.robot.subsystems.intake.IntakePolicy;
import frc.robot.subsystems.intake.IntakeSubsystem;

/**
 * An example command that uses an example subsystem.
 */
public class OverrideReverseIndexCommand extends CommandBase {
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    private final IndexSubsystem m_indexSubsystem;
    private final IntakeSubsystem m_intakeSubsystem;

    /**
     * Creates a new ExampleCommand.
     *
     * @param subsystem The subsystem used by this command.
     */
    public OverrideReverseIndexCommand(IndexSubsystem subsystem, IntakeSubsystem subsystem2) {
        m_indexSubsystem = subsystem;
        m_intakeSubsystem = subsystem2;
        
        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(subsystem, subsystem2);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        IndexPolicy.overridePressurePad = true;
    }
    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        m_indexSubsystem.runIndex(0.5);
        m_intakeSubsystem.runMotor(-0.5);
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        m_indexSubsystem.stopIndex();
        m_intakeSubsystem.stopMotor();
        IndexPolicy.overridePressurePad = false;
    }
    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
//        if(IndexPolicy.indexFull()){
//            return true;
//        }
        return false;
    }
}
